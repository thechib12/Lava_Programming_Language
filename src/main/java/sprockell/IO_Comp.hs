module IO_Comp where

import HardwareTypes

subtr g (k,x) _ | x < g       = (k,x) 
                | otherwise   = (k+1,x-g)

divmod g k x = foldl (subtr g) (k,x) [1..9]

to7SD d = case d of
  0 -> [0,1,1,1,1,1,1]
  1 -> [0,0,0,0,1,1,0]
  2 -> [1,0,1,1,0,1,1]
  3 -> [1,0,0,1,1,1,1]
  4 -> [1,1,0,0,1,1,0]
  5 -> [1,1,0,1,1,0,1]
  6 -> [1,1,1,1,1,0,1]
  7 -> [0,0,0,0,1,1,1]
  8 -> [1,1,1,1,1,1,1]
  9 -> [1,1,0,1,1,1,1]

-- =============================================================================================
io state inp = (state', (req,outp))
        where
          (expecting,prevFlag,prevRead, i_nr,n_nr,s_nr)    = state

          i                                 = i_nr
          (n,kn10,n1)                       = n_nr
          (s,ks1000,s100,ks100,s10,ks10,s1) = s_nr

          (kn10',n1')     = divmod 10 0 n
          (ks1000',s100') = divmod 1000 0 s
          (ks100',s10')   = divmod 100 0 s100
          (ks10',s1')     = divmod 10 0 s10

          (expecting', prevFlag', (i', n', s'), nextRead)

                         = case (expecting,prevFlag,inp   ) of  -- (expecting', prevFlag', (i',n',s'), nextRead)
                         --     ---------------------------        ----------------------------------------------
                                (NoExp  ,   _    ,   _    )     -> (Flag    , prevFlag , (i ,n ,s ), Just $ ReadReq 2)
                                (Flag   ,   0    , Just 1 )     -> (SprId   ,    1     , (i ,n ,s ), Just $ ReadReq 3)
                                (Flag   ,   _    , Just f )     -> (Flag    ,    f     , (i ,n ,s ), Just $ ReadReq 2)
                                (SprId  ,   _    , Just i')     -> (N       , prevFlag , (i',n ,s ), Nothing)
                                (N      ,   _    , Just n')     -> (S       , prevFlag , (i ,n',s ), Nothing)
                                (S      ,   _    , Just s')     -> (Flag    , prevFlag , (i ,n ,s'), Just $ ReadReq 2)
                                (_      ,   _    , _      )     -> (expecting,prevFlag , (i ,n ,s ), Nothing)

          req = case nextRead of
                        Just readReq    -> readReq
                        Nothing         -> case prevRead of
                                                ReadReq 3       -> ReadReq 4
                                                ReadReq 4       -> ReadReq 5
                                                ReadReq 5       -> NoRequest
                                                ReadReq _       -> NoRequest            -- <<== ???
                                                NoRequest       -> NoRequest
                                                _               -> error ("req: " ++ show prevRead)

          prevRead' = req

          state' = (expecting',prevFlag',prevRead',  i', (n',kn10',n1'), (s',ks1000',s100',ks100',s10',ks10',s1'))

          outp = [0,i, kn10,n1, ks1000,ks100,ks10,s1]
          -- outp = map to7SD [0,i, kn10,n1, ks1000,ks100,ks10,s1]

-- ==============================================================================================

sim f s [] = []

sim f s (i:is) = o : sim f s' is
                where
                  (s',o) = f s i


test = sim io state0 $ replicate 10 Nothing
        where
          state0 = (Flag,0,NoRequest, 1, (88,0,0), (3916,0,0,0,0,0,0))

{-# LANGUAGE RecordWildCards, TypeSynonymInstances, FlexibleInstances #-}

-- ==============================================================
-- Jan Kuper, Sebastiaan la Fleur, June 2016
-- ==============================================================

module Architecture where

import Prelude
import Debug.Trace

import BasicFunctions
import HardwareTypes
import Sprockell
import System
import Simulation
import ExampleProg

import Eventloop.Core
import Eventloop.DefaultConfiguration
import Eventloop.Types.Events
import Eventloop.Types.System

import qualified Eventloop.Module.Websocket.Canvas as C
import Eventloop.Module.Websocket.Mouse
import Eventloop.Module.Websocket.Keyboard
import Eventloop.Module.BasicShapes
import Eventloop.Utility.Vectors

data ArrowDir = U | D | L | R           deriving (Eq,Show)


canvasId :: C.CanvasId
canvasId = 1

-- =================================================================================
baseshape :: Alpha -> (StrokeLineThickness -> Color -> Maybe Rotation -> Shape) -> Shape
baseshape box primfig = primfig 1 (0,0,0,box) Nothing


showFig fig = [ OutBasicShapes $ DrawShapes canvasId fig ]      -- fig is list of Shapes

red       = (255,  0,  0,255)
green     = (  0,255,  0,255)
blue      = (  0,  0,255,255)
grey      = (160,160,160,255)
black     = (  0,  0,  0,100)
white     = (255,255,255,255)
memColor  = (255,255,153,255)
sprColor  = ( 80,220,220,255)
compColor = (  0,204,102,255)

-- =================================================================================

grMem (x,y) (dx,dy) = Rectangle (Point (x,y)) (dx,dy) memColor

grWrite txt (x,y) col = [ Rectangle (Point (x-28,y)) (56,24) col
                        , Text txt "arial" 16 (Point (x,y+8)) AlignCenter black
                        ]

grWrite' txt (x,y) col = [ Circle (Point (x,y+14)) 20 col -- Rectangle (Point (x-28,y)) (56,30) col
                         , Text txt "arial" 20 (Point (x,y+4)) AlignCenter black
                         ]

memAccess (x,y) req = case req of
                ReadReq a    -> [ Circle (Point (x,y)) 6 blue ]
                WriteReq _ a -> [ Circle (Point (x,y)) 6 red  ]
                _            -> []

-- =========================================================================================

arrow ps =  [ Line (Point $ ps!!0) (Point $ ps!!1) 1 black Nothing
            , arrowPoint (x,y) (x0,y0) 1 black Nothing
            ]
  where
    (x0,y0) = last $ init ps
    (x,y)   = last ps

grComp (x,y) r = Circle (Point (x,y)) r compColor
-- ==================================================================================
arrowShape :: (GrComp, GrComp, Char) -> StrokeLineThickness -> StrokeColor -> [Shape]
arrowShape (p,q,lbl) thick col =

  [ MultiLine (map Point ps)
              thick
              col
              Nothing
  , arrowPoint (x,y) (x0,y0)
              thick
              col
              Nothing
  ]
  where
    ps      = path (p,q,lbl)
    (x0,y0) = last $ init ps
    (x,y)   = last ps

arrowPoint (x0,y0) (x1,y1) = MultiLine [Point (x0,y0), Point (x',y'), Point (x'',y''), Point (x0,y0)]
  where
    dir | x0==x1 && y0<y1   = U
        | x0==x1 && y0>y1   = D
        | x0<x1  && y0==y1  = L
        | x0>x1  && y0==y1  = R
        | otherwise       = error "arrowShape: strange direction"
    (x',x'',y',y'') = case dir of
          U -> (x0-3,x0+3,y0+12,y0+12)
          D -> (x0-3,x0+3,y0-12,y0-12)
          L -> (x0+12,x0+12,y0-3,y0+3)
          R -> (x0-12,x0-12,y0-3,y0+3)

whichInstr pc = map (baseshape 100)
                [ MultiLine [Point (x0-20,y-4), Point (x0+10,y-4), Point (x0+80,yIMm), Point (xIMm,yIMm), Point (xDec,yDec-r)]
                , arrowPoint (xDec,yDec-r) (xIMm,yIMm)
                , MultiLine [Point (xPC-r+3,yPC-12), Point (x0+80,yPC-12), Point (x0+10,y+4), Point (x0-20,y+4)]
                , arrowPoint (x0-20,y+4) (x0+10,y+4)
                ]
  where
    r = 30
    (x0,y0) = (280,25)
    y = y0 + fromIntegral pc * 24
    (xIMm,yIMm) = xy_crds IMm
    (xDec,yDec) = xy_crds Dec
    (xPC ,yPC ) = xy_crds PC

-- ==================================================================================
data GrComp = IMm | Dec | RB | DMem | PC | SP | ALU | AGU | StComp | LdComp | Inp | Snd | Out

path (p,q,x) = case (p,q,x) of

    (IMm ,Dec    ,'-')   -> [(xIMm,yIMm),(xDec,yDec-r)]                                                --

    (Dec ,PC     ,'i')   -> [(xDec-r,yDec+8),(xPC-8,yDec+8),(xPC-8,yPC-r)]                                 -- Immediate Value
    (Dec ,PC     ,'b')   -> [(xDec-r+4,yDec+16),(xPC,yDec+16),(xPC,yPC-r)]                                 -- Branch
    (Dec ,PC     ,'t')   -> [(xDec-r+10,yDec+24),(xPC+8,yDec+24),(xPC+8,yPC-r)]                            -- Target Code

    (Dec ,SP     ,'-')   -> [(xDec+r,yDec-8),(xSP,yDec-8),(xSP,ySP-r)]                                     --
    (Dec ,StComp ,'-')   -> [(xDec+r-4,yDec-16),(xSt+8,yDec-16),(xSt+8,ySt-r)]                                 --
    (Dec ,RB     ,'x')   -> [(xDec-r+10,yDec-24),(xRB+50,yDec-24),(xRB+50,yRB+20),(xRB+r+7,yRB+20)]    -- x-Register
    (Dec ,RB     ,'y')   -> [(xDec-r+4,yDec-16),(xRB+58,yDec-16),(xRB+58,yRB+28),(xRB+r+10,yRB+28)]    -- y-Register
    (Dec ,RB     ,'a')   -> [(xDec-r,yDec-8),(xRB+66,yDec-8),(xRB+66,yRB+250),(xRB+r+10,yRB+250)]      --
    (Dec ,ALU    ,'-')   -> [(xDec-r,yDec),(xALU-8,yDec),(xALU-8,yALU-r)]                                  --
    (Dec ,LdComp ,'c')   -> [(xDec-4,yDec+r),(xLd-8,yLd-r)]                                               -- Load Code
    (Dec ,LdComp ,'i')   -> [(xDec+4,yDec+r),(xLd,yLd-r)]                                                -- Immediate Value
    (Dec ,AGU    ,'c')   -> [(xDec+r,yDec),(xAGU+4,yDec),(xAGU+4,yAGU-r)]          --
    (Dec ,AGU    ,'a')   -> [(xDec+r-2,yDec+8),(xAGU-4,yDec+8),(xAGU-4,yAGU-r)]      --
    (Dec ,Snd    ,'-')   -> [(xDec+r-4,yDec+16),(xDec+r+24,yDec+16),(xDec+r+24,ySnd-4),(xSnd-r,ySnd-4)]          --

    (RB  ,ALU    ,'x')   -> [(xRB+r+10,yRB+36),(xALU+8,yRB+36),(xALU+8,yALU-r)]                                -- x-register
    (RB  ,PC     ,'x')   -> [(xRB+r+10,yRB+36),(xALU+8,yRB+36),(xALU+8,yPC+4),(xPC-r,yPC+4)]                   -- y-register
    (RB  ,StComp ,'y')   -> [(xRB+r+10,yRB+36),(xSt,yRB+36),(xSt,ySt-r)]                                   --
    (RB  ,Snd    ,'y')   -> [(xRB+r+10,yRB+36),(xDec+r+16,yRB+36),(xDec+r+16,ySnd+4),(xSnd-r,ySnd+4)]            --
    (RB  ,ALU    ,'y')   -> [(xRB+r+7,yRB+44),(xALU,yRB+44),(xALU,yALU-r)]                             -- x-register
    (RB  ,PC     ,'y')   -> [(xRB+r+7,yRB+44),(xALU,yRB+44),(xALU,yPC-4),(xPC-r,yPC-4)]                    -- y-register
    (RB  ,AGU    ,'x')   -> [(xRB+r+7,yRB+44),(xAGU-12,yRB+44),(xAGU-12,yAGU-r+3)]                         --

    (DMem,LdComp ,'-')   -> [(xMm-r-10,yMm+100),(xLd+8,yMm+100),(xLd+8,yLd-r)]                         -- Mem  -> Ld

    (PC  ,LdComp ,'-')   -> [(xPC,yPC+r),(xPC,yLd-8),(xLd-r,yLd-8)]                        -- PC   -> Ld

    (SP  ,AGU    ,'-')   -> [(xSP,ySP+r),(xSP,yRB+44),(xAGU+12,yRB+44),(xAGU+12,yAGU-r+3)]                                               -- SP   -> AGU

    (ALU ,LdComp ,'-')   -> [(xALU,yALU+r),(xALU,yLd),(xLd-r,yLd)]               -- ALU  -> Ld

    (AGU ,Snd    ,'-')   -> [(xAGU,yAGU+r),(xSnd,ySnd-r)]                                                  -- AGU  -> Snd
    (AGU ,StComp ,'-')   -> [(xAGU+r,yAGU),(xSt-r,yAGU)]                                     -- AGU  -> St
    (AGU ,DMem   ,'-')   -> [(xAGU,yAGU+r),(xAGU,yMm+92),(xMm-r-10,yMm+92)]                                -- AGU  -> Mem

    (LdComp,RB   ,'-')   -> [(xLd,yLd+r),(xLd,yRB+258),(xRB+r+10,yRB+258)]                                 -- Ld   -> RB

    (StComp,DMem ,'-')   -> [(xSt+r,ySt),(xMm-r-10,ySt)]                                                   -- St   -> Mem

    (Inp  ,LdComp,'-')   -> [(xInp,yInp),(xPC-50,yLd+8),(xLd-r,yLd+8)]                                    -- Inp  -> Ld
    (Inp  ,PC    ,'-')   -> [(xInp,yInp),(xPC-50,yPC+12),(xPC-r+1,yPC+12)]                                -- Inp  -> PC

    (Snd  ,Out   ,'-')   -> [(xSnd,ySnd+r),(xSnd,yOut)]                                                 -- Snd  -> Out

    where
       r = 30
       (x0,y0) = (100,40)

       (xIMm,yIMm) = xy_crds IMm
       (xPC,yPC)   = xy_crds PC
       (xSP,ySP)   = xy_crds SP
       (xRB,yRB)   = xy_crds RB
       (xMm,yMm)   = xy_crds DMem

       (xDec,yDec) = xy_crds Dec
       (xALU,yALU) = xy_crds ALU
       (xSt ,ySt ) = xy_crds StComp
       (xLd ,yLd ) = xy_crds LdComp
       (xAGU,yAGU) = xy_crds AGU
       (xInp,yInp) = xy_crds Inp
       (xSnd,ySnd) = xy_crds Snd
       (xOut,yOut) = xy_crds Out

xy_crds comp = case comp of
    IMm    -> (x0+394,y0+ 60)
    Dec    -> (x0+394,y0+140)
    RB     -> (x0+140,y0+260)
    DMem   -> (x0+670,y0+320)
    PC     -> (x0+340,y0+240)
    SP     -> (x0+540,y0+240)
    ALU    -> (x0+250,y0+360)
    AGU    -> (x0+496,y0+360)
    StComp -> (x0+580,y0+360)
    LdComp -> (x0+398,y0+470)
    Snd    -> (x0+496,y0+470)
    Inp    -> (x0+290,y0+620)
    Out    -> (x0+488,y0+620)
    where
      r = 30
      (x0,y0) = (300,20)



grPC pc = map (baseshape 100) [ Text (show pc) "arial" 16 (Point (xy_crds PC)) AlignCenter red ]

grSP sp = map (baseshape 100) [ Text (show sp) "arial" 16 (Point (xy_crds SP)) AlignCenter red ]

grRegBank vs = map (baseshape 100) [ Text (show v) "arial" 16 (Point (x0,y0+45+i*30)) AlignCenter black   | (i,v) <- zip [0..] vs ]
        where
          (x0,y0) = xy_crds RB

emphRB vs r = [ Circle (Point (x0,y+8)) 12 red
              , Text (show (vs!!r)) "arial" 16 (Point (x0,y)) AlignCenter black
              ]
        where
          (x0,y0) = xy_crds RB
          y = y0+45+fromIntegral r*30

grLocalMem :: LocalMem -> [Shape]
grLocalMem vs = map (baseshape 100) (  [ Text (show v) "arial" 16 (Point (x0+15,y0-15+i*30)) AlignCenter black   | (i,v) <- zip [0..] vs0 ]
                                    ++ [ Text (show v) "arial" 16 (Point (x0+45,y0-15+i*30)) AlignCenter black   | (i,v) <- zip [0..] vs1 ]
                                    )
        where
          (x0,y0) = xy_crds DMem
          n = length vs `div` 2
          (vs0,vs1) = splitAt n vs

emphMem vs r = [ Circle (Point (x0+d,y+8)) 12 red
               , Text (show (vs!!r)) "arial" 16 (Point (x0+d,y)) AlignCenter black
               ]
        where
          (x0,y0) = xy_crds DMem
          y = y0-15+fromIntegral r'*30
          n = length vs `div` 2
          (d,r') | r < n        = (15,r)
                 | otherwise    = (45,r-n)

-- ==================================================================================
bigSprockell = map (baseshape 100) (

        [ Rectangle (Point (x0-300,y0-20)) (1500,800) white
        , Rectangle (Point (x0+70,y0+90)) (730,500) sprColor
        , Rectangle (Point (x0-220,y0-16)) (180,694) sprColor

        , grComp (xRB+10,yRB+32) r, grComp (xRB+10,yRB+250) r, grMem (xRB-20,yRB-24) (40 ,330), Text "Rbnk" "arial" 16 (Point (xRB,yRB)) AlignCenter black  -- Register Bank
        , grComp (xMm-10,yMm+96) r, grComp (xMm-10,ySt) r, grMem (xMm-20,yMm-84) (100,330), Text "Mem"  "arial" 16 (Point (xMm+30,yRB)) AlignCenter black   -- Data Memory
        , grComp (xPC,yPC) r, grMem (xPC-20,yPC-20) (40 ,40 ), Text "PC" "arial" 16 (Point (xPC+2,yPC-18)) AlignCenter black                                -- Program Cunter
        , grComp (xSP,ySP) r, grMem (xSP-20,ySP-20) (40 ,40 ), Text "SP" "arial" 16 (Point (xSP+2,ySP-18)) AlignCenter black                                -- Stack Pointer

        , grComp (xDec,yDec) r, Text "Decode" "arial" 16 (Point (xDec,yDec-6)) AlignCenter black            -- Decode
        , grComp (xALU,yALU) r, Text "ALU"    "arial" 16 (Point (xALU,yALU-6)) AlignCenter black            -- ALU
        , grComp (xSt ,ySt ) r, Text "Store"  "arial" 16 (Point (xSt ,ySt -6)) AlignCenter black            -- Store
        , grComp (xLd ,yLd ) r, Text "Load"   "arial" 16 (Point (xLd ,yLd -6)) AlignCenter black            -- Load
        , grComp (xAGU,yAGU) r, Text "AGU"    "arial" 16 (Point (xAGU,yAGU-6)) AlignCenter black            -- Store
        , grComp (xSnd,ySnd) r, Text "Send"   "arial" 16 (Point (xSnd,ySnd-6)) AlignCenter black            -- Store
        ])

        ++ prog

        ++ arrowShape (Dec   ,PC    ,'i')  1 black
        ++ arrowShape (Dec   ,PC    ,'b')  1 black
        ++ arrowShape (Dec   ,PC    ,'t')  1 black
        ++ arrowShape (Dec   ,SP    ,'-')  1 black
        ++ arrowShape (Dec   ,StComp,'-')  1 black
        ++ arrowShape (Dec   ,RB    ,'x')  1 black
        ++ arrowShape (Dec   ,RB    ,'y')  1 black
        ++ arrowShape (Dec   ,RB    ,'a')  1 black
        ++ arrowShape (Dec   ,ALU   ,'-')  1 black
        ++ arrowShape (Dec   ,LdComp,'c')  1 black
        ++ arrowShape (Dec   ,LdComp,'i')  1 black
        ++ arrowShape (Dec   ,AGU   ,'c')  1 black
        ++ arrowShape (Dec   ,AGU   ,'a')  1 black
        ++ arrowShape (Dec   ,Snd   ,'-')  1 black
        ++ arrowShape (RB    ,ALU   ,'x')  1 black
        ++ arrowShape (RB    ,PC    ,'x')  1 black
        ++ arrowShape (RB    ,StComp,'y')  1 black
        ++ arrowShape (RB    ,Snd   ,'y')  1 black
        ++ arrowShape (RB    ,ALU   ,'y')  1 black
        ++ arrowShape (RB    ,PC    ,'y')  1 black
        ++ arrowShape (RB    ,AGU   ,'x')  1 black
        ++ arrowShape (DMem  ,LdComp,'-')  1 black
        ++ arrowShape (PC    ,LdComp,'-')  1 black
        ++ arrowShape (SP    ,AGU   ,'-')  1 black
        ++ arrowShape (ALU   ,LdComp,'-')  1 black
        ++ arrowShape (AGU   ,Snd   ,'-')  1 black
        ++ arrowShape (AGU   ,StComp,'-')  1 black
        ++ arrowShape (AGU   ,DMem  ,'-')  1 black
        ++ arrowShape (LdComp,RB    ,'-')  1 black
        ++ arrowShape (StComp,DMem  ,'-')  1 black
        ++ arrowShape (Inp   ,LdComp,'-')  1 black
        ++ arrowShape (Inp   ,PC    ,'-')  1 black
        ++ arrowShape (Snd   ,Out   ,'-')  1 black
     where
       r = 30
       (x0,y0) = (300,20)

       (xIMm,yIMm) = xy_crds IMm
       (xPC ,yPC)  = xy_crds PC
       (xSP ,ySP)  = xy_crds SP
       (xRB ,yRB)  = xy_crds RB
       (xMm ,yMm)  = xy_crds DMem

       (xDec,yDec) = xy_crds Dec
       (xALU,yALU) = xy_crds ALU
       (xSt ,ySt ) = xy_crds StComp
       (xLd ,yLd ) = xy_crds LdComp
       (xAGU,yAGU) = xy_crds AGU
       (xInp,yInp) = xy_crds Inp
       (xSnd,ySnd) = xy_crds Snd
       (xOut,yOut) = xy_crds Out


instrHighlight pc = [ baseshape 100 $ Rectangle (Point (x0-76,y0+ fromIntegral pc*24)) (172,24) memColor
                    , prog!!pc
                    ]
                  where
                    (x0,y0) = (160,14)

assInstr (x,y) instr = Text (show instr) "arial" 16 (Point (x,y)) AlignCenter black 1 black Nothing

prog = -- BaseShape (Line (Point (x0-70,y0-20)) (Point (x0-70,y0+650))) 1 black Nothing :
       [ assInstr (x0+ 6,y0    ) $ Load (ImmValue 0) 1
       , assInstr (x0- 2,y0+ 24) $ Store 1 (DirAddr 1)
       , assInstr (x0+ 6,y0+ 48) $ Load (ImmValue 0) 1
       , assInstr (x0- 2,y0+ 72) $ Store 1 (DirAddr 3)
       , assInstr (x0+ 7,y0+ 96) $ ReadInstr (DirAddr 0)
       , assInstr (x0-33,y0+120) $ Receive 1
       , assInstr (x0- 2,y0+144) $ Store 1 (DirAddr 2)
       , assInstr (x0- 3,y0+168) $ Load (DirAddr 1) 1
       , assInstr (x0-44,y0+192) $ Push 1
       , assInstr (x0- 3,y0+216) $ Load (DirAddr 2) 1
       , assInstr (x0-48,y0+240) $ Pop 2
       , assInstr (x0- 8,y0+264) $ Compute Lt 2 1 1
       , assInstr (x0-11,y0+288) $ Branch 1 (Rel 2)
       , assInstr (x0-19,y0+312) $ Jump (Rel 14)
       , assInstr (x0- 3,y0+336) $ Load (DirAddr 1) 1
       , assInstr (x0-44,y0+360) $ Push 1
       , assInstr (x0+ 5,y0+384) $ Load (ImmValue 1) 1
       , assInstr (x0-48,y0+408) $ Pop 2
       , assInstr (x0   ,y0+432) $ Compute Add 2 1 1
       , assInstr (x0- 2,y0+456) $ Store 1 (DirAddr 1)
       , assInstr (x0- 3,y0+480) $ Load (DirAddr 3) 1
       , assInstr (x0-44,y0+504) $ Push 1
       , assInstr (x0- 3,y0+528) $ Load (DirAddr 1) 1
       , assInstr (x0-47,y0+552) $ Pop 2
       , assInstr (x0   ,y0+576) $ Compute Add 2 1 1
       , assInstr (x0- 2,y0+600) $ Store 1 (DirAddr 3)
       , assInstr (x0-11,y0+624) $ Jump (Rel (-19))
       , assInstr (x0-39,y0+648) $ EndProg
       ]
     where
       (x0,y0) = (160,18)


-- =================================================================================



instrShape instr = Text (show instr) "arial" 16 (Point (200,640)) AlignCenter black 1 black Nothing

showInstr (regbank,localMem,sp) inp instr = case instr of

        Compute o rA rB rC  ->    (map (baseshape 100) $ emphRB regbank rC)
                               ++ arrowShape (Dec,RB,'x') 4 grey
                               ++ arrowShape (Dec,RB,'y') 4 grey
                               ++ arrowShape (Dec,RB,'a') 4 grey
                               ++ arrowShape (Dec,ALU,'-') 4 grey
                               ++ arrowShape (Dec,LdComp,'c') 4 grey
                               ++ arrowShape (RB,ALU,'x') 4 red
                               ++ arrowShape (RB,ALU,'y') 4 red
                               ++ arrowShape (ALU,LdComp,'-') 4 red
                               ++ arrowShape (LdComp,RB,'-') 4 red


        Jump t              ->    arrowShape (Dec,PC,'b') 4 grey
                               ++ arrowShape (Dec,PC,'t') 4 grey
                               ++ case t of
                                    Ind r ->    arrowShape (Dec,RB,'y') 4 grey
                                             ++ arrowShape (RB,PC,'y') 4 grey
                                    _     ->    arrowShape (Dec,PC,'i') 4 grey


        Branch reg t        ->    arrowShape (Dec,PC,'b') 4 grey
                               ++ arrowShape (Dec,PC,'t') 4 grey
                               ++ arrowShape (Dec,RB,'x') 4 grey
                               ++ arrowShape (RB,PC,'x') 4 grey
                               ++ case t of
                                    Ind r ->    arrowShape (Dec,RB,'y') 4 grey
                                             ++ arrowShape (RB,PC,'y') 4 grey
                                    _     ->    arrowShape (Dec,PC,'i') 4 grey


        Load (ImmValue v) reg ->    (map (baseshape 100) $ emphRB regbank reg)
                                 ++ arrowShape (Dec,RB,'a') 4 grey
                                 ++ arrowShape (Dec,LdComp,'c') 4 grey
                                 ++ arrowShape (Dec,LdComp,'i') 4 red
                                 ++ arrowShape (LdComp,RB,'-') 4 red


        Load m reg          ->    (map (baseshape 100) $ emphRB regbank reg)
                               ++ arrowShape (Dec,LdComp,'c') 4 grey
                               ++ arrowShape (Dec,AGU,'c') 4 grey
                               ++ arrowShape (AGU,DMem,'-') 4 grey
                               ++ arrowShape (Dec,RB,'a') 4 grey
                               ++ case m of
                                       DirAddr a   ->    arrowShape (Dec,AGU,'a') 4 grey
                                       IndAddr p   ->    arrowShape (Dec,RB,'x') 4 grey
                                                      ++ arrowShape (RB,AGU,'x') 4 grey

                               ++ arrowShape (DMem,LdComp,'-') 4 red
                               ++ arrowShape (LdComp,RB,'-') 4 red


        Store reg m         ->
                                  arrowShape (Dec,StComp,'-') 4 grey
                               ++ arrowShape (Dec,RB,'y') 4 grey
                               ++ arrowShape (Dec,AGU,'c') 4 grey
                               ++ arrowShape (AGU,StComp,'-') 4 grey
                               ++ case m of
                                    ImmValue n ->    []
                                    DirAddr  a ->    arrowShape (Dec,AGU,'a') 4 grey
                                                  ++ (map (baseshape 100) $ emphMem localMem a)
                                    IndAddr  p ->    arrowShape (Dec,RB,'x') 4 grey
                                                  ++ arrowShape (RB,AGU,'x') 4 grey
                                                  ++ (map (baseshape 100) $ emphMem localMem (regbank!!p))
                               ++ arrowShape (RB,StComp,'y') 4 red
                               ++ arrowShape (StComp,DMem,'-') 4 red


        Push reg            ->    (map (baseshape 100) $ emphMem localMem sp) -- <<-- TODO
                               ++ arrowShape (Dec,RB,'y') 4 grey
                               ++ arrowShape (Dec,SP,'-') 4 grey
                               ++ arrowShape (Dec,StComp,'-') 4 grey
                               ++ arrowShape (Dec,AGU,'c') 4 grey
                               ++ arrowShape (SP,AGU,'-') 4 grey
                               ++ arrowShape (AGU,StComp,'-') 4 grey
                               ++ arrowShape (RB,StComp,'y') 4 red
                               ++ arrowShape (StComp,DMem,'-') 4 red

        Pop reg             ->    (map (baseshape 100) $ emphRB regbank reg)
                               ++ arrowShape (Dec,LdComp,'c') 4 grey
                               ++ arrowShape (Dec,SP,'-') 4 grey
                               ++ arrowShape (SP,AGU,'-') 4 grey
                               ++ arrowShape (AGU,DMem,'-') 4 grey
                               ++ arrowShape (Dec,RB,'a') 4 grey
                               ++ arrowShape (DMem,LdComp,'-') 4 red
                               ++ arrowShape (LdComp,RB,'-') 4 red

        ReadInstr m         ->    arrowShape (Dec,Snd,'-') 4 grey
                               ++ arrowShape (Snd,Out,'-') 4 red

        Receive reg         ->    marking
                               ++ arrowShape (Dec,PC,'t') 4 grey
                               ++ arrowShape (Inp,PC,'-') 4 grey
                               ++ inpArrows
                            where
                              marking | inp == Nothing  = []
                                      | otherwise       = (map (baseshape 100) $ emphRB regbank reg)
                              inpArrows | inp == Nothing = []
                                        | otherwise      =    arrowShape (Dec,LdComp,'c') 4 grey
                                                           ++ arrowShape (Dec,RB,'a') 4 grey
                                                           ++ arrowShape (Inp,LdComp,'-') 4 red
                                                           ++ arrowShape (LdComp,RB,'-') 4 red
        -- TODO
        WriteInstr reg m    -> []

        TestAndSet m        -> []
        EndProg             -> []
        Nop                 -> []
        Debug _             -> []
        _                   -> error (show instr)

-- ===========================================================
-- ===========================================================
-- ===========================================================
-- ===========================================================
-- ===========================================================
-- ===========================================================



grShowFifo fifo =    [ grMem (572,y0-8+k*20) (16,16)          | k <- [0..5]                    ]
                  ++ [ Circle (Point (580,y0+100-k*20)) 4 red | (k,(_,req)) <- zip [0..5] fifo ]
                where
                  y0 = 420

class GrShow a where
        grShow      :: Float -> (Float,a) -> [StrokeLineThickness -> Color -> (Maybe Rotation) -> Shape]
        grShowChnl  :: (Float,a) -> [StrokeLineThickness -> Color -> (Maybe Rotation) -> Shape]
        grShowChnls :: a -> [StrokeLineThickness -> Color -> (Maybe Rotation) -> Shape]

-- ----------------------------------------------
instance GrShow Request where
  grShow k (i,req) = case req of
                ReadReq _       -> [Circle (Point (200+k*200, 380-i*40)) 4 red]
                WriteReq _ _    -> [Circle (Point (200+k*200, 380-i*40)) 4 red]
                _               -> [Circle (Point (200+k*200, 380-i*40)) 4 white]

instance GrShow Reply where
  grShow k (i,rpl) = case rpl of
                Just _          -> [Circle (Point (160+k*200, 260+i*40)) 4 red]
                Nothing         -> [Circle (Point (160+k*200, 260+i*40)) 4 white]

-- ----------------------------------------------
instance GrShow RequestChannel where
  grShowChnl (k,chnl) = concat $ map (grShow k) $ zip (map fromIntegral [0..3]) chnl

instance GrShow ReplyChannel where
  grShowChnl (k,chnl) = concat $ map (grShow k) $ zip (map fromIntegral [0..3]) chnl

-- ----------------------------------------------
instance GrShow RequestChannels where
  grShowChnls chnls = concat $ map grShowChnl $ zip (map fromIntegral [0..4]) chnls

instance GrShow ReplyChannels where
  grShowChnls chnls = concat $ map grShowChnl $ zip (map fromIntegral [0..4]) chnls

-- ===========================================================
frame :: StrokeLineThickness -> StrokeColor -> Maybe Rotation -> Shape
frame = MultiLine [(Point (0,0)), (Point (0,700)), Point (1200,700), Point (1200,0), Point (0,0)]

-- ===========================================================
shMemUpd req vals = map (baseshape 0) $ concat [ grWrite' (show val) (x,y) col | (val,k) <- zip vals [1..7]
                                                                               , let (x,y) = (x0+k*60,y0)
                                                                               , let col = case req of
                                                                                                ReadReq a    -> if k==fromIntegral (a+1) then blue else memColor
                                                                                                WriteReq _ a -> if k==fromIntegral (a+1) then red  else memColor
                                                                                                _            -> memColor
                                                                               ]
              where
                (x0,y0) = (340,555)

-- ===========================================================
out_7SD_Upd vals = map (baseshape 0) $ ([ Rectangle (Point (1082,122)) (56,36) white
                                        , Rectangle (Point (1082,162)) (56,36) white
                                        , Rectangle (Point (1082,202)) (56,36) white
                                        ]
                                     ++ [ Text (show val) "arial" 16 (Point (x,y)) AlignCenter black | (val,k) <- zip vals [0..7]
                                                                         , let (x,y) | k ∈ [0,1]  = (x0+24+k*12,y0)
                                                                                     | k ∈ [2,3]  = (x0   +k*12,y0+40)
                                                                                     | k ∈ [4..7] = (x0-48+k*12,y0+80)
                                        ])
              where
                (x0,y0) = (1092,136)


grSharedMem     = [ grMem  (x0,y0) (940,240)
                  , MultiLine [(Point (x0+270,y0+140)), (Point (x0+690,y0+140)), Point (x0+690,y0+200), Point (x0+270,y0+200), Point (x0+270,y0+140)]
                  , MultiLine [(Point (x0+470,y0+10)), (Point (x0+490,y0+10)), Point (x0+490,y0+130), Point (x0+470,y0+130), Point (x0+470,y0+10)]
                  ]
                  ++ [ Line (Point (x0+270+k*60,y0+140)) (Point (x0+270+k*60,y0+200)) | k<-[1..6] ]
                  ++ [ Line (Point (x0+470,y0+10+k*20)) (Point (x0+490,y0+10+k*20)) | k<-[1..5] ]
                  ++ [ Text var "arial" 16 (Point (x0+220+k*60+20,y0+203)) AlignCenter (0,0,0,100) | (var,k) <- zip ["QF","N?","RF","Id","N","S","X"] [1..7] ]
                where
                  (x0,y0) = (100,400)


-- ===========================================================
smallSprockell i = map (baseshape 100)
                   [ Rectangle (Point (x0,80)) (160,160) sprColor
                   , Text (name i) "arial" 20 (Point (x0+75,90)) AlignCenter black
                   , grMem (x0+20,140) (20,80)
                   , grMem (x0+110,140) (30,80)
                   ]
                   ++ arrow [(x0+100,240), (x0+100,400)]
                   ++ arrow [(x0+60,400), (x0+60,240)]
                where
                   x0 = 100+i*200
                   name 0 = "M"
                   name i = show $ round i

io_comp         = map (baseshape 100)
                  [ Rectangle (Point (920,120)) (120,120) sprColor
                  , Text "7-SD" "arial" 20 (Point (980,150)) AlignCenter black
                  , MultiLine [Point (1080,120), Point (1140,120), Point (1140,240), Point (1080,240), Point (1080,120)]
                  , Line (Point (1080,160)) (Point (1140,160))
                  , Line (Point (1080,200)) (Point (1140,200))
                  , Text "Id" "arial" 16 (Point (1150,133)) AlignCenter black
                  , Text "N" "arial" 16 (Point (1150,173)) AlignCenter black
                  , Text "S" "arial" 16 (Point (1150,213)) AlignCenter black
                  ]
                  ++ arrow [(960,400),(960,240)]
                  ++ arrow [(1000,240),(1000,400)]
                  ++ arrow [(1040,180),(1080,180)]

sharedMemArch = frame 1 black Nothing
              :  (concat $ map smallSprockell [0..3])
              ++ io_comp
              ++ map (baseshape 100) grSharedMem

-- ===========================================================
jumpingData (i,instr) = case instr of
        Compute o rA rB rC  -> [ rBnk, mem, dC ]
        -- LdConst v r         -> [ rBnk, mem, dr ]
        Jump t              -> []
        Branch r t          -> []
        Load m r            -> [ rBnk, mem, dr ]
        Store r m           -> [ rBnk, mem, dm ]
        Push r              -> [ rBnk, mem, dm ]
        Pop r               -> [ rBnk, mem, dm ]
        ReadInstr m         -> [ rBnk, mem ]
        Receive r           -> []
        WriteInstr r m      -> [ rBnk, mem ]
        TestAndSet m        -> [ rBnk, mem ]
        EndProg             -> []
        Nop                 -> []
        Debug _             -> []
  where
    x0 = 100 + i*200
    rBnk = grMem (x0+22,142) (16,76)
    mem  = grMem (x0+112,142) (26,76)

    dC = Circle (Point (x0+30,160)) 4 red
    dr = Circle (Point (x0+30,170)) 4 red
    dm = Circle (Point (x0+125,160)) 4 red


baseshape' primfig = primfig 1 (0,0,0,0) Nothing

-- =================================================================================


clearCanvas = OutCanvas $ C.CanvasOperations canvasId [C.Clear C.ClearCanvas]

-- =================================================================================
-- eventloop configuration
-- =================================================================================
eventloopConfiguration = defaultConfiguration { setupModuleConfigurations=[ C.setupCanvasModuleConfiguration
                                                                          , setupBasicShapesModuleConfiguration
                                                                          , setupMouseModuleConfiguration
                                                                          , setupKeyboardModuleConfiguration
                                                                          ]}
                where
                    defaultConfiguration = allModulesEventloopSetupConfiguration beginProgramState eventloop

data ProgramState = ProgramState Int SprockellState SystemState
                  deriving (Eq, Show)

beginProgramState = ProgramState 0 (initSprockellState 0) initSystemState

showCtr (x,y) ctr = map (baseshape 0)
                    [ Rectangle (Point (x-24,y-2)) (48,24) white
                    , Text (show ctr) "arial" 18 (Point (x,y)) AlignCenter black
                    ]

-- continue :: (Int,[Int]) -> Int -> [InstructionMem] -> SystemState -> (Int,SystemState,[Int])

continue (ctr,ctrs) nrOfSprockells instrss sysSt | ctr ∈ ctrs     = (ctr+1,sysSt',o)
                                                 | otherwise      = continue (ctr+1,ctrs) nrOfSprockells instrss sysSt'
                  where
                    (sysSt',o) = system nrOfSprockells instrss sysSt Tick

-- sprockell prg s i

eventloop :: ProgramState -> In -> (ProgramState, [Out])
eventloop (s@(ProgramState ctr sprSt sysSt)) event = case event of

  Start         -> (s, [setupCanvas]) -- : showFig sharedMemArch) --bigSprockell)
                where
                  setupCanvas =   OutCanvas
                                $ C.SetupCanvas canvasId 1 (1200, 700) (C.CSSPosition C.CSSFromCenter (C.CSSPercentage 50, C.CSSPercentage 50))

  -- ===========================================================
  InKeyboard (Key "1")
                -> (beginProgramState , clearCanvas : showFig (bigSprockell ++ whichInstr 0 ++ showCtr (1060,615) ctr )
                   )

  InKeyboard (Key "2")
                -> (beginProgramState , clearCanvas : showFig (sharedMemArch ++ showCtr (1010,645) ctr)
                   )

  -- ===========================================================
  InKeyboard (Key "m")
                -> ( ProgramState (ctr+1) sprSt' sysSt
                   , showFig (  bigSprockell
                             ++ instrHighlight (pc sprSt)
                             ++ grPC (pc sprSt')
                             ++ grSP (sp sprSt')
                             ++ (grRegBank $ regbank sprSt')
                             ++ (grLocalMem $ localMem sprSt')
                             ++ whichInstr (pc sprSt)
                             ++ (showInstr (regbank sprSt', localMem sprSt', sp sprSt') (input ctr) $ instrs!!(pc sprSt))
                             ++ showCtr (1060,615) ctr
                             )
                   )
                where
                  instrs = exampleProg
                  input 10 = Just 12
                  input _  = Nothing
                  (sprSt', _ ) = sprockell instrs sprSt $ input ctr   -- Nothing

  -- ===========================================================
  InKeyboard (Key "n")
                -> (ProgramState (ctr+1) sprSt sysSt', (showFig $ shMemUpd req $ sharedMem sysSt')
                                         ++ (showFig $ map baseshape' $ concat $ map jumpingData $ zip [0..3] iss)
                                         ++ (showFig $ map (baseshape 0) $ grShowFifo $ requestFifo sysSt')
                                         ++ (showFig $ map (baseshape 100) $ grShowChnls $ requestChnls sysSt')
                                         ++ (showFig $ map (baseshape 100) $ grShowChnls $ replyChnls sysSt')
                                         ++ (showFig $ out_7SD_Upd o)
                                         ++ (showFig $ showCtr (1010,645) ctr)
                                         )
                where
                  (sysSt',o) = system nrOfSprockells instrss sysSt Tick


{-
  -- ===========================================================
  InKeyboard (Key "N")
                -> (ProgramState ctr' sprSt sysSt', (showFig $ shMemUpd req $ sharedMem sysSt')
                                         ++ (showFig $ map baseshape' $ concat $ map jumpingData $ zip [0..3] iss)
                                         ++ (showFig $ map (baseshape 100) $ grShowFifo $ requestFifo sysSt')
                                         ++ (showFig $ map (baseshape 100) $ grShowChnls $ requestChnls sysSt')
                                         ++ (showFig $ map (baseshape 100) $ grShowChnls $ replyChnls sysSt')
                                         ++ (showFig $ out_7SD_Upd o)
                                         ++ (showFig $ showCtr (1010,645) ctr)
                                         )
                where
                  (ctr',sysSt',o) = continue (ctr,[200,500,800]) nrOfSprockells instrss sysSt
-}

  -- ===========================================================
  InKeyboard (Key "q")
                -> (s, [Stop])

  _             -> (s, [])

  -- ===========================================================
  where
    instrss = instrs0 : replicate (nrOfSprockells-1) instrs1
    instrs0 = masterProg
    instrs1 = workerProg

    iss = zipWith (!!) instrss (map pc $ sprStates sysSt)

    fifo = requestFifo sysSt
    req | null fifo = NoRequest
        | otherwise = snd $ head fifo

main = startEventloopSystem eventloopConfiguration



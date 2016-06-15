{-# LANGUAGE RecordWildCards #-}

module System where

import Data.Maybe

import HardwareTypes
import Sprockell
import IO_Comp


-- ===================================================================================
shMem :: (SharedMem, RequestFifo)
         -> IndRequests
         -> ((SharedMem, RequestFifo), (SprID,Reply))

shMem (sharedMem,requestFifo) chRequests = ((sharedMem',requestFifo'), (i,reply))
        where
          (i,req)       | not $ null requestFifo        = head requestFifo
                        | otherwise                     = (0, NoRequest)

          (reply, sharedMem')   = case req of
                NoRequest       -> ( Nothing            , sharedMem )
                ReadReq a       -> ( Just (sharedMem!a) , sharedMem )
                WriteReq v a    -> ( Nothing            , sharedMem <~ (a,v))
                TestReq a       -> ( Nothing            , sharedMem )                                   -- <=== TODO: define correctly

          requestFifo'  = tail' requestFifo ++ filter ((/=NoRequest).snd) chRequests                    -- <<== TODO: abstract away from software/hardware
          -- requestFifo'       = requestFifo <<++ (chRequests, ((/=NoRequest).snd))                            --              Possibility??

-- ===================================================================================
transfer :: (RequestChannels, ReplyChannels)
                -> (ParRequests, (SprID, Reply))
                -> ((RequestChannels, ReplyChannels), (ParReplies, IndRequests))

transfer (requestChnls,replyChnls) (sprRequests,(i,shMemReply)) = ( (requestChnls',replyChnls'), (outReplies,outRequests) )
        where
          -- ->->->->
          outRequests   = zip [0..] $ map head requestChnls                                             -- <<== TODO: abstract away from softare/hardware
          requestChnls' = zipWith (<<+) requestChnls sprRequests

          -- <-<-<-<-
          n             = length replyChnls                                                             -- <<== TODO: abstraction difficult:
          inReplies     = replicate n Nothing <~ (i,shMemReply)                                         --              no parameter n in CLaSH
          outReplies    = map head replyChnls
          replyChnls'   = zipWith (<<+) replyChnls inReplies

-- ===================================================================================
-- system :: Int -> [InstructionMem] -> SystemState -> _ -> (SystemState, ... )

system nrOfSprs progs systemState _ = (systemState', io_outp)
                                      -- (systemState', [ (requestChnls'!!i,replyChnls'!!i) | i <- [0..nrOfSprs] ] )
                                                                        -- Output for simulation purposes

        where
          SystemState{..} = systemState

          -- Sprockells
          (sprStates',sprRequests)                              = unzip $ sprockell $> progs |$| sprStates |$| init chReplies

          -- IO_Component
          allRequests                   = sprRequests ++ [io_Req]
          (io_state',(io_Req,io_outp))  = io io_state $ last chReplies

          -- Communication
          ((requestChnls',replyChnls'), (chReplies,chRequests)) = transfer (requestChnls,replyChnls) (allRequests,(i,shMemReply))

          -- Shared Memory
          ((sharedMem',requestFifo'), (i,shMemReply))           = shMem (sharedMem,requestFifo) chRequests

          systemState' = SystemState
                { sprStates     = sprStates'
                , io_state      = io_state'
                , requestChnls  = requestChnls'
                , replyChnls    = replyChnls'
                , requestFifo   = requestFifo'
                , sharedMem     = sharedMem'
                }

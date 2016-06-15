{-# LANGUAGE TypeSynonymInstances, FlexibleInstances, UndecidableInstances #-}

{- =====================================================
Jan Kuper, June 2016
===================================================== -}

{- Graphical demo of Sprockells.
===============================
Commands -- hit key:

1 : start single sprockell
m : next cycle

2 : start multi sprockell thing
n : next cycle

q : quit

===============================

Example programs in ExampleProg.hs

Be careful IO-component, that will assume certain values, and is thus application dependent.

===============================

Run in ghci:
Architecture.hs
evaluate: main

Don't pay attention to the warnings, it runs anyway.
-}



module Simulation where

import HardwareTypes
import Sprockell
import BasicFunctions
import IO_Comp          -- relevant for graphical simulation, not for PP-project
import System

-- ====================================================================================================
-- Simulation Function for Sprockell
-- ====================================================================================================
data Tick = Tick        deriving (Eq,Show)
clock = Tick : clock

sprockellSim prg s []     = []
sprockellSim prg s (i:is) | instr /= EndProg    = (ljustify 20 $ show instr, s',o) : sprockellSim prg s' is
                          | otherwise           = []
                where
                  (s',o) = sprockell prg s i
                  instr  = prg ! pc s

-- ====================================================================================================
-- Some Constants
-- ====================================================================================================
localMemSize    = 16                    :: Int
regbankSize     = 8                     :: Int

-- initVarLUT      = [("sprID",0,[])]      :: VarLUT

initSprockellState :: Value -> SprockellState
initSprockellState sprID = SprState
  { pc       = 0
  , sp       = localMemSize
  , regbank  = replicate regbankSize 0
  , localMem = replicate localMemSize 0 <~ (0,sprID)
  }

-- ====================================================================================================
-- ====================================================================================================
-- ====================================================================================================
-- System Test
-- ====================================================================================================
-- ====================================================================================================
-- ====================================================================================================

-- ====================================================================================================
-- Simulation function for Syatem
-- ====================================================================================================
systemSim progs s []     = []
systemSim progs s (i:is) | not sysHalted = o : systemSim progs s' is
                         | otherwise     = []
                where
                  (s',o)    = system nrOfSprockells progs s i
                  sysHalted = and $ map (==EndProg) $ zipWith (!!) progs $ map pc $ sprStates s

-- ====================================================================================================
-- Some Constants
-- ====================================================================================================
nrOfSprockells  = 4                     :: Int
shMemSize       = 8                     :: Int
channelDelay    = 4                     :: Int

initSystemState = SystemState
        { sprStates     = map initSprockellState [0 .. nrOfSprockells-1]
        , io_state      = (NoExp,0,NoRequest, 0, (0,0,0), (0,0,0,0,0,0,0))      -- not relevant for PP-project
        , requestChnls  = replicate (nrOfSprockells+1) $ replicate channelDelay NoRequest
        , replyChnls    = replicate (nrOfSprockells+1) $ replicate channelDelay Nothing
        , requestFifo   = []
        , sharedMem     = replicate shMemSize 0
        }


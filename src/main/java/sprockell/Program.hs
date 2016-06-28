module Program where

import BasicFunctions
import HardwareTypes
import Sprockell
import System
import Simulation

prog0 :: [Instruction]
prog0 = [
          Load (ImmValue 1) regA, 
          Branch regA (Abs 3), 
          Jump (Abs 0), 
          Nop, 
          EndProg 
       ] 
demoTest = sysTest [prog0]
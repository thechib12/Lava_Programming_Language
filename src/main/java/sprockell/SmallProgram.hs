module SmallProgram where

import BasicFunctions
import HardwareTypes
import Sprockell
import System
import Simulation

prog :: [Instruction]
prog = [
         Load (ImmValue 12) 2,
         I2I 2 3,
         DecrSP,
         Push 3,
         EndProg
       ]

demoTest = sysTest [prog]


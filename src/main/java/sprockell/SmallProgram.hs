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
         Store 3 (DirAddr 100000),
         EndProg
       ]

demoTest = sysTest [prog]


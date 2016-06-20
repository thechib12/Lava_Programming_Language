module SmallProgram where

import BasicFunctions
import HardwareTypes
import Sprockell
import System
import Simulation

prog :: [Instruction]
prog = [
         Load (ImmValue 12) 2,
         Load (ImmValue 12) 1,
         Compute Add 1 2 3,
          Push 3,
          WriteInstr 3 (DirAddr 0),
          Nop,
          Nop,
          Nop,
          Nop,
          Nop,
                    Nop,
                    Nop,
                    Nop,
          EndProg
       ]

demoTest = sysTest [prog]

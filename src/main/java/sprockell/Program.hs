module Main where

import BasicFunctions
import HardwareTypes
import Sprockell
import System
import Simulation

prog0 :: [Instruction]
prog0 = [
          Load (ImmValue 2) regA, 
          WriteInstr regA (DirAddr 13), 
          ReadInstr  (DirAddr 13), 
          Receive regB, 
          Load (ImmValue 1) regC, 
          Compute Add regB regC regD, 
          WriteInstr regD (DirAddr 13), 
          EndProg 
       ] 
main = sysTest [prog0]
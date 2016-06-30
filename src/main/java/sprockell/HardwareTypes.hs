module Main where

import BasicFunctions
import HardwareTypes
import Sprockell
import System
import Simulation

prog0 :: [Instruction]
prog0 = [
          Load (ImmValue 0) regA, 
          Store regA (DirAddr 1), 
          Load (ImmValue 2) regB, 
          Store regB (DirAddr 2), 
          Load (ImmValue 1) regC, 
          Store regC (DirAddr 3), 
          Load (ImmValue 1) regD, 
          Store regD (DirAddr 4), 
          Load (DirAddr 3) regE, 
          Load (ImmValue 100) regF, 
          Compute LtE regE regF regG, 
          Branch regG (Abs 28), 
          Load (DirAddr 4) regH, 
          Branch regH (Abs 18), 
          Load (DirAddr 1) regI, 
          Load (DirAddr 2) regJ, 
          Compute Add regI regJ regK, 
          Store regK (DirAddr 1), 
          Nop, 
          Load (DirAddr 3) regL, 
          Load (ImmValue 1) regM, 
          Compute Add regL regM regN, 
          Store regN (DirAddr 3), 
          Load (DirAddr 4) regO, 
          Load (ImmValue 1) regP, 
          Compute Sub regP regO regP, 
          Store regP (DirAddr 4), 
          Jump (Abs 8), 
          Nop, 
          EndProg 
       ] 
main = sysTest [prog0]
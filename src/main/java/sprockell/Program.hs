module Program where

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
          Branch regG (Abs 26), 
          Load (DirAddr 4) regH, 
          Branch regI (Abs 18), 
          Load (DirAddr 1) regJ, 
          Load (DirAddr 2) regK, 
          Compute Add regJ regK regL, 
          Store regL (DirAddr 1), 
          Nop, 
          Load (DirAddr 3) regM, 
          Load (ImmValue 1) regN, 
          Compute Add regM regN regO, 
          Store regO (DirAddr 3), 
          Load (ImmValue 1) regP, 
          Store regP (DirAddr 4), 
          Jump (Abs 8), 
          Nop, 
          EndProg 
       ] 
demoTest = sysTest [prog0]
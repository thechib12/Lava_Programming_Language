module Main where

import BasicFunctions
import HardwareTypes
import Sprockell
import System
import Simulation

prog0 :: [Instruction]
prog0 = [
          Store reg0 (DirAddr 1), 
          Load (ImmValue 1) regA, 
          Branch regA (Abs 16), 
          Load (ImmValue 1) regB, 
          Push regB, 
          Load (ImmValue 2) regC, 
          Push regC, 
          Push reg0, 
          Load (ImmValue 11) regD, 
          Push regD, 
          Jump (Abs 53), 
          Pop reg0, 
          Pop regD, 
          Pop reg0, 
          Pop reg0, 
          Jump (Abs 25), 
          Load (ImmValue 1) regE, 
          Push regE, 
          Push reg0, 
          Load (ImmValue 22) regF, 
          Push regF, 
          Jump (Abs 99), 
          Pop reg0, 
          Pop regF, 
          Pop reg0, 
          Nop, 
          Nop, 
          Push reg0, 
          Load (ImmValue 31) regG, 
          Push regG, 
          Jump (Abs 111), 
          Pop reg0, 
          Pop regG, 
          I2I regG regH, 
          Push regH, 
          Nop, 
          Push reg0, 
          Load (ImmValue 40) regI, 
          Push regI, 
          Jump (Abs 111), 
          Pop reg0, 
          Pop regI, 
          I2I regI regJ, 
          Push regJ, 
          Push reg0, 
          Load (ImmValue 48) regK, 
          Push regK, 
          Jump (Abs 53), 
          Pop reg0, 
          Pop regK, 
          Pop reg0, 
          Pop reg0, 
          EndProg, 
          Pop regL, 
          DecrSP, 
          Pop reg0, 
          Pop reg0, 
          Pop regM, 
          DecrSP, 
          DecrSP, 
          DecrSP, 
          Pop reg0, 
          Pop reg0, 
          Pop reg0, 
          Pop regN, 
          DecrSP, 
          DecrSP, 
          DecrSP, 
          DecrSP, 
          Compute Equal regM regN regO, 
          Branch regO (Abs 81), 
          Load (ImmValue 2) regP, 
          Pop reg0, 
          Pop reg0, 
          Pop reg0, 
          Pop reg0, 
          Push regP, 
          DecrSP, 
          DecrSP, 
          DecrSP, 
          Jump (Abs 55), 
          Nop, 
          Pop reg0, 
          Pop reg0, 
          Pop regQ, 
          DecrSP, 
          DecrSP, 
          DecrSP, 
          Pop reg0, 
          Pop reg0, 
          Pop reg0, 
          Pop regR, 
          DecrSP, 
          DecrSP, 
          DecrSP, 
          DecrSP, 
          Compute Add regQ regR regS, 
          Store regS (DirAddr 1), 
          Jump (Ind regL), 
          Pop regA1, 
          DecrSP, 
          Load (DirAddr 1) regB1, 
          Pop reg0, 
          Pop reg0, 
          Pop regC1, 
          DecrSP, 
          DecrSP, 
          DecrSP, 
          Compute Sub regB1 regC1 regD1, 
          Store regD1 (DirAddr 1), 
          Jump (Ind regA1), 
          Pop regE1, 
          DecrSP, 
          Load (ImmValue 2) regF1, 
          Pop regG1, 
          Pop reg0, 
          Push regF1, 
          Push reg0, 
          Jump (Ind regG1), 
          Jump (Ind regE1) 
       ] 
main = sysTest [prog0]
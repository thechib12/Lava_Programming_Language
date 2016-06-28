module Program where

import BasicFunctions
import HardwareTypes
import Sprockell
import System
import Simulation

prog0 :: [Instruction]
prog0 = [
          Store reg0 (DirAddr 1), 
          Load (ImmValue 2) regA, 
          Push regA, 
          Load (ImmValue 10) regB, 
          Push regB, 
          Load (ImmValue 20) regC, 
          Push regC, 
          Push reg0, 
          Load (ImmValue 11) regD, 
          Push regD, 
          Jump (Abs 23), 
          Pop reg0, 
          Pop regD, 
          Pop reg0, 
          Pop reg0, 
          Pop regE, 
          DecrSP, 
          Compute Add regD regE regF, 
          Push regF, 
          Pop regG, 
          DecrSP, 
          Store regG (DirAddr 1), 
          EndProg, 
          Pop regH, 
          DecrSP, 
          Pop reg0, 
          Pop reg0, 
          Pop regI, 
          DecrSP, 
          DecrSP, 
          DecrSP, 
          Load (ImmValue 2) regJ, 
          Compute Add regI regJ regK, 
          Push regK, 
          Push reg0, 
          Load (ImmValue 38) regL, 
          Push regL, 
          Jump (Abs 67), 
          Pop reg0, 
          Pop regL, 
          Pop reg0, 
          Pop reg0, 
          Pop reg0, 
          Pop reg0, 
          Pop regM, 
          DecrSP, 
          DecrSP, 
          DecrSP, 
          DecrSP, 
          Load (ImmValue 3) regN, 
          Compute Add regM regN regO, 
          Push regO, 
          Push reg0, 
          Load (ImmValue 56) regP, 
          Push regP, 
          Jump (Abs 96), 
          Pop reg0, 
          Pop regP, 
          Pop reg0, 
          Compute Sub regL regP regQ, 
          Compute Add regQ reg0 regR, 
          Pop regS, 
          Pop reg0, 
          Push regR, 
          Push regS, 
          Jump (Ind regS), 
          Jump (Ind regH), 
          Pop regA1, 
          DecrSP, 
          Load (ImmValue 3) regB1, 
          Push regB1, 
          Load (ImmValue 7) regC1, 
          Push regC1, 
          Load (ImmValue 4) regD1, 
          Push regD1, 
          Pop reg0, 
          Pop reg0, 
          Pop reg0, 
          Pop reg0, 
          Pop reg0, 
          Pop regE1, 
          DecrSP, 
          DecrSP, 
          DecrSP, 
          DecrSP, 
          DecrSP, 
          DecrSP, 
          Pop reg0, 
          Pop reg0, 
          Pop reg0, 
          Pop regF1, 
          Pop reg0, 
          Push regE1, 
          Push regF1, 
          Jump (Ind regF1), 
          Jump (Ind regA1), 
          Pop regG1, 
          DecrSP, 
          Pop reg0, 
          Pop reg0, 
          Pop regH1, 
          DecrSP, 
          DecrSP, 
          DecrSP, 
          Pop regI1, 
          Pop reg0, 
          Push regH1, 
          Push regI1, 
          Jump (Ind regI1), 
          Jump (Ind regG1) 
       ] 
demoTest = sysTest [prog0]
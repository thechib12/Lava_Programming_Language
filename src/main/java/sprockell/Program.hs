module Program where

import BasicFunctions
import HardwareTypes
import Sprockell
import System
import Simulation

prog0 :: [Instruction]
prog0 = [
          WriteInstr reg0 (DirAddr 13), 
          WriteInstr reg0 (DirAddr 14), 
          WriteInstr reg0 (DirAddr 15), 
          WriteInstr reg0 (DirAddr 16), 
          Load (ImmValue 0) regA, 
          WriteInstr regA (DirAddr 13), 
          Load (ImmValue 0) regB, 
          WriteInstr regB (DirAddr 14), 
          Load (ImmValue 1) regC, 
          WriteInstr reg0 (DirAddr 1), 
          WriteInstr regC (DirAddr 2), 
          Load (ImmValue 1) regD, 
          WriteInstr reg0 (DirAddr 3), 
          WriteInstr regD (DirAddr 4), 
          Load (ImmValue 1) regE, 
          Load (ImmValue 2) regF, 
          Compute Mul regF regE regF, 
          TestAndSet (IndAddr regF), 
          Receive regG, 
          Branch regG (Abs 14), 
          Load (ImmValue 2) regH, 
          Load (ImmValue 2) regI, 
          Compute Mul regI regH regI, 
          TestAndSet (IndAddr regI), 
          Receive regJ, 
          Branch regJ (Abs 20), 
          EndProg, 
          Pop regK, 
          DecrSP, 
          Load (ImmValue 1) regL, 
          WriteInstr regL (DirAddr 13), 
          Load (ImmValue 1) regM, 
          WriteInstr regM (DirAddr 15), 
          ReadInstr  (DirAddr 14), 
          Receive regN, 
          ReadInstr  (DirAddr 15), 
          Receive regO, 
          Load (ImmValue 1) regP, 
          Compute Equal regO regP regQ, 
          Compute Add regQ reg0 regR, 
          Compute And regN regR regS, 
          Branch regS (Abs 43), 
          Jump (Abs 33), 
          Nop, 
          ReadInstr  (DirAddr 16), 
          Receive regA1, 
          Load (ImmValue 1) regB1, 
          Compute Add regA1 regB1 regC1, 
          WriteInstr regC1 (DirAddr 16), 
          Load (ImmValue 0) regD1, 
          WriteInstr regD1 (DirAddr 13), 
          Jump (Ind regK), 
          Pop regE1, 
          DecrSP, 
          Load (ImmValue 1) regF1, 
          WriteInstr regF1 (DirAddr 14), 
          Load (ImmValue 0) regG1, 
          WriteInstr regG1 (DirAddr 15), 
          ReadInstr  (DirAddr 13), 
          Receive regH1, 
          ReadInstr  (DirAddr 15), 
          Receive regI1, 
          Load (ImmValue 0) regJ1, 
          Compute Equal regI1 regJ1 regK1, 
          Compute Add regK1 reg0 regL1, 
          Compute And regH1 regL1 regM1, 
          Branch regM1 (Abs 68), 
          Jump (Abs 58), 
          Nop, 
          ReadInstr  (DirAddr 16), 
          Receive regN1, 
          Load (ImmValue 1) regO1, 
          Compute Add regN1 regO1 regP1, 
          WriteInstr regP1 (DirAddr 16), 
          Load (ImmValue 0) regQ1, 
          WriteInstr regQ1 (DirAddr 14), 
          Jump (Ind regE1) 
       ] 
prog1 :: [Instruction]
prog1 = [
          Load (ImmValue 1) regA, 
          WriteInstr regA (DirAddr 1), 
          TestAndSet (DirAddr 1), 
          Receive regB, 
          Branch regB (Abs 2), 
          Load (ImmValue 1) regC, 
          WriteInstr regC (DirAddr 13), 
          Load (ImmValue 1) regD, 
          WriteInstr regD (DirAddr 15), 
          ReadInstr  (DirAddr 14), 
          Receive regE, 
          ReadInstr  (DirAddr 15), 
          Receive regF, 
          Load (ImmValue 1) regG, 
          Compute Equal regF regG regH, 
          Compute Add regH reg0 regI, 
          Compute And regE regI regJ, 
          Branch regJ (Abs 19), 
          Jump (Abs 9), 
          Nop, 
          ReadInstr  (DirAddr 16), 
          Receive regK, 
          Load (ImmValue 1) regL, 
          Compute Add regK regL regM, 
          WriteInstr regM (DirAddr 16), 
          Load (ImmValue 0) regN, 
          WriteInstr regN (DirAddr 13), 
          WriteInstr reg0 (DirAddr 2), 
          EndProg, 
          Pop regO, 
          DecrSP, 
          Load (ImmValue 1) regP, 
          WriteInstr regP (DirAddr 14), 
          Load (ImmValue 0) regQ, 
          WriteInstr regQ (DirAddr 15), 
          ReadInstr  (DirAddr 13), 
          Receive regR, 
          ReadInstr  (DirAddr 15), 
          Receive regS, 
          Load (ImmValue 0) regA1, 
          Compute Equal regS regA1 regB1, 
          Compute Add regB1 reg0 regC1, 
          Compute And regR regC1 regD1, 
          Branch regD1 (Abs 45), 
          Jump (Abs 35), 
          Nop, 
          ReadInstr  (DirAddr 16), 
          Receive regE1, 
          Load (ImmValue 1) regF1, 
          Compute Add regE1 regF1 regG1, 
          WriteInstr regG1 (DirAddr 16), 
          Load (ImmValue 0) regH1, 
          WriteInstr regH1 (DirAddr 14), 
          Jump (Ind regO) 
       ] 
prog2 :: [Instruction]
prog2 = [
          Load (ImmValue 1) regA, 
          WriteInstr regA (DirAddr 3), 
          TestAndSet (DirAddr 3), 
          Receive regB, 
          Branch regB (Abs 2), 
          Load (ImmValue 1) regC, 
          WriteInstr regC (DirAddr 14), 
          Load (ImmValue 0) regD, 
          WriteInstr regD (DirAddr 15), 
          ReadInstr  (DirAddr 13), 
          Receive regE, 
          ReadInstr  (DirAddr 15), 
          Receive regF, 
          Load (ImmValue 0) regG, 
          Compute Equal regF regG regH, 
          Compute Add regH reg0 regI, 
          Compute And regE regI regJ, 
          Branch regJ (Abs 19), 
          Jump (Abs 9), 
          Nop, 
          ReadInstr  (DirAddr 16), 
          Receive regK, 
          Load (ImmValue 1) regL, 
          Compute Add regK regL regM, 
          WriteInstr regM (DirAddr 16), 
          Load (ImmValue 0) regN, 
          WriteInstr regN (DirAddr 14), 
          WriteInstr reg0 (DirAddr 4), 
          EndProg, 
          Pop regO, 
          DecrSP, 
          Load (ImmValue 1) regP, 
          WriteInstr regP (DirAddr 13), 
          Load (ImmValue 1) regQ, 
          WriteInstr regQ (DirAddr 15), 
          ReadInstr  (DirAddr 14), 
          Receive regR, 
          ReadInstr  (DirAddr 15), 
          Receive regS, 
          Load (ImmValue 1) regA1, 
          Compute Equal regS regA1 regB1, 
          Compute Add regB1 reg0 regC1, 
          Compute And regR regC1 regD1, 
          Branch regD1 (Abs 45), 
          Jump (Abs 35), 
          Nop, 
          ReadInstr  (DirAddr 16), 
          Receive regE1, 
          Load (ImmValue 1) regF1, 
          Compute Add regE1 regF1 regG1, 
          WriteInstr regG1 (DirAddr 16), 
          Load (ImmValue 0) regH1, 
          WriteInstr regH1 (DirAddr 13), 
          Jump (Ind regO) 
       ] 
demoTest = sysTest [prog0, prog1, prog2]
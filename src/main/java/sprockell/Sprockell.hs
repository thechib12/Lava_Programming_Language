{-# LANGUAGE RecordWildCards #-}

module Sprockell where

import Data.Bits
import Data.Maybe
import Debug.Trace

import HardwareTypes

{-------------------------------------------------------------
| SPROCKELL: Simple PROCessor in hasKELL :-)
|
| Initial definition: October 2012, Jan Kuper (j.kuper@utwente.nl)
| Extensions: June 2015, Martijn Bastiaan, Arjan Boeijink, Jan Kuper, Leon Schoorl
| Simplification: January 2016, Jan Kuper
-------------------------------------------------------------}


-- =====================================================================================
-- Default Machine Code
-- =====================================================================================

nullcode :: MachCode

nullcode = MachCode
        { ldCode   = LdImm
        , stCode   = StNone
        , aguCode  = AguDir
        , branch   = False
        , tgtCode  = NoJump
        , spCode   = Flat
        , aluCode  = Or
        , ioCode   = IONone
        , immValue = 0
        , regX     = 0
        , regY     = 0
        , loadReg  = 0
        , addrImm  = 0
        }

-- =====================================================================================
-- The actual Sprockell
-- =====================================================================================

sprockell :: InstructionMem -> SprockellState -> Reply -> (SprockellState, Request)

sprockell instrs sprState reply = (sprState', request)
    where
        SprState{..} = sprState
        MachCode{..} = decode (instrs!pc)

        (x,y)        = (regbank!regX , regbank!regY)
        aluOutput    = alu aluCode x y

        pc'          = nextPC branch tgtCode (x,reply) (pc,immValue,y)
        sp'          = nextSP spCode sp

        address      = agu aguCode (addrImm,x,sp)                                                               -- x is deref-addr

        loadValue    = load ldCode (immValue, aluOutput, localMem!address, pc, reply)
        regbank'     = regbank <~! (loadReg, loadValue)

        localMem'    = store localMem stCode (address,y)

        sprState'    = SprState {pc=pc', sp=sp', regbank=regbank', localMem=localMem'}

        request      = sendOut ioCode address y

-- ============================

decode :: Instruction -> MachCode
decode instr = case instr of

  Compute c rx ry toReg       -> nullcode {ldCode=LdAlu, aluCode=c, regX=rx, regY=ry, loadReg=toReg}

  Load memAddr toReg          -> case memAddr of
                                   ImmValue n  -> nullcode {loadReg=toReg, ldCode=LdImm, immValue=n}
                                   DirAddr a   -> nullcode {loadReg=toReg, ldCode=LdMem, aguCode=AguDir, addrImm=a}
                                   IndAddr p   -> nullcode {loadReg=toReg, ldCode=LdMem, aguCode=AguInd, regX=p}

  Jump target                 -> case target of
                                   Abs n       -> nullcode {tgtCode=TAbs, immValue=n}
                                   Rel n       -> nullcode {tgtCode=TRel, immValue=n}
                                   Ind r       -> nullcode {tgtCode=TInd, regY=r}

  Branch cReg target          -> case target of
                                   Abs n       -> nullcode {branch=True, tgtCode=TAbs, regX=cReg, immValue=n}
                                   Rel n       -> nullcode {branch=True, tgtCode=TRel, regX=cReg, immValue=n}
                                   Ind r       -> nullcode {branch=True, tgtCode=TInd, regX=cReg, regY=r}

  Store fromReg memAddr       -> case memAddr of
                                   ImmValue n  -> nullcode {stCode=StMem, regY=fromReg, ldCode=LdImm, immValue=n}
                                   DirAddr a   -> nullcode {stCode=StMem, regY=fromReg, ldCode=LdMem, aguCode=AguDir, addrImm=a}
                                   IndAddr p   -> nullcode {stCode=StMem, regY=fromReg, ldCode=LdMem, aguCode=AguInd, regX=p}

  Push fromReg                -> nullcode {stCode=StMem, regY=fromReg, aguCode=AguPush, spCode=Down}

  Pop toReg                   -> nullcode {ldCode=LdMem, loadReg=toReg, aguCode=AguPop, spCode=Up}

  Receive toReg               -> nullcode {ldCode=LdInp, tgtCode=Waiting, loadReg=toReg}

  ReadInstr memAddr           -> case memAddr of
                                   ImmValue n  -> nullcode {ioCode=IORead, ldCode=LdImm, immValue=n}
                                   DirAddr a   -> nullcode {ioCode=IORead, ldCode=LdMem, aguCode=AguDir, addrImm=a}
                                   IndAddr p   -> nullcode {ioCode=IORead, ldCode=LdMem, aguCode=AguInd, regX=p}

  WriteInstr fromReg memAddr  -> case memAddr of
                                   ImmValue n  -> nullcode {ioCode=IOWrite, regY=fromReg, ldCode=LdImm, immValue=n}
                                   DirAddr a   -> nullcode {ioCode=IOWrite, regY=fromReg, ldCode=LdMem, aguCode=AguDir, addrImm=a}
                                   IndAddr p   -> nullcode {ioCode=IOWrite, regY=fromReg, ldCode=LdMem, aguCode=AguInd, regX=p}

  TestAndSet memAddr          -> case memAddr of
                                   ImmValue n  -> nullcode {ioCode=IOTest, ldCode=LdImm, immValue=n}
                                   DirAddr a   -> nullcode {ioCode=IOTest, ldCode=LdMem, aguCode=AguDir, addrImm=a}
                                   IndAddr p   -> nullcode {ioCode=IOTest, ldCode=LdMem, aguCode=AguInd, regX=p}

  EndProg                     -> nullcode {tgtCode=TRel, immValue=0}

  Nop                         -> nullcode

  Debug _                     -> nullcode       -- only for development purposes


{- ===============================================================
Meaning registers regX and regY (containing x and y, respectively)
==================================================================
                                |  regX - x     |  regY - y     |
-----------------------------------------------------------------
Compute c rx ry toReg           | 1st arg rx    | 2nd arg ry    |
LdConst n toReg                 |   -           |   -           |
Load (DirAddr a) toReg          |   -           |   -           |
Load (Defer p) toReg            | deref-reg p   |   -           |
                                |               |               |
Jump (Abs n)                    |   -           |   -           |
 -   (Rel n)                    |   -           |   -           |
 -   (Ind r)                    |   -           | ind reg r     |
Branch cReg (Abs n)             | cond-reg cReg |   -           |
 -      -   (Rel n)             | cond-reg cReg |   -           |
 -      -   (Ind r)             | cond-reg cReg | ind reg r     |
                                |               |               |
Store fromReg (DirAddr a)       |   -           | fromReg       |
 -     -      (IndAddr p)       | deref-reg p   | fromReg       |
                                |               |               |
Push fromReg                    |   -           | fromReg       |
Pop toReg                       |   -           |   -           |
                                |               |               |
Receive toReg                   |   -           |   -           |
                                |               |               |
Read (DirAddr a)                |   -           |   -           |
 -   (IndAddr p)                | deref-reg p   |   -           |
                                |               |               |
TestAndSet (DirAddr a)          |   -           |   -           |
 -         (IndAddr p)          | deref-reg p   |   -           |
                                |               |               |
Write fromReg (DirAddr a)       |   -           | fromReg       |
 -     -      (IndAddr p)       | deref-addr p  | fromReg       |
=============================================================== -}

-- ============================
alu :: Operator -> Value -> Value -> Value
alu opCode x y = case opCode of
        Incr   -> x + 1
        Decr   -> x - 1
        Add    -> x + y
        Sub    -> x - y
        Mul    -> x * y
        Equal  -> intBool (x == y)
        NEq    -> intBool (x /= y)
        Gt     -> intBool (x > y)
        GtE    -> intBool (x >= y)
        Lt     -> intBool (x < y)
        LtE    -> intBool (x <= y)
        And    -> x .&. y
        Or     -> x .|. y
        LShift -> shiftL x (fromIntegral y)
        RShift -> shiftR x (fromIntegral y)
        Xor    -> x `xor` y

        -- Div    -> x `div` y                          -- too expensive on hardware; to be defined by yourself
        -- Mod    -> x `mod` y                          -- Ibid

-- ============================
agu :: AguCode -> (MemAddr,MemAddr,MemAddr) -> MemAddr
agu aguCode (addrImm,x,sp) = case aguCode of
        AguDir   -> addrImm
        AguInd   -> x
        AguPush  -> sp-1
        AguPop   -> sp

-- ============================
load :: LdCode -> (Value, Value, Value, Value, Reply) -> Value
load ldCode (immval,aluOutput,memval,pc,reply) = case (ldCode, reply) of
        (LdImm, Nothing) -> immval
        (LdAlu, Nothing) -> aluOutput
        (LdMem, Nothing) -> memval
        (LdPC , Nothing) -> pc

        (LdInp, Just rx) -> rx
        (LdInp, Nothing) -> 0

        (_    , Just rx) -> error ("Sprockell ignored a system response of value: " ++ show rx)

-- ============================
store :: LocalMem -> StCode -> (MemAddr, Value) -> LocalMem
store mem stCode (address,value) = case stCode of
        StNone -> mem
        StMem  -> mem <~! (address, value)

-- ============================
nextPC :: Bool -> TargetCode -> (Value,Reply) -> (Value,Value,Value) -> Value
nextPC branch tgtCode (x,reply) (pc,n,y) =

        case  (branch, tgtCode, x/=0,  reply  ) of

              ( True , TAbs   , True,    _    )   -> n
              ( True , TRel   , True,    _    )   -> pc'
              ( True , TInd   , True,    _    )   -> y

              ( False, TAbs   ,  _  ,    _    )   -> n
              ( False, TRel   ,  _  ,    _    )   -> pc'
              ( False, TInd   ,  _  ,    _    )   -> y

              ( False, Waiting,  _  , Nothing )   -> pc

              (  _   ,   _    ,  _  ,    _    )   -> pc + 1

              where
                pc' = pc + n

-- ============================
nextSP :: SPCode -> MemAddr -> MemAddr
nextSP spCode sp = case spCode of
        Down    -> sp-1
        Flat    -> sp
        Up      -> sp+1

-- ============================
sendOut :: IOCode -> MemAddr -> Value -> Request
sendOut ioCode address value = case ioCode of
        IONone    -> NoRequest
        IORead    -> ReadReq address
        IOWrite   -> WriteReq value address
        IOTest    -> TestReq address

module HardwareTypes where

import Debug.Trace

-- ==========================================================================================================
-- Types and sizes for: data, memory, communication channels
-- ==========================================================================================================
-- Constraints possibly will possibly require conversions -- KEEP IT SIMPLE!
-- * MemAddr (for both local and shared memory) should fit in registers for indirect addressing
-- * Register content should be usable as code address
-- * Possibly that shared memory is bigger than local memory
-- * Etcetera ...
-- ==> Choice: avoid conversions, too complicated. So keep all these the same as much as possible.
-- ==========================================================================================================

type CodeAddr   = Int                                           -- * Instruction Address in Assembly Program (==> Program Counter)
type RegAddr    = Int                                           -- * Register Address
type MemAddr    = Int                                           -- * Local Memory Address (==> Stack Pointer)
                                                                --      ==> local memory and shared memory of different sizes?
type Value      = Int
type SprID      = Value

data AddrImmDI  = ImmValue Int
                | DirAddr MemAddr                               -- D/I: Direct, Indirect
                | IndAddr RegAddr
                deriving (Eq,Show,Read)

type LocalMem   =  [Value]
type RegBank    =  [Value]
type SharedMem  =  [Value]

type InstructionMem     = [Instruction]

type Reply      = Maybe Value
data Request    = NoRequest
                | ReadReq MemAddr
                | WriteReq Value MemAddr
                | TestReq MemAddr
                deriving (Eq,Show)

type IndSprockell a     = (SprID, a)
type IndRequests        = [IndSprockell Request]
type IndReplies         = [IndSprockell Reply]

type RequestChannel     = [Request]
type RequestChannels    = [RequestChannel]
type ReplyChannel       = [Reply]
type ReplyChannels      = [ReplyChannel]

type ParRequests        = [Request]                     -- one request for each Sprockell
type ParReplies         = [Reply]                       -- ibid for replies
type RequestFifo        = [(SprID,Request)]             -- Collects all Sprockell requests as input for Shared Memory

-- ==========================================================================================================
-- Internal state for Sprockell and System
-- ==========================================================================================================

data SprockellState = SprState
        { pc            :: !CodeAddr
        , sp            :: !MemAddr
        , regbank       :: !RegBank
        , localMem      :: !LocalMem
        } deriving (Eq,Show)

data Expecting  = Flag
                | SprId
                | N
                | S
                | NoExp
                deriving (Eq,Show)

data SystemState = SystemState
        { sprStates     :: ![SprockellState]
        , io_state      :: !(Expecting, Int, Request, Int, (Int,Int,Int), (Int,Int,Int,Int,Int,Int,Int))
        , requestChnls  :: ![RequestChannel]
        , replyChnls    :: ![ReplyChannel]
        , requestFifo   :: !RequestFifo
        , sharedMem     :: ![Value]
        }
        deriving (Eq,Show)

-- ==========================================================================================================
-- Sprockell instructions
-- ==========================================================================================================
data Operator   = Add   | Sub | Mul -- | Div    | Mod                   -- Computational operations -- No Div, Mod
                | Equal | NEq | Gt  | Lt     | GtE | LtE                -- Comparison operations
                | And   | Or  | Xor | LShift | RShift                   -- Logical operations
                | Decr  | Incr
                deriving (Eq,Show,Read)

data Instruction = Compute Operator RegAddr RegAddr RegAddr             -- Compute opCode r0 r1 r2: go to "alu",
                                                                        --       do "opCode" on regs r0, r1, and put result in reg r2
                 | Jump Target                                          -- Jump t: jump to target t (absolute, relative, indirect)
                 | Branch RegAddr Target                                -- Branch r t: conditional jump, depending on register r

                 | Load AddrImmDI RegAddr                               -- Load (ImmValue n) r: put "value n" in "regbank r"
                                                                        -- Load (DirAddr a) r : from "memory a" to "regbank r"
                                                                        -- Load (IndAddr p) r : from memory indexed by register p to "r"

                 | Store RegAddr AddrImmDI                              -- Store r (DirAddr a): from "regbank r" to "memory a"
                                                                        -- Store r (IndAddr p): from "r" to memory indexed by register p
                                                                        -- Undefined for ImmValue.

                 | Push RegAddr                                         -- push a value on the stack
                 | Pop RegAddr                                          -- pop a value from the stack

                 | ReadInstr AddrImmDI                                  -- Send read request for an external address
                 | Receive RegAddr                                      -- Wait for a reply of a request and save it in register
                 | WriteInstr RegAddr AddrImmDI                         -- Write content of reg to an external address
                 | TestAndSet AddrImmDI                                 -- Request a test on address for 0 and sets it to 1 if it is.
                                                                        -- Reply will contain 1 on success, and 0 on failure.
                                                                        -- This is an atomic operation; it might therefore be
                                                                        -- used to implement locks or synchronisation.

                 | EndProg                                              -- end of program, deactivates Sprockell. If all sprockells are at
                                                                        -- this instruction, the simulation will halt.
                 | Nop                                                  -- "No operation".
                 | Debug String                                         -- No real instruction, for debug purposes.
                 deriving (Eq,Show,Read)

-- ==========================================================================================================
-- Data structures for communication within and between Sprockells
-- ==========================================================================================================
data Target     = Abs CodeAddr
                | Rel CodeAddr
                | Ind RegAddr
                deriving (Eq,Show,Read)

data TargetCode = NoJump
                | TAbs
                | TRel
                | TInd
                | Waiting
                deriving (Eq,Show)

data AguCode    = AguDir
                | AguInd
                | AguPush
                | AguPop
                deriving (Eq,Show)

data LdCode     = LdImm
                | LdAlu
                | LdMem
                | LdPC
                | LdInp
                deriving (Eq,Show)

data StCode     = StNone
                | StMem
                deriving (Eq,Show)

data SPCode     = Down
                | Flat
                | Up
                deriving (Eq,Show)

data IOCode     = IONone
                | IORead
                | IOWrite
                | IOTest
                deriving (Eq,Show)

data MachCode = MachCode
        { ldCode        :: LdCode                       -- source of load results
        , stCode        :: StCode                       -- store command
        , aguCode       :: AguCode                      -- address calculation 
        , branch        :: Bool                         -- Jump or Branch
        , tgtCode       :: TargetCode                   -- Code to calculate next Program Counter
        , spCode        :: SPCode                       -- Stack pointer code
        , aluCode       :: Operator                     -- arithmetic operation
        , ioCode        :: IOCode                       -- communication with the rest of the system
        , immValue      :: Value                        -- value from Immediate
        , regX          :: RegAddr                      -- first input register
        , regY          :: RegAddr                      -- seconde input register
        , loadReg       :: RegAddr                      -- where load results are written to
        , addrImm       :: MemAddr                      -- address constant
        } deriving (Eq,Show)



-- ==========================================================================================================
-- Basic Functions                                              ***** STILL TO ABSTRACT AWAY FROM SW/HW *****
-- ==========================================================================================================
intBool :: Bool -> Value
intBool True  = 1
intBool False = 0

x +>> xs = [x] ++ init xs
xs <<+ x = tail xs ++ [x]

tail' xs | null xs      = xs
         | otherwise    = tail xs

f $> xs = map f xs

fs |$| xs = zipWith (\f x -> f x) fs xs

(!)  :: [a] -> Int -> a
xs ! i = xs !! i

(<~) :: [a] -> (Int, a) -> [a]
xs <~ (i,x) = take i xs ++ [x] ++ drop (i+1) xs

(<~!) :: [a] -> (Int, a) -> [a]
xs <~! (i,x)    | i == 0        = xs
                | otherwise     = xs <~ (i,x)


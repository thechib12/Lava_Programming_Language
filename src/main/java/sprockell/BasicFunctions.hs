module BasicFunctions where

-- ==========================================================================================================
-- Some elementary constants and Functions
-- ==========================================================================================================
reg0          = 0    :: Int                                 -- names for registers. reg0 is ALWAYS 0
regSprID      = 1    :: Int                                 -- regSprID: contains the sprockellID
regA          = 2    :: Int                                 -- registers A-E for other usage
regB          = 3    :: Int
regC          = 4    :: Int
regD          = 5    :: Int
regE          = 6    :: Int
regF          = 7    :: Int
regG          = 8    :: Int
regH          = 9    :: Int
regI          = 10    :: Int
regJ          = 11    :: Int
regK          = 12    :: Int
regL          = 13    :: Int
regM          = 14    :: Int
regN          = 15    :: Int
regO          = 16    :: Int
regP          = 17    :: Int
regQ          = 18    :: Int
regR          = 19    :: Int
regS          = 20    :: Int
regA1         = 21    :: Int
regB1         = 22    :: Int
regC1 = 23    :: Int
regD1 = 24    :: Int
regE1 = 25    :: Int
regF1 = 26    :: Int
regG1 = 27    :: Int
regH1 = 28    :: Int
regI1 = 29    :: Int
regJ1 = 30    :: Int
regK1 = 31    :: Int
regL1 = 32    :: Int
regM1 = 33    :: Int
regN1 = 34    :: Int
regO1 = 35    :: Int
regP1 = 36    :: Int
regQ1 = 37    :: Int
regR1 = 38    :: Int
regS1     = 39    :: Int




intBool True  = 1                                               -- Bool-to-Int
intBool False = 0

x +>> xs = [x] ++ init xs                                       -- shift value into buffer
xs <<+ x = tail xs ++ [x]

f  $>  xs = map f xs
fs |$| xs = zipWith (\f x -> f x) fs xs                         -- parallel application of a list of functions
                                                                -- to an equally long list of arguments

(!)  :: [a] -> Int -> a                                         -- list indexing
xs ! i = xs !! i

(<~) :: [a] -> (Int, a) -> [a]                                  -- put value x at address i in xs
xs <~ (i,x) = take i xs ++ [x] ++ drop (i+1) xs

(<~!) :: [a] -> (Int, a) -> [a]                                 -- ibid, but leave address 0 unchanged
xs <~! (i,x)    | i == 0        = xs
                | otherwise     = xs <~ (i,x)

x ∈ xs =  x `elem` xs

concatWith x [] = []                                            -- concats a list of lists with a "gluing element" x
concatWith x [y] = y
concatWith x (y:ys) = y ++ [x] ++ concatWith x ys

ljustify n x = x ++ replicate (n - length x) ' '                -- adds spaces upto n positions for outlining;
rjustify n x = replicate (n - length x) ' ' ++ x                -- may be used for your own show-function



module BasicFunctions where


x ∈ xs =  x `elem` xs

concatWith x [] = []
concatWith x [y] = y
concatWith x (y:ys) = y ++ [x] ++ concatWith x ys

ljustify n x = x ++ replicate (n - length x) ' '
rjustify n x = replicate (n - length x) ' ' ++ x




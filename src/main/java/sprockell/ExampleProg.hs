module ExampleProg where

import HardwareTypes

exampleProg = [ Load (ImmValue 0) 1
              , Store 1 (DirAddr 1)
              , Load (ImmValue 0) 1
              , Store 1 (DirAddr 3)
              , ReadInstr (DirAddr 0)
              , Receive 1
              , Store 1 (DirAddr 2)
              , Load (DirAddr 1) 1
              , Push 1
              , Load (DirAddr 2) 1
              , Pop 2
              , Compute Lt 2 1 1
              , Branch 1 (Rel 2)
              , Jump (Rel 14)
              , Load (DirAddr 1) 1
              , Push 1
              , Load (ImmValue 1) 1
              , Pop 2
              , Compute Add 2 1 1
              , Store 1 (DirAddr 1)
              , Load (DirAddr 3) 1
              , Push 1
              , Load (DirAddr 1) 1
              , Pop 2
              , Compute Add 2 1 1
              , Store 1 (DirAddr 3)
              , Jump (Rel (-19))
              , EndProg
              ]

masterProg = [ Load (ImmValue 5) 1
             , Store 1 (DirAddr 1)
             , Load (ImmValue 5) 1
             , Store 1 (DirAddr 2)
             , Load (ImmValue 12) 1
             , Store 1 (DirAddr 3)
             , Load (DirAddr 1) 1
             , Push 1
             , Load (DirAddr 3) 1
             , Pop 2
             , Compute Lt 2 1 1
             , Push 1
             , Load (DirAddr 2) 1
             , Push 1
             , Load (DirAddr 3) 1
             , Pop 2
             , Compute Lt 2 1 1
             , Pop 2
             , Compute Or 2 1 1
             , Branch 1 (Rel 2)
             , Jump (Rel 59)
             , ReadInstr (DirAddr 0)
             , Receive 1
             , Store 1 (DirAddr 5)
             , ReadInstr (DirAddr 2)
             , Receive 1
             , Store 1 (DirAddr 6)
             , Load (DirAddr 5) 1
             , Push 1
             , Load (ImmValue 0) 1
             , Pop 2
             , Compute Equal 2 1 1
             , Push 1
             , Load (DirAddr 1) 1
             , Push 1
             , Load (DirAddr 3) 1
             , Pop 2
             , Compute Lt 2 1 1
             , Pop 2
             , Compute And 2 1 1
             , Branch 1 (Rel 2)
             , Jump (Rel 11)
             , Load (DirAddr 1) 1
             , Push 1
             , Load (ImmValue 1) 1
             , Pop 2
             , Compute Add 2 1 1
             , Store 1 (DirAddr 1)
             , Load (DirAddr 1) 1
             , WriteInstr 1 (DirAddr 1)
             , Load (ImmValue 1) 1
             , WriteInstr 1 (DirAddr 0)
             , Load (DirAddr 6) 1
             , Push 1
             , Load (ImmValue 1) 1
             , Pop 2
             , Compute Equal 2 1 1
             , Push 1
             , Load (DirAddr 2) 1
             , Push 1
             , Load (DirAddr 3) 1
             , Pop 2
             , Compute Lt 2 1 1
             , Pop 2
             , Compute And 2 1 1
             , Branch 1 (Rel 2)
             , Jump (Rel 12)
             , Load (DirAddr 2) 1
             , Push 1
             , Load (ImmValue 1) 1
             , Pop 2
             , Compute Add 2 1 1
             , Store 1 (DirAddr 2)
             , ReadInstr (DirAddr 5)
             , Receive 1
             , Store 1 (DirAddr 4)
             , Load (ImmValue 0) 1
             , WriteInstr 1 (DirAddr 2)
             , Jump (Rel (-72))
             , Load (ImmValue 1) 1
             , WriteInstr 1 (DirAddr 6)
             , EndProg
             ]

workerProg = [ Load (ImmValue 60) 1
             , Push 1
             , Load (DirAddr 0) 1
             , Pop 2
             , Compute Mul 2 1 1
             , Push 1
             , Load (ImmValue 40) 1
             , Pop 2
             , Compute Sub 2 1 1
             , Compute Decr 1 0 1
             , Branch 1 (Rel (-1))
             , ReadInstr (DirAddr 6)
             , Receive 1
             , Push 1
             , Load (ImmValue 1) 1
             , Pop 2
             , Compute NEq 2 1 1
             , Branch 1 (Rel 2)
             , Jump (Rel 58)
             , ReadInstr (DirAddr 0)
             , Receive 1
             , Store 1 (DirAddr 5)
             , Load (DirAddr 5) 1
             , Push 1
             , Load (ImmValue 1) 1
             , Pop 2
             , Compute Equal 2 1 1
             , Branch 1 (Rel 2)
             , Jump (Rel 47)
             , ReadInstr (DirAddr 1)
             , Receive 1
             , Store 1 (DirAddr 1)
             , Load (ImmValue 0) 1
             , WriteInstr 1 (DirAddr 0)
             , Load (ImmValue 0) 1
             , Store 1 (DirAddr 2)
             , Load (ImmValue 0) 1
             , Store 1 (DirAddr 3)
             , Load (DirAddr 2) 1
             , Push 1
             , Load (DirAddr 1) 1
             , Pop 2
             , Compute Lt 2 1 1
             , Branch 1 (Rel 2)
             , Jump (Rel 14)
             , Load (DirAddr 2) 1
             , Push 1
             , Load (ImmValue 1) 1
             , Pop 2
             , Compute Add 2 1 1
             , Store 1 (DirAddr 2)
             , Load (DirAddr 3) 1
             , Push 1
             , Load (DirAddr 2) 1
             , Pop 2
             , Compute Add 2 1 1
             , Store 1 (DirAddr 3)
             , Jump (Rel (-19))
             , ReadInstr (DirAddr 2)
             , Receive 1
             , Push 1
             , Load (ImmValue 0) 1
             , Pop 2
             , Compute NEq 2 1 1
             , Branch 1 (Rel 2)
             , Jump (Rel 2)
             , Jump (Rel (-8))
             , Load (DirAddr 0) 1
             , WriteInstr 1 (DirAddr 3)
             , Load (DirAddr 1) 1
             , WriteInstr 1 (DirAddr 4)
             , Load (DirAddr 3) 1
             , WriteInstr 1 (DirAddr 5)
             , Load (ImmValue 1) 1
             , WriteInstr 1 (DirAddr 2)
             , Jump (Rel (-64))
             , EndProg
             ]

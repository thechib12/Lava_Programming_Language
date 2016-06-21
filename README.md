# Lava
                        (   (( . : (    .)   ) :  )
                          (   ( :  .  :    :  )  ))
                           ( ( ( (  .  :  . . ) )
                            ( ( : :  :  )   )  )
                             ( :(   .   .  ) .'
                              '. :(   :    )
                                (   :  . )  )
                                 ')   :   #@##
                                #',### " #@  #@
                               #/ @'#~@#~/\   #
                             ##  @@# @##@  `..@,
                           @#/  #@#   _##     `\
                         @##;  `#~._.' ##@      \_
                       .-#/           @#@#@--,_,--\
                      / `@#@..,     .~###'         `~.
                    _/         `-.-' #@####@          \
                 __/     &^^       ^#^##~##&&&   %     \_
                /       && ^^      @#^##@#%%#@&&&&  ^    \
              ~/         &&&    ^^^   ^^   &&&  %%% ^^^   `~._
           .-'   ^^    %%%. &&   ___^     &&   && &&   ^^     \
          /akg ^^^ ___&&& X & && |n|   ^ ___ %____&& . ^^^^^   `~.
                   |M|       ---- .  ___.|n| /\___\  X
                             |mm| X  |n|X    ||___|             

Visit our wiki for more detailed information.
[Wiki](https://github.com/thechib12/Lava_Programming_Language/wiki)

TODO:
verslag - shared var keuze
grammar formatten!!! (plugin?)
tests aanvullen met nieuwe functies

INTRODUCTION
LAVA Programming Language
We came up with LAVA, because we wanted to have an original programming language,
different from others, but clear and easy to use. We decided to use other keywords than you are used to.

Also we wanted to include some references to movies and such, but thats something you would have to find out yourself


### Features
- Variable declaration with the option to initialize it.
- Variable assingment with expression, functions, constants, arrays and other variables.
- Local variables in global scope and in function scope.
- Shared variables will be put in shared memory which can be accessed by other threads.
- Functions in a single scope, only at the global can functions be defined. 
- Special `main` function. The runtime system starts your program by calling `main` function first.
- `if-then-else` branching.
- `while` loops.
- `fork` and `join` to execute tasks in parallel.
- Arrays with primitive types which will be evaluated at run-time.


#### Variables
At variable declaration, if not initialized, the default value of the type will be used.
 

### Syntax
We define the following keywords with its translation.

Type            | Actual
----            | ----
chamber         | class
temperature     | boolean
rock            | int
mineral         | char
mine            | string
hot             | true
cold            | false
[]              | array
pebble *         | double
void (function only)            | void
brock  *         | long


Keyword             | Java
---------           | --------
Volcano*             | Object
erupt               | main
$varname            | variable
shared              | put variable in shared memory
rupture             | function
if                  | if
while               | while
extinguish          | delete Object
Line ending         | ;
Block of statements | {}
and                 | &&
or                  | ||
xor                 | ^


TODO:
 
Function | Action
--------| --------
explode | print a string to the standard output
implode | prompt a user for input
fork    | execute given function in parallel
join    | wait until all other threads are finished


*not implemented yet


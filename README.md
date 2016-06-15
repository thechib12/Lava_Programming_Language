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





INTRODUCTION
LAVA Programming Language
We came up with LAVA, because we wanted to have an original programming language,
different from others, but clear and easy to use. We decided to use other keywords than you are used to.

Also we wanted to include some references to movies and such, but thats something you would have to find out yourself


### Syntax
We define the following keywords with its translation.

Type            | Actual
----            | ----
chamber         |  class
temperature     | boolean
hot             | true
cold            | false
[]              | array
pebble          | double
rock            | int
mineral         | char
mine            | string
void            | void
brock           | long


Keyword             | Java
---------           | --------
Volcano*             | Object
erupt               | main
$varname            | variable
explode             | print
implode             | input
rupture             | function
if                  | if
while               | while
fork                | fork
join                | join
extinguish          | delete Object
Line ending         | ;
Block of statements | {}
and                 | &&
or                  | ||
xor                 | ^

Example program: *hello.magma*:
```
  chamber hello {
      erupt (){
          explode("Hello 7 tectonic plates!");
      }
  }
  
  /^\ Prints a String to the console
```

Example program: *gcd.magma*:
```
  chamber gcd {
      rock $count;
  
      rupture rock gcd (rock $a, rock $b){
          $count = 0;
          rock $result = 0;
          if ($a == $b) then {
              $result = $a;
          } else if ($a > $b) then {
              $result = gcd(($a-$b), $b);
          } else {
              $result = gcd(($b-$a), $a);
          }
          $count = $count + 1;
          return $result;
      }
  
  }
  

```

Example program: *gauss.magma*:
```
  chamber gauss {
      erupt() {
          explode("Number? ");
          mine $x = implode();
          rock $x1 = x.toRock();
          rock $count = 0;
          rock $y     = 0;
          while ($count < $x1){
              $y = $y + $count;
              $count = $count + 1;
          }
          explode("Gauss: " + $y);
       }
  
  }

```

Example program: *max.magma*:
```
  chamber max {
      erupt(){
          rock[] $array = [0,45,2,7,4];
          rock $x = max ($array);
          explode("Maximum: "  + $x);
      }
  
      rupture rock max (rock[] $a){
          rock $maximum = 0;
          rock $counter =0;
          while ($counter < $a.length()){
            if ($a[$counter] >= $maximum) then {
              $maximum = $a[$counter];
            }
            $counter = $counter + 1;
          }
          return $maximum;
      }
  }

```

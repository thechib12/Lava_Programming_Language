grammar Lava;

import LavaVocab;

program: CHAMBER ID LBRACE body  RBRACE EOF;


body: localVariableDeclarationStatement* functiondecl*;


statement :
      target ASS expr SEMI                                  #assignStat
    | IF LPAR expr RPAR THEN statement (ELSE statement)?    #ifStat
    | WHILE LPAR expr RPAR  statement                       #whileStat
    | block                                                 #blockStat
    | function                                              #functionStat
    | RETURN expr SEMI                                      #returnStat
    | emptyStatement                                        #emptyStat
    ;

block :
    LBRACE blockStatements RBRACE
    ;

blockStatements :
    blockStatement blockStatement*
    ;

blockStatement :
      localVariableDeclarationStatement
    | statement
    ;


localVariableDeclarationStatement:
    localVariableDeclaration SEMI
    ;

emptyStatement:
    SEMI
    ;

localVariableDeclaration :
    type VARID (ASS expr)?
    ;


main:
    ERUPT LPAR RPAR statement
    ;

functiondecl:
      (RUPTURE type ID LPAR parametersdecl RPAR statement )
    | main
    ;

function:
    ID LPAR parameters RPAR
    ;

parametersdecl:
    (type VARID(COMMA type VARID)*)?
    ;

target:
      VARID
    | VARID LBLOCK expr RBLOCK
    ;


arrayInit:
    LBLOCK parameters RBLOCK
    ;

parameters:
    ( expr (COMMA expr)*)?
    ;

compOp:
      EQ
    | GE
    | GT
    | LE
    | LT
    ;

boolOp:
      AND
    | OR
    | XOR
    ;

multOp: STAR | SLASH;

plusOp : PLUS | MINUS;

expr:
      expr DOT expr        #fieldExpr
    | NOT expr            #notExpr
    | expr multOp expr    #multExpr
    | expr plusOp expr    #plusExpr
    | expr boolOp expr #boolExpr
    | expr compOp expr #compExpr
    | LPAR expr RPAR    #parExpr
    | NUM               #numExpr
    | TRUE              #trueExpr
    | STATIC_STRING     #staticstringExpr
    | FALSE             #falseExpr
    | function             #inputExpr
    | arrayInit             #arrayInitExpr
    | VARID LBLOCK expr RBLOCK #arrayExpr
    | VARID                #idExpr
    ;

type :
     (SHARED)? primitiveType (LBLOCK RBLOCK)?
    ;

primitiveType:
      INTEGER  #intType
    | BOOLEAN  #boolType
    | DOUBLE   #doubleType
    | CHAR     #charType
    | LONG     #longType
    | STRING   #stringType
    | VOID     #voidType
    ;








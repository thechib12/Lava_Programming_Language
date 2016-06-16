grammar Lava;

import LavaVocab;

program: CHAMBER ID LBRACE body  RBRACE EOF;


body: localVariableDeclarationStatement* functiondecl* main?;


statement :
      target ASS expr SEMI                                  #assignStat
    | IF LPAR expr RPAR THEN block (ELSE IF LPAR expr RPAR THEN block)* (ELSE block)?    #ifStat
    | WHILE LPAR expr RPAR  block                       #whileStat
    | function  SEMI                                            #functionStat
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
    primitiveType VARID (ASS expr)?
    | primitiveType arrayType VARID ASS WITH SIZE INTEGER
    ;


main:
    ERUPT LPAR RPAR block
    ;

functiondecl:
      (RUPTURE type ID LPAR parametersdecl RPAR block )
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
     shared? primitiveType arrayType?
    ;

arrayType: LBLOCK RBLOCK;

shared : SHARED;

primitiveType:
      INTEGER  #intType
    | BOOLEAN  #boolType
    | DOUBLE   #doubleType
    | CHAR     #charType
    | LONG     #longType
    | STRING   #stringType
    | VOID     #voidType
    ;








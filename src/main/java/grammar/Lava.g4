grammar Lava;

import LavaVocab;

program: CHAMBER ID LBRACE body RBRACE EOF;


body: localVariableDeclarationStatement* functionDeclaration* main?;


statement :
      target ASS expr SEMI                                                              #assignStat
    | IF LPAR expr RPAR THEN block (ELSE IF LPAR expr RPAR THEN block)* (ELSE block)?   #ifStat
    | WHILE LPAR expr RPAR  block                                                       #whileStat
    | functionCall  SEMI                                                                #functionStat
    | RETURN expr SEMI                                                                  #returnStat
    | SEMI                                                                              #emptyStat
    ;

block :
    LBRACE (blockStatement blockStatement*) RBRACE
    ;

blockStatement :
      localVariableDeclarationStatement
    | statement
    ;


localVariableDeclarationStatement:
    localVariableDeclaration SEMI
    ;


localVariableDeclaration :
      shared? primitiveType VARID (ASS expr)?                       #primitiveDeclaration
    ;


main:
    ERUPT LPAR RPAR block
    ;

functionDeclaration:
      (RUPTURE type ID LPAR parametersDeclaration RPAR block )
    ;

functionCall:
    ID LPAR parameters RPAR
    ;

parametersDeclaration:
    (type VARID(COMMA type VARID)*)?
    ;

target:
      VARID                         #variableTarget
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

multOp: STAR ;

plusOp : PLUS | MINUS;

negaOp : NOT | MINUS;

expr:
     negaOp expr               #notExpr
    | expr multOp expr          #multExpr
    | expr plusOp expr          #plusExpr
    | expr boolOp expr          #boolExpr
    | expr compOp expr          #compExpr
    | LPAR expr RPAR            #parExpr
    | NUM                       #numExpr
    | CHARACTER                 #charExpr
    | TRUE                      #trueExpr
    | FALSE                     #falseExpr
    | functionCall              #functionExpr
    | VARID                     #idExpr
    ;

type :
     shared? primitiveType
    ;


shared : SHARED;

primitiveType:
      INTEGER  #intType
    | BOOLEAN  #boolType
    | CHAR     #charType
    | VOID     #voidType
    ;








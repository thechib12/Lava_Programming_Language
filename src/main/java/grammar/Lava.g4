grammar Lava;

import LavaVocab;

program: CHAMBER ID LBRACE body  RBRACE EOF;


body: localVariableDeclarationStatement* functionDeclaration* main?;


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
      shared? primitiveType VARID (ASS expr)?                       #primitiveDeclaration
    | primitiveType arrayType VARID ASS WITH SIZE NUM               #arrayDeclaration
    ;


main:
    ERUPT LPAR RPAR block
    ;

functionDeclaration:
      (RUPTURE type ID LPAR parametersDeclaration RPAR block )
    ;

function:
    ID LPAR parameters RPAR
    ;

parametersDeclaration:
    (type VARID(COMMA type VARID)*)?
    ;

target:
      VARID                         #variableTarget
    | VARID LBLOCK expr RBLOCK      #arrayIndexTarget
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

negaOp : NOT | MINUS;

expr:
      expr DOT expr        #fieldExpr
    | negaOp expr            #notExpr
    | expr multOp expr    #multExpr
    | expr plusOp expr    #plusExpr
    | expr boolOp expr #boolExpr
    | expr compOp expr #compExpr
    | LPAR expr RPAR    #parExpr
    | NUM               #numExpr
    | CHARACTER              #charExpr
    | TRUE              #trueExpr
    | FALSE             #falseExpr
    | function             #functionExpr
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
//    | DOUBLE   #doubleType
    | CHAR     #charType
//    | LONG     #longType
//    | STRING   #stringType
    | VOID     #voidType
    ;








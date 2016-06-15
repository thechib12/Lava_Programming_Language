grammar Lava;

import LavaVocab;

program: CHAMBER ID LBRACE body  RBRACE EOF;


body: localVariableDeclarationStatement* functiondecl+;


statement   : target ASS expr SEMI
            | IF LPAR expr RPAR THEN statement (ELSE statement)?
            | WHILE LPAR expr RPAR  statement
            | block
            | function
            | RETURN expr SEMI
            | emptyStatement
            ;

block : LBRACE blockStatements RBRACE;

blockStatements : blockStatement blockStatement*;

blockStatement : localVariableDeclaration
               | statement
                ;


localVariableDeclarationStatement: localVariableDeclaration SEMI;

emptyStatement:	';';

localVariableDeclaration : type VARID (ASS variableInit)? ;


main: ERUPT LPAR RPAR statement;

functiondecl: (RUPTURE type ID LPAR parametersdecl RPAR statement )
            | main
            ;

function: ID LPAR parameters RPAR;

parametersdecl: (type VARID(COMMA type VARID)*)?;

target:  VARID
      |  VARID LBLOCK expr RBLOCK
      ;

variableInit:   arrayInit
            |   expr;

arrayInit: LBLOCK parameters LBLOCK;

parameters: ( expr (COMMA expr)*)?;

compOp: EQ | GE | GT |LE ;
boolOp: AND | OR | XOR;
multOp: STAR | SLASH;
plusOp : PLUS | MINUS;

expr: NOT expr            #notExpr
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
    | VARID                #idExpr
    ;

type: INTEGER  #intType
    | BOOLEAN  #boolType
    | DOUBLE   #doubleType
    | CHAR     #charType
    | LONG     #longType
    | STRING   #stringType
    ;







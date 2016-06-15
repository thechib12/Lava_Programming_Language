grammar Lava;

import LavaVocab;

program: CHAMBER ID LBRACE body  RBRACE EOF;


body: localVariableDeclarationStatement* functiondecl*;


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

blockStatement : localVariableDeclarationStatement
               | statement
               ;


localVariableDeclarationStatement: localVariableDeclaration SEMI;

emptyStatement:	';';

localVariableDeclaration : type  VARID (ASS variableInit)? ;


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

arrayInit: LBLOCK parameters RBLOCK;

parameters: ( expr (COMMA expr)*)?;

compOp: EQ | GE | GT |LE | LT;
boolOp: AND | OR | XOR;
multOp: STAR | SLASH;
plusOp : PLUS | MINUS;

expr: expr DOT expr        #fieldExpr
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
    | VARID LBLOCK expr RBLOCK #arrayExpr
    | VARID                #idExpr
    ;

type : primitiveType (LBLOCK RBLOCK)?;

primitiveType: INTEGER  #intType
    | BOOLEAN  #boolType
    | DOUBLE   #doubleType
    | CHAR     #charType
    | LONG     #longType
    | STRING   #stringType
    | VOID     #voidType
    ;








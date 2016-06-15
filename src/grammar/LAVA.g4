grammar LAVA;

program: CHAMBER ID LBRACE (statement)* (functiondecl)* RBRACE EOF;

block: LBRACE (statement)* RBRACE;

statement:
    | PRINT LPAR expr RPAR SEMI
    | type target (ASS variableInit)? SEMI
    | target ASS expr SEMI
    | IF LPAR expr RPAR THEN block (ELSE IF LPAR expr RPAR THEN  block)* (ELSE block)?
    | WHILE LPAR expr RPAR   block
    | RETURN expr? SEMI
    | FORK  LPAR RPAR SEMI
    | JOIN LPAR RPAR SEMI
    ;


main: ERUPT LPAR RPAR block;

functiondecl: (RUPTURE type ID LPAR (type VARID(COMMA type VARID)*)? RPAR block ) | main;

function: ID LPAR ( expr (COMMA expr)*)? RPAR;

expr: expr multOp expr    #multExpr
    | expr plusOp expr    #plusExpr
    | expr boolOp expr #boolExpr
    | expr compOp expr #compExpr
    | LPAR expr RPAR    #parExpr
    | VARID                #idExpr
    | NUM               #numExpr
    | TRUE              #trueExpr
    | DQUOTE .*? DQUOTE #stringExpr
    | FALSE             #falseExpr
    | function          #functionExpr
    | INPUT             #inputExpr;

NUM: DIGIT+;


//TODO:Array initializers


target:  VARID
       |  LBLOCK RBLOCK VARID;

variableInit:   arrayInit
            |   expr;

arrayInit: LBLOCK (variableInit (COMMA variableInit)*  )? LBLOCK;

//types



type: INTEGER  #intType
    | BOOLEAN  #boolType
    | DOUBLE   #doubleType
    | CHAR     #charType
    | LONG     #longType
    | STRING   #stringType
    ;


compOp: EQ | GE | GT |LE | NE;
boolOp: AND | OR | XOR;
multOp: STAR | SLASH;
plusOp : PLUS | MINUS;



INTEGER:        R O C K;
BOOLEAN:        T E M P E R A T U R E;
DOUBLE:         P E B B L E;
CHAR:           M I N E R A L;
LONG:           B R O C K;
STRING:         M I N E;
IF:             I F;
THEN:           T H E N;
ELSE:           E L S E ;
CHAMBER:        C H A M B E R ;
WHILE :         W H I L E ;
TRUE :          H O T ;
FALSE:          C O L D;
AND:            A N D;
OR:             O R;
XOR:            X O R;
PRINT:          E X P L O D E;
INPUT:          I M P L O D E;
FORK:           F O R K;
JOIN:           J O I N;
RUPTURE:        R U P T U R E ;
ERUPT:          E R U P T ;
RETURN :        R E T U R N ;

DOLLAR: '$';
ASS:    '=';
COMMA:  ',';
DOT:    '.';
DQUOTE: '"';
EQ:     '==';
GE:     '>=';
GT:     '>';
LE:     '<=';
LBRACE: '{';
LPAR:   '(';
LT:     '<';
MINUS:  '-';
NE:     '!=';
PLUS:   '+';
RBRACE: '}';
RPAR:   ')';
SEMI:   ';';
SLASH:  '/';
STAR:   '*';
LBLOCK: '[';
RBLOCK: ']';

ID: LETTER (LETTER | DIGIT)*;

VARID : DOLLAR LETTER (LETTER | DIGIT)*;

/** Whitespace. */
WS: [ \t\r\n]+ -> skip;
COMMENT: '/^\\' ~[\r\n]* ->skip;

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];
fragment A: [a];
fragment B: [b];
fragment C: [c];
fragment D: [d];
fragment E: [e];
fragment F: [f];
fragment G: [g];
fragment H: [h];
fragment I: [i];
fragment J: [j];
fragment K: [k];
fragment L: [l];
fragment M: [m];
fragment N: [n];
fragment O: [o];
fragment P: [p];
fragment Q: [q];
fragment R: [r];
fragment S: [s];
fragment T: [t];
fragment U: [u];
fragment V: [v];
fragment W: [w];
fragment X: [x];
fragment Y: [y];
fragment Z: [z];
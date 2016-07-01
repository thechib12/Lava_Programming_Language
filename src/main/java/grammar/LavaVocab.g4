lexer grammar LavaVocab;


INTEGER:       'rock';
BOOLEAN:       'temperature';
CHAR:       'mineral';
VOID:           'void';
IF:             'if';
THEN:           'then';
ELSE:           'else' ;
CHAMBER:        'chamber' ;
WHILE :        'while' ;
TRUE :          'hot' ;
FALSE:          'cold';
AND:            'and';
OR:             'or';
XOR:           'xor';
RUPTURE:        'rupture' ;
ERUPT:          'erupt';
RETURN :       'return' ;
SHARED :        'shared' ;
NOT:     'not';




VARID : DOLLAR ID;


ID: LETTER (LETTER | DIGIT)*;



NUM: DIGIT+;

CHARACTER : '\'' ( . )? '\'';


LBLOCK: '[';
RBLOCK: ']';
DOLLAR: '$';
ASS:    '=';
COMMA:  ',';
DOT:    '.';
EQ:     '==';
GE:     '>=';
GT:     '>';
LE:     '<=';
LBRACE: '{';
LPAR:   '(';
LT:     '<';
MINUS:  '-';

PLUS:   '+';
RBRACE: '}';
RPAR:   ')';
SEMI:   ';';
STAR:   '*';




/** Whitespace. */
WS: [ \t\r\n]+ -> skip;
COMMENT: '/^\\' ~[\r\n]* ->skip;

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];
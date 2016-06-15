lexer grammar LavaVocab;


INTEGER:       'rock';
BOOLEAN:       'temperature';
DOUBLE:         'pebble';
CHAR:       'mineral';
LONG:           'brock';
STRING:         'mine';
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
//PRINT:          'explode';
//INPUT:         'implode';
//FORK:           'fork';
//JOIN:           'join';
RUPTURE:        'rupture' ;
ERUPT:          'erupt';
RETURN :       'return' ;
SHARED :        'shared' ;

STATIC_STRING : '"' (~["\\] | '\\'.)* '"';



VARID : DOLLAR ID;


ID: LETTER (LETTER | DIGIT)*;



NUM: DIGIT+;


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
NOT:     '!';
PLUS:   '+';
RBRACE: '}';
RPAR:   ')';
SEMI:   ';';
SLASH:  '/';
STAR:   '*';




/** Whitespace. */
WS: [ \t\r\n]+ -> skip;
COMMENT: '/^\\' ~[\r\n]* ->skip;

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];
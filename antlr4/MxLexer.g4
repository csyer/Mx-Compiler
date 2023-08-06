lexer grammar MxLexer;

// Operator
//  Standard operator
Add: '+';
Sub: '-';
Mul: '*';
Div: '/';
Mod: '%';

//  Comparative operator
Ge: '>';
Le: '<';
Geq: '>=';
Leq: '<=';
Neq: '!=';
Eq: '==';

//  Logical operator
LAnd: '&&';
LOr: '||';
LNot: '!';

//  Bytewise operator
RShift: '>>';
LShift: '<<';
And: '&';
Or: '|';
Xor: '^';
Not: '~';

//  Assignment operator
Assign: '=';

//  Self operation
SelfAdd: '++';
SelfSub: '--';

//  Component operator
Component: '.';

//  Index operator
LBracket: '[';
RBracket: ']';

//  Parenthesis
LParen: '(';
RParen: ')';

//  Ternary operation
Question: '?';
Colon: ':';

//  Seperator
Semi: ';';
Comma: ',';
LBrace: '{';
RBrace: '}';

// Key words
Void: 'void';
Bool: 'bool';
Int: 'int';
String: 'string';
New: 'new';
Class: 'class';
Null: 'null';
True: 'true';
False: 'false';
This: 'this';
If: 'if';
Else: 'else';
For: 'for';
While: 'while';
Break: 'break';
Continue: 'continue';
Return: 'return';

// Blank characters
Blank: [ \t\n\r]+ -> skip;

// Commentary
CommentLine: '//' ~[\r\n]* -> skip;
CommentPara: '/*' .*? '*/' -> skip;

// Identifier
Identifier: [a-zA-Z][a-zA-Z0-9_]*;

// Constant
IntConst: [1-9][0-9]* | '0';

Quote: '"';
StringConst: Quote ('\\n' | '\\\\' | '\\"' | [ -~])*? Quote;

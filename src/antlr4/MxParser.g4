parser grammar MxParser;
options {
	tokenVocab = MxLexer;
}

program: (funcDef | classDef | varDef)* EOF;

basicType: Int | Bool | String;
typename: basicType | Identifier;
type: typename (LBracket RBracket)*;

// Var and Array
varDefUnit: Identifier (Assign expr)?;
varDef: type varDefUnit (Comma varDefUnit)* Semi;

arrayDefUnit: LBracket expr? RBracket;

// Class
classConstructor:
	Identifier LParen RParen LBrace statement* RBrace;
classDef:
	Class Identifier LBrace (varDef | classConstructor | funcDef)* RBrace Semi;

// Function
returnType: type | Void;
parameter: (type Identifier) (Comma type Identifier)*;
funcDef:
	returnType Identifier LParen parameter? RParen LBrace statement* RBrace;

// Statement
statement:
	LBrace statement* RBrace
	| varDef
	| ifStmt
	| whileStmt
	| forStmt
	| breakStmt
	| continueStmt
	| returnStmt
	| exprStmt;

ifStmt: If LParen expr RParen statement (Else statement)?;
whileStmt: While LParen expr RParen statement;
forStmt: For LParen exprStmt exprStmt expr? RParen statement;

breakStmt: Break Semi;
continueStmt: Continue Semi;
returnStmt: Return expr? Semi;

exprStmt: expr? Semi;
exprList: expr (Comma expr)*;

expr: LParen expr RParen    
	| New type (arrayDefUnit)* (LParen RParen)? 	// NewArray
	| expr Component Identifier				    	// Component
	| expr LParen exprList? RParen			    	// Function
	| expr LBracket expr RBracket				    // ArrayIndex
	| <assoc = right> expr op = (SelfAdd | SelfSub) 
	| op = (SelfAdd | SelfSub) expr
	| <assoc = right> op = (Add | Sub) expr
	| <assoc = right> op = (Not | LNot) expr
	| expr op = (Mul | Div | Mod) expr
	| expr op = (Add | Sub) expr
	| expr op = (LShift | RShift) expr
	| expr op = (Ge | Le | Geq | Leq) expr
	| expr op = (Eq | Neq) expr
	| expr op = And expr
	| expr op = Xor expr
	| expr op = Or expr
	| expr op = LAnd expr
	| expr op = LOr expr
    | expr Question expr Colon expr
    | <assoc = right> expr op = Assign expr
    | basicExpr;

basicExpr:
	IntConst
	| StringConst
	| True
	| False
	| Null
	| Identifier
	| This;
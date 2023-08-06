parser grammar MxParser;
options {
	tokenVocab = MxLexer;
}

program: (funcDef | classDef | varDef)* EOF;

typename: Int | Bool | String | Identifier;
type: typename (LBracket RBracket)*;

// Var and Array
varDefUnit: Identifier (Assign expr)?;
varDef: type varDefUnit (Comma varDefUnit)* Semi;

// Class
classConstructor: Identifier LParen RParen LBrace suite RBrace;
classDef:
	Class Identifier LBrace (varDef | classConstructor | funcDef)* RBrace Semi;

// Function
returnType: type | Void;
parameter: (type Identifier) (Comma type Identifier)*;
funcDef:
	returnType (funcName = Identifier) LParen parameter? RParen LBrace suite RBrace;

// Statement
statement:
	LBrace suite RBrace
	| varDef
	| ifStmt
	| whileStmt
	| forStmt
	| breakStmt
	| continueStmt
	| returnStmt
	| exprStmt;
suite: statement*;

ifStmt:
	If LParen condition = expr RParen trueStmt = statement (
		Else falseStmt = statement
	)?;
whileStmt: While LParen condition = expr RParen statement;
forStmt:
	For LParen initial = statement? condition = exprStmt? step = expr? RParen block = statement;

breakStmt: Break Semi;
continueStmt: Continue Semi;
returnStmt: Return returnValue = expr? Semi;
exprStmt: expr? Semi;

exprList: expr (Comma expr)*;
arrayDef: LBracket expr? RBracket;
expr:
	LParen expr RParen																	# NestedExpr
	| New type (arrayDef)* (LParen RParen)?												# NewExpr
	| expr Component Identifier															# ComponentExpr
	| expr LParen exprList? RParen														# FunctionExpr
	| array = expr LBracket index = expr RBracket										# AccessArrayExpr
	| <assoc = right> expr op = (SelfAdd | SelfSub)										# IncExpr
	| op = (SelfAdd | SelfSub) expr														# UnaryExpr
	| <assoc = right> op = (Sub | Not | LNot) expr										# UnaryExpr
	| lhs = expr op = (Mul | Div | Mod) rhs = expr										# BinaryExpr
	| lhs = expr op = (Add | Sub) rhs = expr											# BinaryExpr
	| lhs = expr op = (LShift | RShift) rhs = expr										# BinaryExpr
	| lhs = expr op = (Ge | Le | Geq | Leq) rhs = expr									# BinaryExpr
	| lhs = expr op = (Eq | Neq) rhs = expr												# BinaryExpr
	| lhs = expr op = And rhs = expr													# BinaryExpr
	| lhs = expr op = Xor rhs = expr													# BinaryExpr
	| lhs = expr op = Or rhs = expr														# BinaryExpr
	| lhs = expr op = LAnd rhs = expr													# BinaryExpr
	| lhs = expr op = LOr rhs = expr													# BinaryExpr
	| <assoc = right> condition = expr Question trueExpr = expr Colon falseExpr = expr	# TernaryExpr
	| <assoc = right> lhs = expr Assign rhs = expr										# AssignExpr
	| (IntConst | StringConst | True | False | Null)									# LiteralExpr
	| (Identifier | This)																# AtomExpr;

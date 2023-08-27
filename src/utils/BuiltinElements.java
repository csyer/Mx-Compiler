package utils;

import IR.entity.IRBoolConst;
import IR.entity.IRIntConst;
import IR.entity.IRNullConst;
import IR.entity.IRVoidConst;
import IR.type.IRIntType;
import IR.type.IRPtrType;
import IR.type.IRType;
import IR.type.IRVoidType;
import ast.FuncDefNode;

public interface BuiltinElements {
    Type voidType = new Type("void");
    Type intType = new Type("int");
    Type boolType = new Type("bool");
    Type stringType = new Type("string");
    Type nullType = new Type("null");
    Type thisType = new Type("this");

    FuncDefNode printFunc = new FuncDefNode(voidType, "print", null);
    FuncDefNode printlnFunc = new FuncDefNode(voidType, "println", null);
    FuncDefNode printIntFunc = new FuncDefNode(voidType, "printInt", null);
    FuncDefNode printlnIntFunc = new FuncDefNode(voidType, "printlnInt", null);
    FuncDefNode getStringFunc = new FuncDefNode(stringType, "getString", null);
    FuncDefNode getIntFunc = new FuncDefNode(intType, "getInt", null);
    FuncDefNode toStringFunc = new FuncDefNode(stringType, "toString", null);

    FuncDefNode stringLengthFunc = new FuncDefNode(intType, "length", "string", null);
    FuncDefNode stringSubStringFunc = new FuncDefNode(stringType, "substring", "string", null);
    FuncDefNode stringParseIntFunc = new FuncDefNode(intType, "parseInt", "string", null);
    FuncDefNode stringOrdFunc = new FuncDefNode(intType, "ord", "string", null);

    FuncDefNode ArraySizeFunc = new FuncDefNode(intType, "size", null);

    IRType irVoidType = new IRVoidType();
    IRType irIntType = new IRIntType(32);
    IRType irBoolType = new IRIntType(1);
    IRType irCharType = new IRIntType(8);
    IRType irStringtType = new IRPtrType(irCharType);
    IRType irNullType = new IRPtrType(irVoidType);

    IRVoidConst irVoidConst = new IRVoidConst();
    IRNullConst irNullConst = new IRNullConst();
    IRBoolConst irTrueConst = new IRBoolConst(true);
    IRBoolConst irFalseConst = new IRBoolConst(false);
    IRIntConst irIntConst0 = new IRIntConst(0);
    IRIntConst irIntConst1 = new IRIntConst(1);
    IRIntConst irIntConstn1 = new IRIntConst(-1);
}
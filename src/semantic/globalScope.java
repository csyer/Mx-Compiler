package semantic;

import java.util.HashMap;

import ast.*;

public class globalScope extends Scope {
    private HashMap<String, FuncDefNode> funcDefs = new HashMap<>();
    private HashMap<String, ClassDefNode> classDefs = new HashMap<>();

    public globalScope(Scope parentScope) {
        super(parentScope);

        printFunc.param.list.add(new VarDefUnitNode(stringType, "str", null));
        printlnFunc.param.list.add(new VarDefUnitNode(stringType, "str", null));
        printIntFunc.param.list.add(new VarDefUnitNode(intType, "n", null));
        printlnIntFunc.param.list.add(new VarDefUnitNode(intType, "n", null));
        toStringFunc.param.list.add(new VarDefUnitNode(intType, "i", null));
        funcDefs.put("print", printFunc);
        funcDefs.put("println", printlnFunc);
        funcDefs.put("printInt", printIntFunc);
        funcDefs.put("printlnInt", printlnIntFunc);
        funcDefs.put("getString", getStringFunc);
        funcDefs.put("getInt", getIntFunc);
        funcDefs.put("toString", toStringFunc);

        stringSubStringFunc.param.list.add(new VarDefUnitNode(intType, "left", null));
        stringSubStringFunc.param.list.add(new VarDefUnitNode(intType, "right", null));
        stringOrdFunc.param.list.add(new VarDefUnitNode(intType, "pos", null));
        ClassDefNode stringDef = new ClassDefNode("string", null);
        stringDef.memberFunc.put("length", stringLengthFunc);
        stringDef.memberFunc.put("substring", stringSubStringFunc);
        stringDef.memberFunc.put("parseInt", stringParseIntFunc);
        stringDef.memberFunc.put("ord", stringOrdFunc);

        classDefs.put("string", stringDef);
        classDefs.put("int", new ClassDefNode("int", null));
        classDefs.put("bool", new ClassDefNode("bool", null));
    }

    public void putFunc(String funcName, FuncDefNode node) {
        this.funcDefs.put(funcName, node);
    }
    public FuncDefNode getFunc(String funcName) {
        return this.funcDefs.get(funcName);
    }

    public void putClass(String className, ClassDefNode node) {
        this.classDefs.put(className, node);
    }
    public ClassDefNode getClass(String className) {
        return this.classDefs.get(className);
    }
}

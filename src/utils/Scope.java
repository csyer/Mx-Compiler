package utils;

import java.util.HashMap;

import IR.entity.IRVar;
import ast.ClassDefNode;
import ast.stmt.*;

public class Scope implements BuiltinElements {
    public HashMap<String, Type> varDefs;
    public Scope parentScope;
    public Type returnType = null;
    public boolean isReturn = false;
    public WhileStmtNode inLoop = null;
    public ClassDefNode inClass = null;

    public HashMap<String, IRVar> IRVars;

    public Scope(Scope parentScope) {
        this.varDefs = new HashMap<>();
        this.IRVars = new HashMap<>();
        this.parentScope = parentScope;
        if (parentScope != null) {
            this.inLoop = parentScope.inLoop;
            this.inClass = parentScope.inClass;
        }
    }

    public void addVar(String varName, Type type, Position pos) {
        if(varDefs.containsKey(varName)) {
            throw new Error("Variable redefined", pos);
        }
        varDefs.put(varName, type);
    }

    public IRVar getIRVar(String varName) {
        IRVar var = IRVars.get(varName);
        if (var != null) return var;
        return parentScope == null ? null : parentScope.getIRVar(varName);
    }
}

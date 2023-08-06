package semantic;

import java.util.HashMap;

import ast.ClassDefNode;
import ast.stmt.*;
import utils.Error;
import utils.*;

public class Scope implements BuiltinElements {
    public HashMap<String, Type> varDefs;
    public Scope parentScope;
    public Type returnType = null;
    public boolean isReturn = false;
    public StmtNode inLoop = null;
    public ClassDefNode inClass = null;

    public Scope(Scope parentScope) {
        this.varDefs = new HashMap<>();
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
}

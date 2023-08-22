package ast.expr;

import utils.*;
import IR.entity.IREntity;
import IR.entity.IRVar;
import ast.*;

public abstract class ExprNode extends ASTNode {
    public Type type;
    public FuncDefNode funcDef = null, gfuncDef = null;

    public IRVar ptr = null;
    public IREntity value = null;
    
    public ExprNode(Position pos) {
        super(pos);
    }
    
    public abstract boolean isAssignable();
}
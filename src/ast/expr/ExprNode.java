package ast.expr;

import utils.*;

import ast.*;

public abstract class ExprNode extends ASTNode {
    public Type type;
    public FuncDefNode funcDef = null, gfuncDef = null;
    public ExprNode(Position pos) {
        super(pos);
    }
    
    public abstract boolean isAssignable();
}
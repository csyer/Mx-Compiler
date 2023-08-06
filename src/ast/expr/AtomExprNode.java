package ast.expr;

import utils.*;

import ast.*;

public class AtomExprNode extends ExprNode {
    public String varName;

    public AtomExprNode(Position pos) {
        super(pos);
    }

    @Override
    public boolean isAssignable() {
        if (this.varName.equals("this")) return false;
        return true;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        System.out.print(varName);
    }
}
package ast.expr;

import utils.*;

import ast.*;

public class LiteralExprNode extends ExprNode {
    public String typename;

    public LiteralExprNode(String typename, Position pos) {
        super(pos);
        this.typename = typename;
    }

    @Override
    public boolean isAssignable() {
        return false;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        System.out.printf("%s", this.typename);
    }
}
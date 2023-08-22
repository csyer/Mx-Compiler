package ast.expr;

import utils.*;

import ast.*;

public class LiteralExprNode extends ExprNode {
    public String str;

    public LiteralExprNode(String str, Position pos) {
        super(pos);
        this.str = str;
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
        System.out.printf("%s", this.str);
    }
}
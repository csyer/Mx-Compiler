package ast.expr;

import utils.*;

import ast.*;

public class LiteralExprNode extends ExprNode {
    String type;

    public LiteralExprNode(String type, Position pos) {
        super(pos);
        this.type = type;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        System.out.printf("%s", this.type);
    }
}
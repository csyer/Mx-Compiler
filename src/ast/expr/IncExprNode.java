package ast.expr;

import utils.*;

import ast.*;

public class IncExprNode extends ExprNode {
    public String op;
    public ExprNode expr;

    public IncExprNode(String op, ExprNode expr, Position pos) {
        super(pos);
        this.op = op;
        this.expr = expr;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        this.expr.debug();
        System.out.print(this.op);
    }
}
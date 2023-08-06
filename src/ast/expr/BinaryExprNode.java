package ast.expr;

import utils.*;

import ast.*;

public class BinaryExprNode extends ExprNode {
    public String op;
    public ExprNode lhs, rhs;

    public BinaryExprNode(ExprNode lhs, String op, ExprNode rhs, Position pos) {
        super(pos);
        this.lhs = lhs;
        this.op = op;
        this.rhs = rhs;
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
        System.out.print("(");
        this.lhs.debug();
        System.out.printf(" " + this.op + " ");
        this.rhs.debug();
        System.out.print(")");
    }
}
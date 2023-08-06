package ast.expr;

import utils.*;

import ast.*;

public class AssignExprNode extends ExprNode {
    public ExprNode lhs, rhs;

    public AssignExprNode(ExprNode lhs, ExprNode rhs, Position pos) {
        super(pos);
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public boolean isAssignable() {
        return true;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        lhs.debug();
        System.out.print(" = ");
        rhs.debug();
    }
}
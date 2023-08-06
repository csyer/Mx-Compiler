package ast.expr;

import utils.*;

import ast.*;

public class TernaryExprNode extends ExprNode {
    public ExprNode condition, trueExpr, falseExpr;

    public TernaryExprNode(ExprNode condition, ExprNode trueExpr, ExprNode falseExpr, Position pos) {
        super(pos);
        this.condition = condition;
        this.trueExpr = trueExpr;
        this.falseExpr = falseExpr;
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
        this.condition.debug();
        System.out.print(" ? ");
        this.trueExpr.debug();
        System.out.print(" : ");
        this.falseExpr.debug();
    }
}
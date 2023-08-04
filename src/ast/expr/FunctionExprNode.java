package ast.expr;

import utils.*;

import ast.*;

public class FunctionExprNode extends ExprNode {
    public ExprNode func;
    public ExprListNode args;

    public FunctionExprNode(ExprNode func, Position pos) {
        super(pos);
        this.func = func;
        this.args = null;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        System.out.print("Call function ");
        this.func.debug();
        this.args.debug();
    }
}
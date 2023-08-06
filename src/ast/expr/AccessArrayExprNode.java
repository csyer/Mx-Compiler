package ast.expr;

import utils.*;

import ast.*;

public class AccessArrayExprNode extends ExprNode {
    public ExprNode array, index;

    public AccessArrayExprNode(ExprNode array, ExprNode index, Position pos) {
        super(pos);
        this.array = array;
        this.index = index;
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
        this.array.debug();
        System.out.print("[");
        this.index.debug();
        System.out.print("]");
    }
}
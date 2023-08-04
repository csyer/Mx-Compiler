package ast.expr;

import utils.*;

import ast.*;

public class AtomExprNode extends ExprNode {
    public String type;

    public AtomExprNode(Position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        System.out.print(type);
    }
}
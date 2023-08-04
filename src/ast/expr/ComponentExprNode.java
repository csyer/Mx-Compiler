package ast.expr;

import utils.*;

import ast.*;

public class ComponentExprNode extends ExprNode {
    public ExprNode object;
    public String member;

    public ComponentExprNode(ExprNode object, String member, Position pos) {
        super(pos);
        this.object = object;
        this.member = member;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        this.object.debug();
        System.out.print("." + this.member);
    }
}
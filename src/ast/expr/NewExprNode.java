package ast.expr;

import ast.*;
import utils.Position;

import java.util.ArrayList;

public class NewExprNode extends ExprNode {
    public ArrayList<ExprNode> exprs = new ArrayList<ExprNode>();
    public int dim;

    public NewExprNode(int dim, Position pos) {
        super(pos);
        this.dim = dim;
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
        System.out.printf("new %d dim array", this.dim);
    }
}
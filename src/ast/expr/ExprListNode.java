package ast.expr;

import utils.*;

import ast.*;
import java.util.ArrayList;

public class ExprListNode extends ASTNode {
    public ArrayList<ExprNode> exprs = new ArrayList<ExprNode>();

    public ExprListNode(Position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        System.out.print(" (ExprList: ");
        for (var expr : this.exprs) {
            expr.debug();
            System.out.print(", ");
        }
        System.out.print(") ");
    }
}
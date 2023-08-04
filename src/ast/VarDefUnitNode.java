package ast;

import ast.expr.ExprNode;
import utils.*;

public class VarDefUnitNode extends ASTNode {
    public String identifier;
    public ExprNode initial;

    public VarDefUnitNode(String identifier, Position pos) {
        super(pos);
        this.identifier = identifier;
        this.initial = null;
    }

    public VarDefUnitNode(String identifier, ExprNode initial, Position pos) {
        super(pos);
        this.identifier = identifier;
        this.initial = initial;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        System.out.printf("%s", this.identifier);
        if (this.initial != null) {
            System.out.printf(" = ");
            this.initial.debug();
        }
        System.out.printf(" ,");
    }
}
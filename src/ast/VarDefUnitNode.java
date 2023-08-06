package ast;

import ast.expr.ExprNode;
import utils.*;

public class VarDefUnitNode extends ASTNode {
    public Type type;
    public String varName;
    public ExprNode initial;

    public VarDefUnitNode(String varName, Position pos) {
        super(pos);
        this.varName = varName;
        this.initial = null;
    }
    public VarDefUnitNode(Type type, String varName, Position pos) {
        super(pos);
        this.type = type;
        this.varName = varName;
        this.initial = null;
    }
    public VarDefUnitNode(String varName, ExprNode initial, Position pos) {
        super(pos);
        this.varName = varName;
        this.initial = initial;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        System.out.printf("%s: %s", this.type.typeName, this.varName);
        if (this.initial != null) {
            System.out.printf(" = ");
            this.initial.debug();
        }
        System.out.printf(" ,");
    }
}
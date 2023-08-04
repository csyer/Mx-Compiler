package ast;

import utils.*;

import java.util.ArrayList;

public class ParameterNode extends ASTNode {
    public ArrayList<VarDefUnitNode> list = new ArrayList<VarDefUnitNode>();

    public ParameterNode(Position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        System.out.printf("Parameter: ");
        for (var obj : this.list) {
            obj.debug();
        }
    }
}
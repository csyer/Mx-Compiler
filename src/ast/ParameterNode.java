package ast;

import utils.*;

import java.util.ArrayList;

public class ParameterNode extends ASTNode {
    public ArrayList<VarDefUnitNode> list = new ArrayList<VarDefUnitNode>();

    public ParameterNode(Position pos) {
        super(pos);
    }

    public boolean empty() {
        return list.isEmpty();
    }
    public int size() {
        return list.size();
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
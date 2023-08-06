package ast;

import java.util.ArrayList;

import ast.stmt.StmtNode;
import utils.*;

public class VarDefNode extends StmtNode {
    public Type type;
    public ArrayList<VarDefUnitNode> defs = new ArrayList<VarDefUnitNode>();

    public VarDefNode(Type type, Position pos) {
        super(pos);
        this.type = type;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        System.out.printf("define var: ");
        for (var unit : this.defs) {
            unit.debug();
        }
        System.out.println("");
    }
}

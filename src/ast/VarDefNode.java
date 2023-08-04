package ast;

import java.util.ArrayList;

import ast.stmt.StmtNode;
import utils.Position;

public class VarDefNode extends StmtNode {
    public ArrayList<VarDefUnitNode> defs = new ArrayList<VarDefUnitNode>();

    public VarDefNode(Position pos) {
        super(pos);
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

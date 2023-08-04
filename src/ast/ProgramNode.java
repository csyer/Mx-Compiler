package ast;

import utils.*;

import java.util.ArrayList;

public class ProgramNode extends ASTNode {
    public ArrayList<ASTNode> defs = new ArrayList<ASTNode>();

    public ProgramNode(Position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        System.out.printf("Program begin:\n");
        for (var def : this.defs) {
            if (def != null) {
                def.debug();
            }
        }
        System.out.println("End");
    }
}
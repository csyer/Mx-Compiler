package ast;

import java.util.ArrayList;

import utils.Position;

public class ClassDefNode extends ASTNode {
    public String className;
    public ArrayList<ASTNode> defs = new ArrayList<ASTNode>();

    public ClassDefNode(String className, Position pos) {
        super(pos);
        this.className = className;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        System.out.printf("Class Define %s { %n", this.className);
        for (var def : this.defs) {
            def.debug();
        }
        System.out.println("}");
    }
}

package ast;

import utils.*;

abstract public class ASTNode {
    public Position pos;
    public ASTNode(Position pos) {
        this.pos = pos;
    }

    abstract public void accept(ASTVisitor visitor);

    public void debug() {
        System.out.printf("None");
    }
}

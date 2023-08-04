package ast.stmt;

import utils.*;

import ast.*;

public class ContinueStmtNode extends StmtNode {
    public ContinueStmtNode(Position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        System.out.println("Continue");
    }
}
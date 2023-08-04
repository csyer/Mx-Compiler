package ast.stmt;

import utils.*;

import ast.*;
import java.util.ArrayList;

public class SuiteNode extends StmtNode {
    public ArrayList<StmtNode> stmts = new ArrayList<StmtNode>();

    public SuiteNode(Position pos) {
        super(pos);
    }

    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        for (var stmt : this.stmts) {
            stmt.debug();
        }
    }
}
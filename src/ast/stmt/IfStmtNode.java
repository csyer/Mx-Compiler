package ast.stmt;

import utils.*;

import ast.expr.*;
import ast.*;

public class IfStmtNode extends StmtNode {
    public ExprNode condition;
    public StmtNode trueStmt, falseStmt;

    public IfStmtNode(ExprNode condition, StmtNode trueStmt, StmtNode falseStmt, Position pos) {
        super(pos);
        this.condition = condition;
        this.trueStmt = trueStmt;
        this.falseStmt = falseStmt;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        System.out.print("If ");
        this.condition.debug();
        System.out.println(" : {");
        this.trueStmt.debug();
        if (this.falseStmt != null) {
            System.out.println("} else {");
            this.falseStmt.debug();
        }
        System.out.println("}");
    }
}
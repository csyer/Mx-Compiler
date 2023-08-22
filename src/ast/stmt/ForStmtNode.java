package ast.stmt;

import utils.*;
import IR.IRBasicBlock;
import ast.*;
import ast.expr.*;

public class ForStmtNode extends WhileStmtNode {
    public StmtNode initial;
    public ExprNode step;

    public IRBasicBlock stepBlock;

    public ForStmtNode(StmtNode initial, ExprNode condition, ExprNode step, StmtNode statement, Position pos) {
        super(condition, statement, pos);
        this.initial = initial;
        this.step = step;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        // System.out.print("For (");
        if (this.initial != null)
            this.initial.debug();
        System.out.println("");
        ((WhileStmtNode) this).debug();
        // System.out.print(" ; ");
        // if (this.condition != null)
        //     this.condition.debug();
        // System.out.print(" ; ");
        // if (this.step != null)
        //     this.step.debug();
        // System.out.println(") {");
        // this.statement.debug();
        // System.out.println("}");
    }
}
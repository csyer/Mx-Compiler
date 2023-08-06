package ast.stmt;

import utils.*;

import ast.*;
import ast.expr.*;

public class ForStmtNode extends StmtNode {
    public ExprNode condition, step;
    public StmtNode initial, statement;

    public ForStmtNode(StmtNode initial, ExprNode condition, ExprNode step, StmtNode statement, Position pos) {
        super(pos);
        this.initial = initial;
        this.condition = condition;
        this.step = step;
        this.statement = statement;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        System.out.print("For (");
        if (this.initial != null)
            this.initial.debug();
        System.out.print(" ; ");
        if (this.condition != null)
            this.condition.debug();
        System.out.print(" ; ");
        if (this.step != null)
            this.step.debug();
        System.out.println(") {");
        this.statement.debug();
        System.out.println("}");
    }
}
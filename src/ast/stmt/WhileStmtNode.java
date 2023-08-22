package ast.stmt;

import utils.*;
import IR.IRBasicBlock;
import ast.*;
import ast.expr.*;

public class WhileStmtNode extends StmtNode {
    public ExprNode condition;
    public StmtNode statement;

    public IRBasicBlock loopBlock, nextBlock, condBlock;

    public WhileStmtNode(ExprNode condition, StmtNode statement, Position pos) {
        super(pos);
        this.condition = condition;
        this.statement = statement;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        System.out.print("While ");
        this.condition.debug();
        System.out.println(" {");
        this.statement.debug();
        System.out.println("}");
    }
}
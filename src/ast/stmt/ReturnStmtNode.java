package ast.stmt;

import utils.*;

import ast.*;
import ast.expr.*;

public class ReturnStmtNode extends StmtNode {
    public ExprNode returnValue;

    public ReturnStmtNode(ExprNode returnValue, Position pos) {
        super(pos);
        this.returnValue = returnValue;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        System.out.print("Return ");
        if (this.returnValue != null) {
            this.returnValue.debug();
        } else {
            System.out.print("Void");
        }
        System.out.println("");
    }
}
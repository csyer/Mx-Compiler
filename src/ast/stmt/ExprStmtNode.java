package ast.stmt;

import ast.ASTVisitor;
import ast.expr.ExprNode;
import utils.Position;

public class ExprStmtNode extends StmtNode {
    public ExprNode expr;

    public ExprStmtNode(Position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        if (this.expr != null) 
            this.expr.debug();
    }
}

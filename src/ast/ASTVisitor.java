package ast;

import ast.expr.*;
import ast.stmt.*;

public interface ASTVisitor {
    public void visit(ProgramNode node);

    public void visit(VarDefUnitNode node);
    public void visit(VarDefNode node);

    public void visit(ParameterNode node);
    public void visit(FuncDefNode node);

    public void visit(ClassConstructorNode node);
    public void visit(ClassDefNode node);

    public void visit(SuiteNode node);
    public void visit(IfStmtNode node);
    public void visit(WhileStmtNode node);
    public void visit(ForStmtNode node); 
    public void visit(BreakStmtNode node);
    public void visit(ContinueStmtNode node);
    public void visit(ReturnStmtNode node);
    public void visit(ExprStmtNode node);

    public void visit(ExprListNode node);
    public void visit(NewExprNode node);
    public void visit(ComponentExprNode node);
    public void visit(FunctionExprNode node);
    public void visit(AccessArrayExprNode node);
    public void visit(IncExprNode node);
    public void visit(UnaryExprNode node);
    public void visit(BinaryExprNode node);
    public void visit(TernaryExprNode node);
    public void visit(AssignExprNode node);
    public void visit(LiteralExprNode node);
    public void visit(AtomExprNode node);
}
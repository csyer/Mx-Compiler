package backend;

import java.util.HashMap;

import IR.IRFunction;
import IR.IRProgram;
import IR.entity.IRGlobalVar;
import IR.type.IRClassType;
import ast.*;
import ast.expr.*;
import ast.stmt.*;
import semantic.Scope;
import semantic.globalScope;

public class IRBuilder implements ASTVisitor {
    IRFunction currentFunc = null;
    IRClassType currentClass = null;

    globalScope gScope;
    Scope currentScope;
    IRProgram root;

    HashMap<String, IRClassType> classTypes = new HashMap<>();

    public IRBuilder(IRProgram root, globalScope gScope) {
        this.root = root;
        this.currentScope = this.gScope = gScope;
    }

    @Override
    public void visit(ProgramNode node) {
        for (var def : node.defs) 
            if (def instanceof ClassDefNode) {
                ClassDefNode classDef = (ClassDefNode) def;
                classTypes.put(classDef.className, new IRClassType(classDef.className));
            }
        for (var def : node.defs) 
            if (def instanceof ClassDefNode) 
                def.accept(this);
        for (var def : node.defs) 
            if (def instanceof VarDefNode) 
                def.accept(this);
        for (var def : node.defs) 
            if (def instanceof FuncDefNode) 
                def.accept(this);
    }

    @Override
    public void visit(VarDefUnitNode node) {
        if (currentFunc != null) {
            
        } else {
            IRGlobalVar gVar = new IRGlobalVar(node.type.irType, node.varName);
        }
    }

    @Override
    public void visit(VarDefNode node) {
        for (var unit : node.defs) 
            unit.accept(this);
    }

    @Override
    public void visit(ParameterNode node) {
    }

    @Override
    public void visit(FuncDefNode node) {
    }

    @Override
    public void visit(ClassConstructorNode node) {
    }

    @Override
    public void visit(ClassDefNode node) {
    }

    @Override
    public void visit(SuiteNode node) {
    }

    @Override
    public void visit(IfStmtNode node) {
    }

    @Override
    public void visit(WhileStmtNode node) {
    }

    @Override
    public void visit(ForStmtNode node) {
    }

    @Override
    public void visit(BreakStmtNode node) {
    }

    @Override
    public void visit(ContinueStmtNode node) {
    }

    @Override
    public void visit(ReturnStmtNode node) {
    }

    @Override
    public void visit(ExprStmtNode node) {
    }

    @Override
    public void visit(ExprListNode node) {
    }

    @Override
    public void visit(NewExprNode node) {
    }

    @Override
    public void visit(ComponentExprNode node) {
    }

    @Override
    public void visit(FunctionExprNode node) {
    }

    @Override
    public void visit(AccessArrayExprNode node) {
    }

    @Override
    public void visit(IncExprNode node) {
    }

    @Override
    public void visit(UnaryExprNode node) {
    }

    @Override
    public void visit(BinaryExprNode node) {
    }

    @Override
    public void visit(TernaryExprNode node) {
    }

    @Override
    public void visit(AssignExprNode node) {
    }

    @Override
    public void visit(LiteralExprNode node) {
    }

    @Override
    public void visit(AtomExprNode node) {
    }
}

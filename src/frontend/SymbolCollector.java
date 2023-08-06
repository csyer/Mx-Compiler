package frontend;

import ast.*;
import ast.expr.*;
import ast.stmt.*;
import semantic.*;
import utils.Error;

public class SymbolCollector implements ASTVisitor {
    private globalScope gScope;

    public SymbolCollector(globalScope gScope) {
        this.gScope = gScope;
    }

    @Override
    public void visit(ProgramNode node) {
        for (var def : node.defs) {
            def.accept(this);
        }
    }

    @Override
    public void visit(VarDefUnitNode node) {
    }

    @Override
    public void visit(VarDefNode node) {
    }

    @Override
    public void visit(ParameterNode node) {
    }

    @Override
    public void visit(FuncDefNode node) {
        FuncDefNode funcDef = gScope.getFunc(node.funcName);
        if (funcDef != null)
            throw new Error(node.funcName + " is defined.", funcDef.pos);
        ClassDefNode classDef = gScope.getClass(node.funcName);
        if (classDef != null) 
            throw new Error(node.funcName + " is defined.", classDef.pos);
        gScope.putFunc(node.funcName, node);
    }

    @Override
    public void visit(ClassConstructorNode node) {
    }

    @Override
    public void visit(ClassDefNode node) {
        FuncDefNode funcDef = gScope.getFunc(node.className);
        if (funcDef != null)
            throw new Error(node.className + " is defined.", funcDef.pos);
        ClassDefNode classDef = gScope.getClass(node.className);
        if (classDef != null) 
            throw new Error(node.className + " is defined.", classDef.pos);
        gScope.putClass(node.className, node);

        for (var def : node.funcDefs) {
            if(node.memberFunc.get(def.funcName) != null) {
                throw new Error(def.funcName + " is defined.", def.pos);
            }
            def.className = node.className;
            node.memberFunc.put(def.funcName, def);
        }

        for (var def : node.varDefs) {
            for (var unit : def.defs) {
                if (node.memberVars.get(unit.varName) != null) {
                    throw new Error(unit.varName + " is defined", unit.pos);
                }
                node.memberVars.put(unit.varName, unit);
            }
        }
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

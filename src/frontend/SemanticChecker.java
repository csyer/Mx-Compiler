package frontend;

import ast.*;
import ast.expr.*;
import ast.stmt.*;
import utils.*;
import utils.Error;

public class SemanticChecker implements ASTVisitor, BuiltinElements {
    private Scope currentScope;
    private globalScope gScope;

    public SemanticChecker(globalScope gScope) {
        currentScope = this.gScope = gScope;
    }

    @Override
    public void visit(ProgramNode node) {
        FuncDefNode mainFunc = gScope.getFunc("main");
        if (mainFunc == null) {
            throw new Error("Cannot find 'main()'.", node.pos);
        }
        if (!mainFunc.returnType.typeName.equals("int")) {
            throw new Error("'main()' function should return 'int'.", node.pos);
        }
        if (!mainFunc.param.empty()) {
            throw new Error("'main()' function cannot has any parameters.", node.pos);
        }
        for (var def : node.defs) {
            def.accept(this);
        }
    }

    @Override
    public void visit(VarDefUnitNode node) {
        if (node.initial != null) {
            node.initial.accept(this);
            if (!node.type.equals(node.initial.type)) {
                throw new Error("Unmatched type.", node.pos);
            }
            // if (!node.type.isReference()) {
            //     throw new Error(node.type.typeName + " is not reference.", node.pos);
            // }
        }
        currentScope.addVar(node.varName, node.type, node.pos);
    }

    @Override
    public void visit(VarDefNode node) {
        String typename = node.type.typeName;
        if (gScope.getClass(typename) == null) {
            throw new Error("Undefined type " + typename, node.pos);
        }
        for (var unit : node.defs) {
            unit.accept(this);
        }
    }

    @Override
    public void visit(ParameterNode node) {
        for (var unit : node.list) {
            unit.accept(this);
        }
    }

    @Override
    public void visit(FuncDefNode node) {
        String typename = node.returnType.typeName;
        if (!typename.equals("void") && gScope.getClass(typename) == null) {
            throw new Error("Undefined type " + typename, node.pos);
        }
        if (currentScope.varDefs.get(node.funcName) != null) {
            throw new Error("Function name is defined", node.pos);
        }
        if (node.className != null) {
            if (node.funcName.equals(node.className)) {
                throw new Error("Function name cannot be the same as constructor", node.pos);
            }
        }

        currentScope = new Scope(currentScope);
        currentScope.returnType = node.returnType;
        node.param.accept(this);
        if (node.suite != null) {
            node.suite.accept(this);
        }
        if (!currentScope.isReturn) {
            if (!node.funcName.equals("main") && !voidType.equals(currentScope.returnType)) {
                throw new Error("Function should return a value.", node.pos);
            }
        }
        currentScope = currentScope.parentScope;
    }

    @Override
    public void visit(ClassConstructorNode node) {
        currentScope = new Scope(currentScope);
        currentScope.returnType = voidType;
        node.suite.accept(this);
        currentScope = currentScope.parentScope;
    }

    @Override
    public void visit(ClassDefNode node) {
        currentScope = new Scope(currentScope);
        currentScope.inClass = node;
        for (var def : node.varDefs) {
            def.accept(this);
        }
        for (var def : node.funcDefs) {
            def.accept(this);
        }
        if (node.constructor != null) {
            if (node.constructor.className.equals(node.className)) {
                node.constructor.accept(this);
            } else {
                throw new Error("Unmatched constructor.", node.constructor.pos);
            }
        }
        currentScope = currentScope.parentScope;
    }

    @Override
    public void visit(SuiteNode node) {
        currentScope = new Scope(currentScope);
        for (var stmt : node.stmts) {
            stmt.accept(this);
        }
        currentScope = currentScope.parentScope;
    }

    @Override
    public void visit(IfStmtNode node) {
        node.condition.accept(this);
        if (!node.condition.type.equals(boolType)) {
            throw new Error("The return type should be 'bool'.", node.condition.pos);
        }

        currentScope = new Scope(currentScope);
        node.trueStmt.accept(this);
        currentScope = currentScope.parentScope;

        if (node.falseStmt != null) {
            currentScope = new Scope(currentScope);
            node.falseStmt.accept(this);
            currentScope = currentScope.parentScope;
        }
    }

    @Override
    public void visit(WhileStmtNode node) {
        node.condition.accept(this);
        if (!node.condition.type.equals(boolType)) {
            throw new Error("The return type should be 'bool'.", node.condition.pos);
        }

        currentScope = new Scope(currentScope);
        currentScope.inLoop = node;
        node.statement.accept(this);
        currentScope = currentScope.parentScope;
    }

    @Override
    public void visit(ForStmtNode node) {
        if (node.initial != null) {
            currentScope = new Scope(currentScope);
            node.initial.accept(this);
            currentScope = currentScope.parentScope;
        }

        node.condition.accept(this);
        if (!node.condition.type.equals(boolType)) {
            throw new Error("The return type should be 'bool'.", node.condition.pos);
        }

        if (node.step != null) {
            currentScope = new Scope(currentScope);
            node.step.accept(this);
            currentScope = currentScope.parentScope;
        }

        currentScope = new Scope(currentScope);
        currentScope.inLoop = node;
        node.statement.accept(this);
        currentScope = currentScope.parentScope;
    }

    @Override
    public void visit(BreakStmtNode node) {
        if (currentScope.inLoop == null) {
            throw new Error("'break' should be in loop.", node.pos);
        }
    }

    @Override
    public void visit(ContinueStmtNode node) {
        if (currentScope.inLoop == null) {
            throw new Error("'continue' should be in loop.", node.pos);
        }
    }

    @Override
    public void visit(ReturnStmtNode node) {
        Type returnType = voidType;
        if (node.returnValue != null) {
            node.returnValue.accept(this);
            returnType = node.returnValue.type;
        }
        for (Scope scp = currentScope; scp != null; scp = scp.parentScope) {
            if (scp.returnType != null) {
                if (!scp.returnType.equals(returnType)) {
                    throw new Error("Unmatched return type " + scp.returnType.typeName, node.pos);
                }
                scp.isReturn = true;
                currentScope.returnType = returnType;
                return;
            }
        }
        throw new Error("'return' should be in function", node.pos);
    }

    @Override
    public void visit(ExprStmtNode node) {
        if (node.expr != null) {
            node.expr.accept(this);
        }
    }

    @Override
    public void visit(ExprListNode node) {
        for (var expr : node.exprs) {
            expr.accept(this);
        }
    }

    @Override
    public void visit(NewExprNode node) {
        for (var expr : node.exprs) {
            expr.accept(this);
            if (!expr.type.equals(intType)) {
                throw new Error("The index of array should be 'int' type.", expr.pos);
            }
        }
    }

    @Override
    public void visit(ComponentExprNode node) {
        node.object.accept(this);
        ClassDefNode classDef = null;
        if (node.object.type.isClass) {
            classDef = gScope.getClass(node.object.type.typeName);
            if (classDef == null) {
                throw new Error(node.object.type.typeName + " is not defined.", node.pos);
            }
        } else {
            throw new Error("The object has no member.", node.pos);
        }

        FuncDefNode funcDef = classDef.memberFunc.get(node.member);
        VarDefUnitNode varDef = classDef.memberVars.get(node.member);
        if (funcDef == null && varDef == null) {
            if (node.object.type.isArray() && node.member.equals("size")) {
                node.funcDef = ArraySizeFunc;
                node.type = node.funcDef.returnType;
            } else {
                throw new Error(classDef.className + " do not have member " + node.member, node.pos);
            }
        } else {
            if (funcDef != null) {
                node.funcDef = funcDef;
                node.type = funcDef.returnType;
            } else {
                node.type = varDef.type;
            }
        }
    }

    @Override
    public void visit(FunctionExprNode node) {
        node.args.accept(this);

        node.func.accept(this);
        if (node.func.funcDef == null) {
            throw new Error("The expression is not function.", node.pos);
        }
        boolean checkFunc = true;
        if (node.func.funcDef.param.size() != node.args.size()) {
            checkFunc = false;
        }
        for (int i = 0; i < node.args.size() && checkFunc; i++) {
            VarDefUnitNode param = node.func.funcDef.param.list.get(i);
            ExprNode expr = node.args.exprs.get(i);
            if (!param.type.equals(expr.type)) {
                if (!param.type.isReference()) {
                    checkFunc = false;
                    break;
                }
            }
        }
        if (checkFunc) {
            node.type = node.func.funcDef.returnType;
            return;
        }
        node.func.funcDef = node.func.gfuncDef;
        if (node.func.funcDef == null) {
            throw new Error("No such function", node.pos);
        }
        if (node.func.funcDef.param.size() != node.args.size()) {
            throw new Error("No such function", node.pos);
        }
        for (int i = 0; i < node.args.size(); i++) {
            VarDefUnitNode param = node.func.funcDef.param.list.get(i);
            ExprNode expr = node.args.exprs.get(i);
            if (!param.type.equals(expr.type)) {
                if (!param.type.isReference()) {
                    throw new Error("No such function", node.pos);
                }
            }
        }
    }

    @Override
    public void visit(AccessArrayExprNode node) {
        node.array.accept(this);
        node.index.accept(this);

        if (!node.index.type.equals(intType)) {
            throw new Error("The index of array should be 'int' type.", node.index.pos);
        }
        if (!node.array.type.isArray()) {
            throw new Error("The expression is not an array.", node.array.pos);
        }
        node.type = new Type(node.array.type.typeName, node.array.type.dim - 1);
    }

    @Override
    public void visit(IncExprNode node) {
        node.expr.accept(this);
        if (!node.expr.type.equals(intType)) {
            throw new Error("The type should be 'int'.", node.pos);
        }
        if (!node.expr.isAssignable()) {
            throw new Error("The expression is not a valid left value.", node.pos);
        }
        node.type = intType;
        node.type.isAssignable = false;
    }

    @Override
    public void visit(UnaryExprNode node) {
        node.expr.accept(this);
        if (node.op.equals("!")) {
            if (!node.expr.type.equals(boolType)) {
                throw new Error("The type should be 'bool'.", node.pos);
            }
            node.type = boolType;
        } else {
            if (!node.expr.type.equals(intType)) {
                throw new Error("The type should be 'int'.", node.pos);
            }
            if (node.op.equals("++") || node.op.equals("--")) {
                if (!node.expr.type.isAssignable) {
                    throw new Error("Cannot modify a right value", node.pos);
                }
            }
            node.type = intType;
        }
    }

    @Override
    public void visit(BinaryExprNode node) {
        node.lhs.accept(this);
        node.rhs.accept(this);

        String op = node.op;
        if (op.equals("==") || op.equals("!=")) {
            if (!node.lhs.type.equals(node.rhs.type)) {
                throw new Error("Unmatched type.", node.pos);
            }
            node.type = boolType;
        } else if (op.equals("&&") || op.equals("||")) {
            if (!node.lhs.type.equals(boolType) || !node.rhs.type.equals(boolType)) {
                throw new Error("The type of expression should be 'bool'.", node.pos);
            }
            node.type = boolType;
        } else if (op.equals("+")) {
            if (!node.lhs.type.equals(node.rhs.type)) {
                throw new Error("Unmatched type.", node.pos);
            }
            if (!node.lhs.type.equals(intType) && !node.lhs.type.equals(stringType)) {
                throw new Error("The type of expression should be 'int' or 'string'.", node.pos);
            }
            node.type = node.lhs.type;
        } else if (op.equals("<") || op.equals(">") || op.equals("<=") || op.equals(">=")) {
            if (!node.lhs.type.equals(node.rhs.type)) {
                throw new Error("Unmatched type.", node.pos);
            }
            if (!node.lhs.type.equals(intType) && !node.lhs.type.equals(stringType)) {
                throw new Error("The type of expression should be 'int' or 'string'.", node.pos);
            }
            node.type = boolType;
        } else {
            if (!node.lhs.type.equals(intType) || !node.rhs.type.equals(intType)) {
                throw new Error("The type here should be 'int' type.", node.pos);
            }
            node.type = intType;
        }
    }

    @Override
    public void visit(TernaryExprNode node) {
        node.condition.accept(this);
        if (!node.condition.type.equals(boolType)) {
            throw new Error("Condition should be 'bool' type.", node.pos);
        }
        node.trueExpr.accept(this);
        node.falseExpr.accept(this);
        if (!node.trueExpr.type.equals(node.falseExpr.type)) {
            throw new Error("Return types should be the same.", node.pos);
        }
        if (node.trueExpr.type.equals(nullType)) {
            node.type = node.falseExpr.type;
        } else {
            node.type = node.trueExpr.type;
        }
    }

    @Override
    public void visit(AssignExprNode node) {
        node.lhs.accept(this);
        node.rhs.accept(this);

        if (!node.lhs.isAssignable()) {
            throw new Error("LHS is not assignable.", node.lhs.pos);
        }
        if (!node.lhs.type.equals(node.rhs.type)) {
            throw new Error("Unmatched type.", node.pos);
        }
        // if (!node.lhs.type.isReference()) {
        //     throw new Error(node.lhs.type.typeName + " is not reference.", node.pos);
        // }
        node.type = node.lhs.type;
    }

    @Override
    public void visit(LiteralExprNode node) {
        if (node.str.equals("null")) {
            node.type = nullType;
        } else if (node.str.equals("true") || node.str.equals("false")) {
            node.type = boolType;
        } else if (node.str.matches("\".*\"")) {
            node.type = stringType;
        } else {
            node.type = intType;
        }
    }

    @Override
    public void visit(AtomExprNode node) {
        if (node.varName.equals("this")) {
            ClassDefNode classDef = currentScope.inClass;
            if (classDef == null) {
                throw new Error("'this' should be used in class.", node.pos);
            }
            node.type = new Type(classDef.className);
            node.type.isAssignable = false;
        } else {
            ClassDefNode classDef = currentScope.inClass;
            if (classDef != null) {
                FuncDefNode memFunc = classDef.memberFunc.get(node.varName);
                if (memFunc != null) {
                    node.funcDef = memFunc;
                }
            }
            for (Scope scp = currentScope; scp != null; scp = scp.parentScope) {
                Type varType = scp.varDefs.get(node.varName);
                if (varType != null) {
                    node.type = varType;
                    return;
                }
            }
            FuncDefNode gfuncDef = gScope.getFunc(node.varName);
            if (node.funcDef == null) {
                if (gfuncDef == null) {
                    throw new Error("Undefined " + node.varName, node.pos);
                }
                node.funcDef = gfuncDef;
                return;
            } else {
                node.gfuncDef = gfuncDef;
            }
            node.type = node.funcDef.returnType;
        }
    }
}

package frontend;

import ast.*;
import ast.expr.*;
import ast.stmt.*;
import parser.*;
import parser.MxParser.*;
import utils.*;
import utils.Error;

public class ASTBuilder extends MxParserBaseVisitor<ASTNode> {
    @Override
    public ASTNode visitProgram(MxParser.ProgramContext ctx) {
        ProgramNode prog = new ProgramNode(new Position(ctx));
        for (var def : ctx.children) {
            if (def instanceof FuncDefContext) {
                prog.defs.add((FuncDefNode) visit(def));
            } else if (def instanceof ClassDefContext) {
                prog.defs.add((ClassDefNode) visit(def));
            } else if (def instanceof VarDefContext) {
                prog.defs.add((VarDefNode) visit(def));
            }
        }
        return prog;
    }

    // Var Define

    @Override
    public ASTNode visitVarDefUnit(MxParser.VarDefUnitContext ctx) {
        VarDefUnitNode unit = new VarDefUnitNode(ctx.Identifier().getText(), new Position(ctx));
        if (ctx.expr() != null) {
            unit.initial = (ExprNode) visit(ctx.expr());
        }
        return unit;
    }

    @Override
    public ASTNode visitVarDef(MxParser.VarDefContext ctx) {
        VarDefNode def = new VarDefNode(new Type(ctx.type()), new Position(ctx));
        for (var unit : ctx.varDefUnit()) {
            VarDefUnitNode varUnit = (VarDefUnitNode) visit(unit);
            varUnit.type = def.type;
            def.defs.add(varUnit);
        }
        return def;
    }

    // Class Define

    @Override
    public ASTNode visitClassConstructor(MxParser.ClassConstructorContext ctx) {
        ClassConstructorNode con = new ClassConstructorNode(ctx.Identifier().getText(),
                (SuiteNode) visit(ctx.suite()), new Position(ctx));
        return con;
    }

    @Override
    public ASTNode visitClassDef(MxParser.ClassDefContext ctx) {
        ClassDefNode defs = new ClassDefNode(ctx.Identifier().getText(), new Position(ctx));
        for (var def : ctx.children) {
            if (def instanceof VarDefContext) {
                defs.varDefs.add((VarDefNode) visit(def));
            } else if (def instanceof ClassConstructorContext) {
                if(defs.constructor == null) {
                    defs.constructor = (ClassConstructorNode) visit(def);
                }
                else {
                    throw new Error("Constructor is redefined", defs.pos);
                }
            } else if (def instanceof FuncDefContext) {
                defs.funcDefs.add((FuncDefNode) visit(def));
            }
        }
        return defs;
    }

    // Function Define

    @Override
    public ASTNode visitParameter(MxParser.ParameterContext ctx) {
        ParameterNode param = new ParameterNode(new Position(ctx));
        for (int i = 0; i < ctx.type().size(); i++) {
            Type type = new Type(ctx.type(i));
            String varName = ctx.Identifier(i).getText();
            param.list.add(new VarDefUnitNode(type, varName, new Position(ctx.Identifier(i))));
        }
        return param;
    }

    @Override
    public ASTNode visitFuncDef(MxParser.FuncDefContext ctx) {
        Type returnType;
        if ( ctx.returnType().Void() != null) {
            returnType = new Type("void");
        } else {
            returnType = new Type(ctx.returnType().type().typename().getText());
            returnType.dim = ctx.returnType().type().LBracket().size();
        }

        String funcName = ctx.funcName.getText();
        ParameterNode param = new ParameterNode(new Position(ctx));
        if (ctx.parameter() != null) {
            param = (ParameterNode) visit(ctx.parameter());
        }
        SuiteNode suite = (SuiteNode) visit(ctx.suite());
        FuncDefNode func = new FuncDefNode(returnType, funcName, param, suite, new Position(ctx));
        return func;
    }

    // Statement

    @Override
    public ASTNode visitStatement(MxParser.StatementContext ctx) {
        if (ctx.suite() != null) {
            return (SuiteNode) visit(ctx.suite());
        } else if (ctx.varDef() != null) {
            return (VarDefNode) visit(ctx.varDef());
        } else if (ctx.ifStmt() != null) {
            return (IfStmtNode) visit(ctx.ifStmt());
        } else if (ctx.whileStmt() != null) {
            return (WhileStmtNode) visit(ctx.whileStmt());
        } else if (ctx.forStmt() != null) {
            return (ForStmtNode) visit(ctx.forStmt());
        } else if (ctx.breakStmt() != null) {
            return (BreakStmtNode) visit(ctx.breakStmt());
        } else if (ctx.continueStmt() != null) {
            return (ContinueStmtNode) visit(ctx.continueStmt());
        } else if (ctx.returnStmt() != null) {
            return (ReturnStmtNode) visit(ctx.returnStmt());
        } else if (ctx.exprStmt() != null) {
            return (ExprStmtNode) visit(ctx.exprStmt());
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public ASTNode visitSuite(MxParser.SuiteContext ctx) {
        SuiteNode suite = new SuiteNode(new Position(ctx));
        if (ctx.children != null) {
            for (var stmt : ctx.children) {
                suite.stmts.add((StmtNode) visit(stmt));
            }
        }
        return suite;
    }

    @Override
    public ASTNode visitIfStmt(MxParser.IfStmtContext ctx) {
        StmtNode trueStmt = null, falseStmt = null;
        trueStmt = (StmtNode) visit(ctx.trueStmt);
        if (ctx.falseStmt != null) {
            falseStmt = (StmtNode) visit(ctx.falseStmt);
        }
        IfStmtNode stmt = new IfStmtNode((ExprNode) visit(ctx.condition), trueStmt,
                falseStmt, new Position(ctx));
        return stmt;
    }

    @Override
    public ASTNode visitWhileStmt(MxParser.WhileStmtContext ctx) {
        ExprNode condition = (ExprNode) visit(ctx.condition);
        StmtNode statement = (StmtNode) visit(ctx.statement());
        WhileStmtNode stmt = new WhileStmtNode(condition, statement, new Position(ctx));
        return stmt;
    }

    @Override
    public ASTNode visitForStmt(MxParser.ForStmtContext ctx) {
        StmtNode initial = null;
        if (ctx.initial != null) {
            initial = (StmtNode) visit(ctx.initial);
        }
        ExprStmtNode condition = (ExprStmtNode) visit(ctx.condition);
        ExprNode step = null;
        if (ctx.step != null) {
            step = (ExprNode) visit(ctx.step);
        }
        StmtNode suite = (StmtNode) visit(ctx.block);
        ForStmtNode stmt = new ForStmtNode(initial, condition.expr, step, suite, new Position(ctx));
        return stmt;
    }

    @Override
    public ASTNode visitBreakStmt(MxParser.BreakStmtContext ctx) {
        BreakStmtNode stmt = new BreakStmtNode(new Position(ctx));
        return stmt;
    }

    @Override
    public ASTNode visitContinueStmt(MxParser.ContinueStmtContext ctx) {
        ContinueStmtNode stmt = new ContinueStmtNode(new Position(ctx));
        return stmt;
    }

    @Override
    public ASTNode visitReturnStmt(MxParser.ReturnStmtContext ctx) {
        ExprNode returnValue = null;
        if (ctx.returnValue != null) {
            returnValue = (ExprNode) visit(ctx.returnValue);
        }
        ReturnStmtNode stmt = new ReturnStmtNode(returnValue, new Position(ctx));
        return stmt;
    }

    @Override
    public ASTNode visitExprStmt(MxParser.ExprStmtContext ctx) {
        ExprStmtNode stmt = new ExprStmtNode(new Position(ctx));
        if (ctx.expr() != null) {
            stmt.expr = (ExprNode) visit(ctx.expr());
        }
        return stmt;
    }

    // Expression

    @Override
    public ASTNode visitExprList(MxParser.ExprListContext ctx) {
        ExprListNode list = new ExprListNode(new Position(ctx));
        for (var expr : ctx.expr()) {
            list.exprs.add((ExprNode) visit(expr));
        }
        return list;
    }

    @Override
    public ASTNode visitNestedExpr(MxParser.NestedExprContext ctx) {
        return (ExprNode) visit(ctx.expr());
    }

    @Override
    public ASTNode visitNewExpr(MxParser.NewExprContext ctx) {
        NewExprNode expr = new NewExprNode(ctx.arrayDef().size(), new Position(ctx));
        boolean isValid = true;
        for (var def : ctx.arrayDef()) {
            if (!isValid && (def.expr() != null)) {
                throw new Error("Need to create array from outer to inner layers", new Position(ctx));
            }
            if (def.expr() == null) {
                isValid = false;
            } else {
                expr.exprs.add((ExprNode) visit(def.expr()));
            }
        }
        expr.type = new Type(ctx.type());
        expr.type.dim = expr.dim;
        // if (expr.exprs.size() == 0) {
        //     throw new Error("Cannot create a empty array.", new Position(ctx));
        // }
        return expr;
    }

    @Override
    public ASTNode visitComponentExpr(MxParser.ComponentExprContext ctx) {
        ExprNode object = (ExprNode) visit(ctx.expr());
        String member = ctx.Identifier().getText();
        ComponentExprNode expr = new ComponentExprNode(object, member, new Position(ctx));
        return expr;
    }

    @Override
    public ASTNode visitFunctionExpr(MxParser.FunctionExprContext ctx) {
        FunctionExprNode expr = new FunctionExprNode((ExprNode) visit(ctx.expr()), new Position(ctx));
        if (ctx.exprList() != null) {
            expr.args = (ExprListNode) visit(ctx.exprList());
        }
        return expr;
    }

    @Override
    public ASTNode visitAccessArrayExpr(MxParser.AccessArrayExprContext ctx) {
        ExprNode array = (ExprNode) visit(ctx.array);
        ExprNode index = (ExprNode) visit(ctx.index);
        AccessArrayExprNode expr = new AccessArrayExprNode(array, index, new Position(ctx));
        return expr;
    }

    @Override
    public ASTNode visitIncExpr(MxParser.IncExprContext ctx) {
        String op = ctx.op.getText();
        ExprNode expr = (ExprNode) visit(ctx.expr());
        IncExprNode node = new IncExprNode(op, expr, new Position(ctx));
        return node;
    }

    @Override
    public ASTNode visitUnaryExpr(MxParser.UnaryExprContext ctx) {
        String op = ctx.op.getText();
        ExprNode expr = (ExprNode) visit(ctx.expr());
        UnaryExprNode node = new UnaryExprNode(op, expr, new Position(ctx));
        return node;
    }

    @Override
    public ASTNode visitBinaryExpr(MxParser.BinaryExprContext ctx) {
        ExprNode lhs = (ExprNode) visit(ctx.lhs);
        ExprNode rhs = (ExprNode) visit(ctx.rhs);
        String op = ctx.op.getText();
        BinaryExprNode expr = new BinaryExprNode(lhs, op, rhs, new Position(ctx));
        return expr;
    }

    @Override
    public ASTNode visitTernaryExpr(MxParser.TernaryExprContext ctx) {
        ExprNode condition = (ExprNode) visit(ctx.condition);
        ExprNode trueExpr = (ExprNode) visit(ctx.trueExpr);
        ExprNode falseExpr = (ExprNode) visit(ctx.falseExpr);
        TernaryExprNode expr = new TernaryExprNode(condition, trueExpr, falseExpr, new Position(ctx));
        return expr;
    }

    @Override
    public ASTNode visitAssignExpr(MxParser.AssignExprContext ctx) {
        ExprNode lhs = (ExprNode) visit(ctx.lhs);
        ExprNode rhs = (ExprNode) visit(ctx.rhs);
        AssignExprNode expr = new AssignExprNode(lhs, rhs, new Position(ctx));
        return expr;
    }

    @Override
    public ASTNode visitLiteralExpr(MxParser.LiteralExprContext ctx) {
        LiteralExprNode liter = new LiteralExprNode(ctx.getText(), new Position(ctx));
        return liter;
    }

    @Override
    public ASTNode visitAtomExpr(MxParser.AtomExprContext ctx) {
        AtomExprNode expr = new AtomExprNode(new Position(ctx));
        if (ctx.Identifier() != null) {
            expr.varName = ctx.Identifier().getText();
        } else {
            expr.varName = "this";
        }
        return expr;
    }
}
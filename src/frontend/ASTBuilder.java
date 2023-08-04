package frontend;

import ast.ASTNode;
import ast.ClassConstructorNode;
import ast.ClassDefNode;
import ast.FuncDefNode;
import ast.ParameterNode;
import ast.ProgramNode;
import ast.VarDefNode;
import ast.VarDefUnitNode;
import ast.expr.*;
import ast.stmt.*;
import parser.*;
import parser.MxParser.*;
import utils.Position;
import utils.Error;;

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
        VarDefNode def = new VarDefNode(new Position(ctx));
        for (var unit : ctx.varDefUnit()) {
            def.defs.add((VarDefUnitNode) visit(unit));
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
                defs.defs.add((VarDefNode) visit(def));
            } else if (def instanceof ClassConstructorContext) {
                defs.defs.add((ClassConstructorNode) visit(def));
            } else if (def instanceof FuncDefContext) {
                defs.defs.add((FuncDefNode) visit(def));
            }
        }
        return defs;
    }

    // Function Define

    @Override
    public ASTNode visitParameter(MxParser.ParameterContext ctx) {
        ParameterNode param = new ParameterNode(new Position(ctx));
        for (int i = 0; i < ctx.type().size(); i++) {
            param.list.add(new VarDefUnitNode(ctx.Identifier(i).getText(), new Position(ctx.Identifier(i))));
        }
        return param;
    }

    @Override
    public ASTNode visitFuncDef(MxParser.FuncDefContext ctx) {
        String funcName = ctx.funcName.getText();
        ParameterNode param = null;
        if (ctx.parameter() != null) {
            param = (ParameterNode) visit(ctx.parameter());
        }
        SuiteNode suite = (SuiteNode) visit(ctx.suite());
        FuncDefNode func = new FuncDefNode(funcName, param, suite, new Position(ctx));
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
        WhileStmtNode stmt = new WhileStmtNode((ExprNode) visit(ctx.condition), (StmtNode) visit(ctx.statement()),
                new Position(ctx));
        return stmt;
    }

    @Override
    public ASTNode visitForStmt(MxParser.ForStmtContext ctx) {
        ExprStmtNode initial = (ExprStmtNode) visit(ctx.initial);
        ExprStmtNode condition = (ExprStmtNode) visit(ctx.condition);
        ExprNode step = null;
        if (ctx.step != null) {
            step = (ExprNode) visit(ctx.step);
        }
        StmtNode suite = (StmtNode) visit(ctx.statement());
        ForStmtNode stmt = new ForStmtNode(initial.expr, condition.expr, step, suite, new Position(ctx));
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
                throw new Error("Need to create array space layer by layer from outer to inner layers",
                        new Position(ctx));
            }
            if (def.expr() == null) {
                isValid = false;
            } else {
                expr.exprs.add((ExprNode) visit(def.expr()));
            }
        }
        if (expr.exprs.size() == 0) {
            throw new Error("Cannot create a empty array.", new Position(ctx));
        }
        return expr;
    }

    @Override
    public ASTNode visitComponentExpr(MxParser.ComponentExprContext ctx) {
        ComponentExprNode expr = new ComponentExprNode((ExprNode) visit(ctx.expr()), ctx.Identifier().getText(),
                new Position(ctx));
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
        AccessArrayExprNode expr = new AccessArrayExprNode((ExprNode) visit(ctx.array), (ExprNode) visit(ctx.index),
                new Position(ctx));
        return expr;
    }

    @Override
    public ASTNode visitIncExpr(MxParser.IncExprContext ctx) {
        IncExprNode expr = new IncExprNode(ctx.op.getText(), (ExprNode) visit(ctx.expr()), new Position(ctx));
        return expr;
    }

    @Override
    public ASTNode visitUnaryExpr(MxParser.UnaryExprContext ctx) {
        UnaryExprNode expr = new UnaryExprNode(ctx.op.getText(), (ExprNode) visit(ctx.expr()), new Position(ctx));
        return expr;
    }

    @Override
    public ASTNode visitBinaryExpr(MxParser.BinaryExprContext ctx) {
        BinaryExprNode expr = new BinaryExprNode((ExprNode) visit(ctx.lhs), ctx.op.getText(), (ExprNode) visit(ctx.rhs),
                new Position(ctx));
        return expr;
    }

    @Override
    public ASTNode visitTernaryExpr(MxParser.TernaryExprContext ctx) {
        TernaryExprNode expr = new TernaryExprNode((ExprNode) visit(ctx.condition), (ExprNode) visit(ctx.trueExpr),
                (ExprNode) visit(ctx.falseExpr), new Position(ctx));
        return expr;
    }

    @Override
    public ASTNode visitAssignExpr(MxParser.AssignExprContext ctx) {
        AssignExprNode expr = new AssignExprNode((ExprNode) visit(ctx.lhs), (ExprNode) visit(ctx.rhs),
                new Position(ctx));
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
            expr.type = ctx.Identifier().getText();
        } else {
            expr.type = "this";
        }
        return expr;
    }
}
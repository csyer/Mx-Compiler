package ast;

import utils.*;
import IR.IRFunction;
import ast.stmt.*;

public class FuncDefNode extends ASTNode {
    public Type returnType;
    public String funcName, className = null;
    public ParameterNode param = null;
    public SuiteNode suite = null;

    public IRFunction irFunc = null;

    public FuncDefNode(Type returnType, String funcName, Position pos) {
        super(pos);
        this.returnType = returnType;
        this.funcName = funcName;
        this.param = new ParameterNode(pos);
    }
    public FuncDefNode(Type returnType, String funcName, String className, Position pos) {
        this(returnType, funcName, pos);
        this.className = className;
    }
    public FuncDefNode(Type returnType, String funcName, SuiteNode suite, Position pos) {
        this(returnType, funcName, pos);
        this.suite = suite;
    }
    public FuncDefNode(Type returnType, String funcName, ParameterNode param, SuiteNode suite, Position pos) {
        this(returnType, funcName, suite, pos);
        this.param = param;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        System.out.printf("%s Function %s (", this.returnType.typeName, this.funcName);
        if (this.param != null)
            this.param.debug();
        System.out.printf(") {%n");
        if (this.suite != null)
            this.suite.debug();
        System.out.printf("}%n");
    }
}
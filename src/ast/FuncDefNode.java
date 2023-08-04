package ast;

import utils.*;

import ast.stmt.*;

public class FuncDefNode extends ASTNode {
    public String funcName, className = null;
    public ParameterNode param = null;
    public SuiteNode suite = null;

    public FuncDefNode(String funcName, ParameterNode param, SuiteNode suite, Position pos) {
        super(pos);
        this.funcName = funcName;
        this.param = param;
        this.suite = suite;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        System.out.printf("Function %s (", this.funcName);
        if (this.param != null)
            this.param.debug();
        System.out.printf(") {%n");
        if (this.suite != null)
            this.suite.debug();
        System.out.printf("}%n");
    }
}
package ast;

import utils.*;
import ast.stmt.SuiteNode;

public class ClassConstructorNode extends ASTNode {
    public String className;
    public SuiteNode suite;

    public ClassConstructorNode(String className, SuiteNode suite, Position pos) {
        super(pos);
        this.className = className;
        this.suite = suite;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        System.out.printf("Constructor %s: {%n", this.className);
        this.suite.debug();
        System.out.println("}");
    }
}

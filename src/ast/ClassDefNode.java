package ast;

import java.util.ArrayList;
import java.util.HashMap;

import utils.Position;

public class ClassDefNode extends ASTNode {
    public String className;
    public ArrayList<FuncDefNode> funcDefs = new ArrayList<FuncDefNode>();
    public ArrayList<VarDefNode> varDefs = new ArrayList<VarDefNode>();
    public ClassConstructorNode constructor = null;

    public HashMap<String, FuncDefNode> memberFunc = new HashMap<String, FuncDefNode>();
    public HashMap<String, VarDefUnitNode> memberVars = new HashMap<String, VarDefUnitNode>();

    public ClassDefNode(String className, Position pos) {
        super(pos);
        this.className = className;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void debug() {
        System.out.printf("Class Define %s { %n", this.className);
        for (var def : this.funcDefs) {
            def.debug();
        }
        for (var def : this.varDefs) {
            def.debug();
        }
        System.out.println("}");
    }
}

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import ast.*;
import frontend.*;
import parser.*;
import utils.*;

public class Main {
    public static void main(String[] args) throws Exception {
        MxLexer lexer = new MxLexer(CharStreams.fromStream(System.in));
        lexer.removeErrorListeners();
        lexer.addErrorListener(new MxErrorListener());
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MxParser parser = new MxParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new MxErrorListener());
        ParseTree tree = parser.program();
        ASTBuilder astBuilder = new ASTBuilder();
        ProgramNode ast = (ProgramNode) astBuilder.visit(tree);
        ast.debug();
    }
}
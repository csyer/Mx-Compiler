import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import ast.*;
import frontend.*;
import parser.*;
import utils.*;
import utils.Error;
import semantic.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
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
            // ast.debug();

            globalScope globalScope = new globalScope(null);
            new SymbolCollector(globalScope).visit(ast);
            new SemanticChecker(globalScope).visit(ast);
        } catch ( Error err ) {
            System.err.println("Fail");
            System.out.println(err.toString());
            return ;
        } 
        System.err.println("Success");
    }
}
import java.io.FileOutputStream;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import ASM.ASMProgram;
import IR.IRProgram;
import ast.*;
import backend.InstSelector;
import backend.RegAllocator;
import frontend.*;
import middleend.*;
import parser.*;
import utils.*;
import utils.Error;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean semantic = false, assembly = false;
        if (args.length == 0) {
            semantic = true;
            assembly = true;
        } else if (args[0].equals("-fsyntax-only")) {
            semantic = true;
            System.err.println("Semantic check");
        } else if (args[0].equals("-S")) {
            semantic = true;
            assembly = true;
            System.err.println("Generate assembly code");
        } else {
            System.err.println("Unknown option");
            return;
        }

        try {
            if (semantic) {
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

                globalScope globalScope = new globalScope(null);
                new SymbolCollector(globalScope).visit(ast);
                new SemanticChecker(globalScope).visit(ast);

                if (assembly) {
                    IRProgram irProgram = new IRProgram();
                    new IRBuilder(irProgram, globalScope).visit(ast);
                    FileOutputStream irOut = new FileOutputStream("test.ll");
                    irOut.write(irProgram.toString().getBytes());
                    irOut.close();

                    ASMProgram asmProgram = new ASMProgram();
                    new InstSelector(asmProgram).visit(irProgram);
                    new RegAllocator(asmProgram).work();
                    // FileOutputStream asmOut = new FileOutputStream("test.s");
                    // asmOut.write(asmProgram.toString().getBytes());
                    // asmOut.close();
                    System.out.println(asmProgram);
                }
            }

        } catch ( Error err ) {
            System.err.println("Fail");
            System.err.println(err.toString());
            throw new Error("", null);
        } 
        System.err.println("Success");
    }
}
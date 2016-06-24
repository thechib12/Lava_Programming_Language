package elaboration;

import grammar.LavaLexer;
import grammar.LavaParser;
import model.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static model.OpCode.*;

/**
 * Created by Rogier on 20-06-16 in Enschede.
 * Generator for the Lava IR language. The Lava IR has already the form of the Sprill, but is not one-to-one.
 * It misses some important keywords and uses unlimited registers. The Lava IR is saved into a {@link Program} object.
 */
public class ForkGenerator extends Generator {
    /**
     * The representation of the boolean value <code>false</code>.
     */
    public final static Addr FALSE_VALUE = new Addr(Addr.AddrType.ImmValue, 0);
    /**
     * The representation of the boolean value <code>true</code>.
     */
    public final static Addr TRUE_VALUE = new Addr(Addr.AddrType.ImmValue, 1);


    private String currentFunction;

    private int memAddr;

    private static final Reg REG_ZERO = new Reg("reg0");


    /**
     * Generates Lava IR from the {@link CheckerResult} and {@link ParseTree}. Generating is done by visiting nodes
     * in the parse tree.
     *
     * @param tree        given parse tree from the {@link LavaParser}.
     * @param checkResult the result of the type checking phase.
     * @return a Program object containing all instructions in Lava IR language.
     */
    public Program generate(ParseTree tree, CheckerResult checkResult, String forkFunctionName, int memAddr) {

        init(tree, checkResult);
        currentFunction = forkFunctionName;
        this.memAddr = memAddr;
        tree.accept(this);

        return super.getProg();
    }


    @Override
    public Op visitBody(LavaParser.BodyContext ctx) {
        Label label = new Label("begin");
        Reg reg = new Reg("r_go");
        Reg reg1 = new Reg("r_busy");
        emit(LoadIm, new Addr(Addr.AddrType.ImmValue, 1), reg1);
        emit(WriteD, reg1, new Addr(Addr.AddrType.DirAddr, memAddr));

        emit(label, TestAndSetD, new Addr(Addr.AddrType.DirAddr, memAddr));
        emit(Receive, reg);

//        emit(Sub, reg1,reg ,reg);
        emit(Branch, reg, label);
        emit(WriteD, reg1, new Addr(Addr.AddrType.DirAddr, memAddr));

//        for (LavaParser.LocalVariableDeclarationStatementContext local: ctx.localVariableDeclarationStatement()) {
//            visitLocalVariableDeclarationStatement(local);
//        }
        for (LavaParser.FunctionDeclContext func : ctx.functionDecl()) {
            if (func.ID().getText().equals(currentFunction)) {
                visit(func.block());
            }
        }
        for (LavaParser.FunctionDeclContext func : ctx.functionDecl()) {
            if (!func.ID().getText().equals(currentFunction)) {
                visit(func);
            }
        }
        emit(WriteD, REG_ZERO, new Addr(Addr.AddrType.DirAddr, memAddr));
        return emit(EndProg);
    }

    public static void main(String[] args) {
        Checker checker = new Checker();
        ForkGenerator generator = new ForkGenerator();
        CharStream input;

        File file = new File("src/main/java/testprograms/function.magma");
        input = null;
        try {
            input = new ANTLRInputStream(new FileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Lexer lexer = new LavaLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);
        LavaParser parser = new LavaParser(tokens);


        ParseTree tree = parser.program();
        CheckerResult result = checker.check(tree);
        System.out.println(checker.getErrors());
        Program program = generator.generate(tree, result).get(0);
        System.out.println(program.toString());
    }

}

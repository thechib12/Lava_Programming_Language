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

    private String currentFunction;

    private int memAddr;

    private static final Reg REG_ZERO = new Reg("reg0");


    /**
     * Generates Lava IR from the {@link CheckerResult} and {@link ParseTree}. Generating is done by visiting nodes
     * in the parse tree.
     *
     * @param tree             given parse tree from the {@link LavaParser}.
     * @param checkResult      the result of the type checking phase.
     * @param forkFunctionName the fork function name
     * @param memAddr          the mem addr
     * @return a Program object containing all instructions in Lava IR language.
     * @throws ParseException the parse exception
     */
    public Program generate(ParseTree tree, CheckerResult checkResult, String forkFunctionName, int memAddr) throws ParseException {

        init(tree, checkResult);
        currentFunction = forkFunctionName;
        this.memAddr = memAddr;
        tree.accept(this);
        if (super.getErrors().size() > 0) {
            throw new ParseException(super.getErrors());
        }
        return super.getProg();
    }


    @Override
    public Op visitBody(LavaParser.BodyContext ctx) {
        Label label = new Label("begin");
        Reg reg = new Reg("r_go");
        Reg reg1 = new Reg("r_busy");
        emit(LoadIm, new Address(Address.AddressType.ImmValue, 1), reg1);
        emit(WriteD, reg1, new Address(Address.AddressType.DirAddr, memAddr));

        emit(label, TestAndSetD, new Address(Address.AddressType.DirAddr, memAddr));
        emit(Receive, reg);

        emit(Branch, reg, label);
//        emit(WriteD, reg1, new Address(Address.AddressType.DirAddr, memAddr));
        for (LavaParser.FunctionDeclarationContext func : ctx.functionDeclaration()) {
            if (func.ID().getText().equals(currentFunction)) {
                visit(func.block());
            }
        }
        emit(WriteD, REG_ZERO, new Address(Address.AddressType.DirAddr, memAddr + 1));
        emit(EndProg);
        for (LavaParser.FunctionDeclarationContext func : ctx.functionDeclaration()) {
            if (!func.ID().getText().equals(currentFunction)) {
                visit(func);
            }
        }

        return null;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
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
        Program program;
        try {
            CheckerResult result = checker.check(tree);

            program = generator.generate(tree, result).get(0);
            System.out.println(program.toString());
        } catch (ParseException e) {
            System.err.println(e.getMessages());
        }

    }

}

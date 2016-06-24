package elaboration;

import grammar.LavaLexer;
import grammar.LavaParser;
import model.Program;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Christiaan on 21-06-16.
 */
public class GeneratorTest {

    @Test
    public void testSimplePrograms() {
        GeneratorTest test = new GeneratorTest();
        String program = test.generate("chamber test1 { mineral $a;" +
                "rock $b = 3 * $a;" +
                "}");
        String expectedProgram = removeSpaces("LoadIm ImmValue 0  r_0 \n" +
                "StoreD r_0  DirAddr 1 \n" +
                "LoadIm ImmValue 3  r_1 \n" +
                "LoadD DirAddr 1  r_2 \n" +
                "Mul r_1,r_2  r_3 \n" +
                "StoreD r_3  DirAddr 2 \n" +
                "EndProg \n");

        String program2 = test.generate("chamber test2 {" +
                "temperature $b = hot and cold;" +
                "}");
        String expectedProgram2 = removeSpaces("LoadIm ImmValue 1  r_0 \n" +
                "LoadIm ImmValue 0 r_1 \n" +
                "And r_0,r_1  r_2    \n" +
                "StoreD r_2  DirAddr 1 \n" +
                "EndProg \n");


        String program3 = test.generate("chamber test3 {" +
                "rock $a = 5;" +
                "rock $b = 3;" +
                "rock $c;" +
                "erupt(){ if ($a < $b)" +
                "then { $c = 2;" +
                "}" +
                "}}");
        String expectedProgram3 = removeSpaces("LoadIm ImmValue 5  r_0 \n" +
                "StoreD r_0  DirAddr 1 \n" +
                "LoadIm ImmValue 3  r_1 \n" +
                "StoreD r_1  DirAddr 2 \n" +
                "LoadIm ImmValue 0  r_2 \n" +
                "StoreD r_2  DirAddr 3 \n" +
                "LoadD DirAddr 1  r_3 \n" +
                "LoadD DirAddr 2  r_4 \n" +
                "Lt r_3,r_4  r_5 \n" +
                "LoadIm ImmValue 1  r_6 \n" +
                "Sub r_6,r_5  r_6 \n" +
                "Branch r_6  endif_1_56 \n" +
                "LoadIm ImmValue 2  r_7 \n" +
                "StoreD r_7  DirAddr 3 \n" +
                "endif_1_56: Nop \n" +
                "EndProg ");

        assertEquals(expectedProgram, program);
        assertEquals(expectedProgram2, program2);
        assertEquals(expectedProgram3, program3);
    }


    public String removeSpaces(String in) {
        return in.replaceAll(("\n"), "").replaceAll(" ", "");
    }

    public String generate(String program) {
        Checker checker = new Checker();
        Generator generator = new Generator();

        ANTLRInputStream input = new ANTLRInputStream(program);
        Lexer lexer = new LavaLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);
        LavaParser parser = new LavaParser(tokens);


        ParseTree tree = parser.program();
        try {
            Program prog = generator.generate(tree, checker.check(tree)).get(0);
            return removeSpaces(prog.toString());
        } catch (ParseException e) {
            return null;
        }

    }
}

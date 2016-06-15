package grammar;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import testutils.ErrorListener;
import testutils.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * Created by Christiaan on 15-06-16.
 */
public class LavaParserTester {
    private static final String BASE_DIR = "src/main/java/testprograms/";

    @Test
    public void simpleProgramTests() throws ParseException {
        String test1 = "chamber testChamber {/^\\ this is a comment \n }";
        String test2 = "chamber testChamber2 {" +
                "erupt() {" +
                "while (hot){doSomething();}" +
                "}  " +
                "}";

        String test3 = "chamber true {}";
        parse(test1, false, "program");
        parse(test2, false, "program");
        parse(test3, false, "program");
    }

    @Test(expected = ParseException.class)
    public void simpleProgramFailTest() throws ParseException {
        String test1 = "chamber testChamber {doSomething();}";
        String test2 = "chaamber testChamber{}";
        String test3 = "chamber testChamber {} ";
        String test4 = "chamber {}";
        String test5 = "chamber{}";
        String test6 = "chamber testChamber { doSomething(); ";
        String test7 = "chamber hot {};";
        parse(test1, false, "program");
        parse(test2, false, "program");
        parse(test3, false, "program");
        parse(test4, false, "program");
        parse(test5, false, "program");
        parse(test6, false, "program");
    }

    @Test
    public void testProgramsTests() throws ParseException {
        parse("consumer", true, "program");
        parse("gauss", true, "program");
        parse("gcd", true, "program");
        parse("hello", true, "program");
        parse("max", true, "program");
        parse("peterson2", true, "program");
        parse("producer", true, "program");
    }

    @Test
    public void expressionTest() throws ParseException {
        String test1 = "if (hot) then { $x = 7; }  else { $x = 3; } ";
        String test2 = "if (1 == $y) then { doSomething(); } else { doSomethingElse(); }";
        String test3 = "if (hot) then doThis();";

        parse(test1, false, "statement");
        parse(test2, false, "statement");
        parse(test3, false, "statement");

    }
    @Test(expected = ParseException.class)
    public void expressionsWrong() throws ParseException {
//
//        target ASS expr SEMI                                  #assignStat
//                | IF LPAR expr RPAR THEN statement (ELSE statement)?    #ifStat
//                | WHILE LPAR expr RPAR  statement                       #whileStat
//                | block                                                 #blockStat
//                | function                                              #functionStat
//                | RETURN expr SEMI                                      #returnStat
//                | emptyStatement                                        #emptyStat
//        ;




    }


    private ParseTree parse(String testProgram, boolean isFile, String parseOption) throws ParseException {
        ErrorListener listener = new ErrorListener();
        CharStream input;
        if (isFile) {
            File file = new File(BASE_DIR + testProgram + ".magma");
            input = new ANTLRInputStream(testProgram);
            try {
                input = new ANTLRInputStream(new FileReader(file));
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else {
            input = new ANTLRInputStream(testProgram);
        }

        Lexer lexer = new LavaLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(listener);

        TokenStream tokens = new CommonTokenStream(lexer);
        LavaParser parser = new LavaParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(listener);

        ParseTree result = null;
        if (parseOption.equals("program")) {
            result = parser.program();
        } else if (parseOption.equals("statement")) {
            result = parser.statement();

        } else {
            result = parser.expr();
        }



        listener.throwException();

        return result;
    }
}

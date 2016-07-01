package grammar;

import elaboration.ErrorListener;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;
import testutils.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * Created by Christiaan on 15-06-16.
 */
public class LavaParserTester {
    private static final String BASE_DIR = "src/main/java/testprograms/";

    /**
     * Instantiates a new Lava parser tester.
     */
    public LavaParserTester() {

    }

    /**
     * Simple program tests.
     *
     * @throws ParseException the parse exception
     */
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

    /**
     * Simple program fail test.
     */
    @Test
    public void simpleProgramFailTest() {
        System.out.println("Simple Program Failure");
        String test1 = "chamber testChamber {doSomething();}";
        String test2 = "chaamber testChamber{}";
        String test3 = "chamber testChamber { ";
        String test4 = "chamber {}";
        String test5 = "chamber{}";
        String test6 = "chamber testChamber { doSomething(); ";
        testParseFailure(test1, false, "program");
        testParseFailure(test2, false, "program");
        testParseFailure(test3, false, "program");
        testParseFailure(test4, false, "program");
        testParseFailure(test5, false, "program");
        testParseFailure(test6, false, "program");


    }

    /**
     * Test programs tests.
     *
     * @throws ParseException the parse exception
     */
    @Test
    public void testProgramsTests() throws ParseException {
        parse("gauss", true, "program");
        parse("gcd", true, "program");
        parse("hello", true, "program");
        parse("max", true, "program");
        parse("peterson2", true, "program");
        parse("bank", true, "program");
        parse("basic", true, "program");
        parse("fib", true, "program");
        parse("ifelse", true, "program");
        parse("simpletest1", true, "program");
        parse("simpletest2", true, "program");
        parse("simpletest3", true, "program");
        parse("simpletest4", true, "program");
        parse("simpletest5", true, "program");
        parse("simpletest6", true, "program");

    }

    /**
     * Statement test.
     *
     * @throws ParseException the parse exception
     */
    @Test
    public void statementTest() throws ParseException {
        String test1 = "if (hot) then { $x = 7; }  else { $x = 3; } ";
        String test2 = "if (1 == $y) then { doSomething(); } else { rock[] $array = with size 3; $array =  [1,2,34]; }";
        String test3 = "if (hot) then { doThis(); }";
        String test4 = "while ($thisIsABool) { if ($anotherBool) then { /^\\ another comment here! \n $bool = ($a == $b); } else { rock $a = 12; }}";
        String test5 = "return ($a == $b);";
        String test6 = "$a = 51;";
        parse(test1, false, "statement");
        parse(test2, false, "statement");
        parse(test3, false, "statement");
        parse(test4, false, "statement");
        parse(test5, false, "statement");
        parse(test6, false, "statement");
    }

    /**
     * Statements wrong test.
     *
     * @throws ParseException the parse exception
     */
    @Test
    public void statementsWrongTest() throws ParseException {
        System.out.println("Statements Failure Test");
        String test1 = "if $a then { doSomething(); } ";
        String test2 = "return;";
        String test3 = "if then { doSomething(); }";
        String test4 = "if ($a  = $c) then { $a = $b;  } ";
        String test5 = "while (hot) { $a; } ";
        String test6 = "while hot { doSomething(); }";
        testParseFailure(test1, false, "statement");
        testParseFailure(test2, false, "statement");
        testParseFailure(test3, false, "statement");
        testParseFailure(test4, false, "statement");
        testParseFailure(test5, false, "statement");
        testParseFailure(test6, false, "statement");
    }

    /**
     * Expr test.
     *
     * @throws ParseException the parse exception
     */
    @Test
    public void exprTest() throws ParseException {
        String test1 = "3.3";
        String test2 = "not hot";
        String test3 = "3.1 * 5";
        String test4 = "not hot and cold";
        String test5 = "1 < 3";
        String test6 = "1 <= (3+4)";
        String test7 = "doSomething($a)";
        String test8 = "(not not not not not hot)";
        String test9 = "[1,2,3]";
        String test10 = "$a";
        String test11 = "$a[3+3]";

        parse(test1, false, "expr");
        parse(test2, false, "expr");
        parse(test3, false, "expr");
        parse(test4, false, "expr");
        parse(test5, false, "expr");
        parse(test6, false, "expr");
        parse(test7, false, "expr");
        parse(test8, false, "expr");
        parse(test9, false, "expr");
        parse(test10, false, "expr");
        parse(test11, false, "expr");


    }

    /**
     * Expr fail test.
     */
    @Test
    public void exprFailTest() {
        System.out.println("Expression Failure Test");
        String test1 = ".3";
        String test2 = "not";
        String test3 = "3.1 * ";
        String test4 = "not hot and ";
        String test5 = "1 << 3";
        String test6 = "1 = (3+4)";
        String test7 = "\"test";
        String test8 = "cool + 3";
        String test9 = "[1,2,3";
        String test10 = "a";
        String test11 = "$a[3+3";
        String test12 = "doSomething($a";

        testParseFailure(test1, false, "expr");
        testParseFailure(test2, false, "expr");
        testParseFailure(test3, false, "expr");
        testParseFailure(test4, false, "expr");
        testParseFailure(test5, false, "expr");
        testParseFailure(test6, false, "expr");
        testParseFailure(test7, false, "expr");
        testParseFailure(test8, false, "expr");
        testParseFailure(test9, false, "expr");
        testParseFailure(test10, false, "expr");
        testParseFailure(test11, false, "expr");
        testParseFailure(test12, false, "expr");


    }

    /**
     * Test parse failure.
     *
     * @param testString  the test string
     * @param isFile      the is file
     * @param parseOption the parse option
     */
    public void testParseFailure(String testString, boolean isFile, String parseOption) {
        try {
            parse(testString, isFile, parseOption);
            Assert.fail();
        } catch (ParseException e) {

        }
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


        System.err.println(listener.getErrors());

        return result;
    }
}

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
        String test7 = "chamber var {};";
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
    public void statementTest() throws ParseException {
        String test1 = "if (hot) then { $x = 7; }  else { $x = 3; } ";
        String test2 = "if (1 == $y) then { doSomething(); } else { pebble[] $array = [1,2,34]; }";
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

    @Test(expected = ParseException.class)
    public void statementsWrongTest() throws ParseException {
        String test1 = "if ($a) then doSomething(); ";
        String test2 = "retrun ($a == $b);";
        String test3 = "if then { doSomething(); }";
        String test4 = "if if ($a  == $c) then { $a = $b;  } ";
        String test5 = " while (hot) { $a; } ";
        String test6 = " while { doSomething(); }";
        parse(test1, false, "statement");
        parse(test2, false, "statement");
        parse(test3, false, "statement");
        parse(test4, false, "statement");
        parse(test5, false, "statement");
        parse(test6, false, "statement");
    }

    @Test
    public void exprTest() throws ParseException {
        /*expr:
        expr DOT expr        #fieldExpr
                | NOT expr            #notExpr
                | expr multOp expr    #multExpr
                | expr plusOp expr    #plusExpr
                | expr boolOp expr #boolExpr
                | expr compOp expr #compExpr
                | LPAR expr RPAR    #parExpr
                | NUM               #numExpr
                | TRUE              #trueExpr
                | STATIC_STRING     #staticstringExpr
                | FALSE             #falseExpr
                | function             #inputExpr
                | arrayInit             #arrayInitExpr
                | VARID LBLOCK expr RBLOCK #arrayExpr
                | VARID                #idExpr
        ;*/

        String test1 = "3.3";
        String test2 = "not hot";
        String test3 = "3.1 * 5";
        String test4 = "not and hot";
        String test5 = "1 < 3";
        String test6 = "1 <= (3+4)";
        String test7 = "\"test\"";
        String test8 = "(not not not not not hot)";
        String test9 = "[1,2,3]";
        String test10 = "$a";
        String test11 = "$a[3+3]";
        String test12 = "doSomething($a)";

        parse(test1, false, "expr");
        parse(test2, false, "expr");
        parse(test2, false, "expr");
        parse(test2, false, "expr");
        parse(test2, false, "expr");
        parse(test2, false, "expr");
        parse(test2, false, "expr");
        parse(test2, false, "expr");


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

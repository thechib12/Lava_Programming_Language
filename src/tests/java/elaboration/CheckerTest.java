package elaboration;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Rogier on 16-06-16 in Enschede.
 */
public class CheckerTest {
    private final static String BASE_DIR = "src/main/java/testprograms/";
    private final static String EXT = ".magma";
    private final LavaCompiler compiler = LavaCompiler.instance();


    @Test
    public void testBasicTypes() throws IOException, ParseException {
        ParseTree tree = parse("basic");
        CheckerResult result = check(tree);
        ParseTree body = tree.getChild(3);
        assertEquals(Type.INT, result.getType(body.getChild(0)));
        assertEquals(Type.CHAR, result.getType(body.getChild(1)));
        assertEquals(Type.BOOL, result.getType(body.getChild(2)));
//        assertEquals(Type.INT, result.getType(body.getChild(3)));
//        assertEquals(Type.CHAR, result.getType(body.getChild(4)));
    }

//    @Test
//    public void testBasicEntries() throws IOException, ParseException {
//        ParseTree tree = parse("basic");
//        CheckerResult result = check(tree);
//        ParseTree body = tree.getChild(3);
//        ParseTree assX = body.getChild(3).getChild(3).getChild(1).getChild(0).getChild(0);
//        assertEquals(assX.getChild(2), result.getEntry(assX));
////        assertEquals(assX.getChild(2), result.getEntry(body.getChild(3)));
//    }

    @Test
    public void testBasicOffsets() throws IOException, ParseException {
        ParseTree tree = parse("basic");
        CheckerResult result = check(tree);
        ParseTree body = tree.getChild(3).getChild(3).getChild(3).getChild(1);
        ParseTree assA = body.getChild(0).getChild(0);
        ParseTree assB = body.getChild(1).getChild(0);
        ParseTree assC = body.getChild(2).getChild(0);
        assertEquals(1, result.getOffset(assA.getChild(0)));
        assertEquals(2, result.getOffset(assB.getChild(0)));
        assertEquals(3, result.getOffset(assC.getChild(0)));

    }


    @Test
    public void testPrograms() throws IOException, ParseException {
        check(parse("bank"));
        check(parse("basic"));
//        check(parse("fib"));
        check(parse("function"));
        check(parse("gauss"));
//        check(parse("gcd"));
//        check(parse("hello"));
        check(parse("ifelse"));
        check(parse("infiniteLoop"));
//        check(parse("max"));
//        check(parse("peterson2"));
        check(parse("scopetester"));
        check(parse("tester"));
        check(parse("simpletest1"));
        check(parse("simpletest2"));
        check(parse("simpletest3"));

    }

    @Test
    public void testReturnType() throws IOException, ParseException {
        String program1 = "chamber test1 { mineral $a;" +
                "rupture mineral doSomething() {" +
                "$a = 'a';" +
                "return $a;" +
                "}" +
                "}";
        String program2 = "chamber test2 { rock $a;" +
                "rupture rock doSomething() {" +
                "$a = 5;" +
                "return (($a *5 ) / 3);" +
                "}" +
                "}";
        String program3 = "chamber test3 { " +
                "rupture temperature doSomething() {" +
                "return (hot and cold);" +
                "}" +
                "}";
        String program4 = "chamber test5 { temperature $a;" +
                "rupture temperature doSomething() {" +
                "return ($a xor cold); " +
                "}" +
                "}";
        String program5 = "chamber test6 { rock $a = 5; temperature $b = hot;" +
                "rupture rock doSomething() {" +
                "rock $c = 2;" +
                "$a = $c;" +
                "return $c;" +
                "}" +
                "}";

        check(parseString(program1));
        check(parseString(program2));
        check(parseString(program3));
        check(parseString(program4));
//        check(parseString(program5));
    }


    @Test
    public void testReturnTypeFailure() throws IOException {
        System.out.println("Test Return Type Failure");
        String program1 = "chamber test1 { mineral $a;" +
                "rupture mineral doSomething() {" +
                "$a = 3;" +
                "rock $b = 4;" +
                "return $b;" +
                "}" +
                "}";
        String program2 = "chamber test2 { rock $a;" +
                "rupture temperature doSomething() {" +
                "return $a;" +
                "}" +
                "}";
        String program3 = "chamber test3 { " +
                "rupture temperature doSomething() {" +
                "return (hot and cold);" +
                "}" +
                "rupture rock doSomethingElse(){" +
                "return (doSomething());" +
                "}" +
                "}";
        String program4 = "chamber test5 { temperature $a;" +
                "rupture temperature doSomething() {" +
                "return 3+ $a; " +
                "}" +
                "}";
        String program5 = "chamber test5 { temperature $a;" +
                "rupture temperature doSomething() {" +
                "if ( cold ) then {" +
                "return 3;" +
                "} else {" +
                "return ($a xor cold); " +
                "}" +
                "}" +
                "}";
        String program6 = "chamber test6 { " +
                "rupture void doSomething() {" +
                "rock $a = 3;" +
                "return $a; " +
                "}" +
                "}";


//        checkFail((program1));
//        checkFail((program2));
//        checkFail((program3));
//        checkFail((program4));
//        checkFail((program5));
        checkFail((program6));
    }
    @Test
    public void testAssignments() throws IOException, ParseException {
        String program1 = "chamber test1 { mineral $a; " +
                "erupt(){" +
                "$a = 'a'; " +
                "}" +
                "}";
        String program2 = "chamber test2 { rock $a; " +
                "erupt(){" +
                "$a = 2; " +
                "}" +
                "}";
        String program3 = "chamber test3 { rock $a; temperature $b; mineral $c;" +
                "erupt(){" +
                "$a = ( 2101 +3 ); " +
                "$b = (hot and cold);" +
                "$c = 'a'; " +
                "}" +
                "}";
        String program4 = "chamber test4 { rock $a; mineral $b; rock $c;" +
                "erupt(){" +
                "$a = 100;" +
                "$b = 'a';  " +
                "$c = 1021;" +
                "$c = (($a - 3) + 5);" +
                "}" +
                "}";
        String program5 = "chamber test4 { rock $a; rock $b; rock $c;" +
                "erupt(){" +
                "$a = 100;" +
                "$b = 5;  " +
                "$c = 1;" +
                "$c = ((($a +3)-$b)+$c);" +
                "$b = (($c * 500) / 3); " +
                "}" +
                "}";
        check(parseString(program1));
        check(parseString(program2));
        check(parseString(program3));
        check(parseString(program4));
        check(parseString(program5));
    }

    @Test
    public void testFailureAssignments() throws IOException, ParseException {
        System.out.println("Test Failure Assignments");
        String program1 = "chamber test1 { rock $a; " +
                "erupt(){" +
                "$a = 'a'; " +
                "}" +
                "}";
        String program2 = "chamber test1 { rock $a; mineral $b; " +
                "erupt(){" +
                "$a = 1;" +
                "$b = 'a'; " +
                "$a = $b;" +
                "}" +
                "}";

        String program3 = "chamber test3 { rock $a; temperature $b; mineral $c;" +
                "erupt(){" +
                "$a = ( 2101 +3 ); " +
                "$b = (hot and cold);" +
                "$c = ($a + $b); " +
                "}" +
                "}";
        String program4 = "chamber test4 { rock $a; mineral $b; rock $c;" +
                "erupt(){" +
                "$a = 1;" +
                "$b = 'a';  " +
                "$c = 3;" +
                "$c = ((($a - 3) + 5) and hot);" +
                "}" +
                "}";
        String program5 = "chamber test4 { rock $a; rock $b; rock $c;" +
                "erupt(){" +
                "$a = 100;" +
                "$b = 5;  " +
                "$c = 1;" +
                "$c = ((($a +3)-$b)+$c);" +
                "$b = (($c * 500) / 3) + 'a'; " +
                "}" +
                "}";

        checkFail((program1));
        checkFail((program2));
        checkFail((program3));
        checkFail((program4));
        checkFail((program5));
    }

    @Test
    public void testExpressionTypesFailure() throws IOException {
        System.out.println("Test Expression Types Failure");
        String program1 = "chamber test1 { mineral $a; " +
                "erupt(){" +
                "while ($a) {" +
                "dosomething(); " +
                "}" +
                "}}";
        String program2 = "chamber test2 {  " +
                "erupt(){" +
                "if (3*5) then { doSomething();} " +
                "}" +
                "}";
        String program3 = "chamber test3 { rock $a; temperature $b; mineral $c;" +
                "erupt(){" +
                "if (3=='c') then { doSomething();}" +
                "else if ( 'b' ) then {doSomethingelse();}" +
                "else { doSomethingElseElse(); } " +
                "}" +
                "}";

        checkFail(program1);
        checkFail(program2);
        checkFail(program3);
        System.out.println("Test 4");
        System.out.println("Test 5");
    }


    @Test
    public void scopeFailure() throws IOException {
        System.out.println("Test Scope Failure");
        String program1 = "chamber test1 { mineral $a; " +
                "erupt(){" +
                "rock $c = $a + 2;" +
                "}" +
                "}";
        String program2 = "chamber test2 {" +
                "rock $a = 2;" +
                "rock $b = 1;  " +
                "rupture rock func1(){" +
                "rock $c = $a * $b;" +
                "return $c;" +
                "}" +
                "rupture rock func2(){" +
                "$a = $c;" +
                "}" +
                "}";
        String program3 = "chamber test3 { " +
                "erupt(){" +
                "if (hot) then { rock $a = 4;}" +
                "  else { rock $b = $a * 2; } " +
                "}" +
                "}";
        String program4 = "chamber test4 {" +
                "erupt(){" +
                "rock $b = $a + 2; " +
                "}" +
                "}";

        checkFail(program1);
        checkFail(program2);
        checkFail(program3);
        checkFail(program4);
    }

    @Test
    public void scopeTest() throws IOException, ParseException {
        String program1 = "chamber test1 { rock $a =2; " +
                "erupt(){" +
                "rock $b = 3;" +
                "$a = $b; " +
                "}" +
                "}";
        String program2 = "chamber test2 { rock $a; " +
                "rupture rock func(){" +
                "rock $b = $a *2;" +
                "return $b;" +
                "}" +
                "erupt(){" +
                "$a = 2; " +
                "}" +
                "" +
                "}";
        String program3 = "chamber test3 { rock $a =2 ; temperature $b = cold; mineral $c = 'b';" +
                "rupture mineral func1(){" +
                "if ($b) then {" +
                "$a = 3;" +
                "}" +
                "return $c;" +
                "} " +
                "erupt(){" +
                "$a = ( 2101 +3 ); " +
                "$b = (hot and cold);" +
                "$c = 'a'; " +
                "}" +
                "}";
        check(parseString(program1));
        check(parseString(program2));
        check(parseString(program3));
    }


    private void checkFail(String program) {
        try {
            ParseTree tree = this.compiler.parse(program);
            CheckerResult result = this.compiler.check(tree);
            fail();
        } catch (ParseException e) {
            System.err.println(e.getMessages());
        }



    }

    private ParseTree parse(String filename) throws IOException, ParseException {
        return this.compiler.parse(new File(BASE_DIR, filename + EXT));
    }

    private ParseTree parseString(String program) throws IOException, ParseException {
        return this.compiler.parse(program);
    }



    private CheckerResult check(ParseTree tree) throws ParseException {
        CheckerResult result = this.compiler.check(tree);
        assertEquals(0, this.compiler.getChecker().getErrors().size());
        return result;
    }
}

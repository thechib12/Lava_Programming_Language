package elaboration;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Rogier on 16-06-16 in Enschede.
 */
public class CheckerTest {
    private final static String BASE_DIR = "src/main/java/testprograms/";
    private final static String EXT = ".magma";
    private final LavaCompiler compiler = LavaCompiler
            .instance();


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

    @Test
    public void testBasicEntries() throws IOException, ParseException {
        ParseTree tree = parse("basic");
        CheckerResult result = check(tree);
        ParseTree body = tree.getChild(3);
        ParseTree assX = body.getChild(3).getChild(3).getChild(1).getChild(0).getChild(0);
        assertEquals(assX.getChild(2), result.getEntry(assX));
        assertEquals(assX.getChild(2), result.getEntry(body.getChild(3)));
    }

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
        String program4 = "chamber test1 { rock $a; rock $b;" +
                "rupture rock veryLargeComputation() {" +
                "$a = (($a *1010101) / 512)+5;" +
                "return $a;" +
                "}" +

                "rupture temperature test4(rock $b){" +
                "rock $c = veryLargeComputation();" +
                "return ($b  == $c );" +
                "}" +
                "}";
        String program5 = "chamber test5 { temperature $a;" +
                "rupture temperature doSomething() {" +
                "return ($a xor cold); " +
                "}" +
                "}";
        String program6 = "chamber test6 { rock $a = 5; temperature $b = hot;" +
                "rupture rock doSomething(rock $c) {" +
                //"$a = $c;" +
                "return $c;" +
                "}" +
                "}";

        check(parseString(program1));
        check(parseString(program2));
        check(parseString(program3));
        check(parseString(program4));
        check(parseString(program5));
//        check(parseString(program6));
    }
    @Test
    public void checkProgram() throws IOException, ParseException {
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
    public void testFailures() throws IOException, ParseException {
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
        checkFail(parseString(program1));
        checkFail(parseString(program2));
        checkFail(parseString(program3));
        checkFail(parseString(program4));
        checkFail(parseString(program5));
    }


    private void checkFail(ParseTree tree) throws ParseException {
        CheckerResult result = this.compiler.check(tree);
        assertNotEquals(0, this.compiler.getChecker().getErrors().size());


    }

    private ParseTree parse(String filename) throws IOException, ParseException {
        return this.compiler.parse(new File(BASE_DIR, filename + EXT));
    }

    private ParseTree parseString(String program) throws IOException, ParseException {
        return this.compiler.parse(program);
    }



    private CheckerResult check(ParseTree tree) throws ParseException {
        CheckerResult result = this.compiler.check(tree);
        System.out.println(this.compiler.getChecker().getErrors());
        assertEquals(0, this.compiler.getChecker().getErrors().size());
        return result;
    }
}

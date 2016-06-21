package elaboration;

import grammar.LavaLexer;
import grammar.LavaParser;
import grammar.LavaParserTester;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import elaboration.ParseException;
import org.junit.Test;
import testutils.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
//
@Test
    public void testBasicOffsets() throws IOException, ParseException {
        ParseTree tree = parse("basic");
        CheckerResult result = check(tree);
    ParseTree body = tree.getChild(3).getChild(3).getChild(3).getChild(1);
    ParseTree assA = body.getChild(0).getChild(0);
    ParseTree assB = body.getChild(1).getChild(0);
    ParseTree assC = body.getChild(2).getChild(0);
        assertEquals(0, result.getOffset(assA.getChild(0)));
    assertEquals(4, result.getOffset(assB.getChild(0)));
    assertEquals(6, result.getOffset(assC.getChild(0)));

    }

    @Test
    public void checkProgram() throws IOException, ParseException {
        String program1 = "chamber test1 { rock $a; " +
                "erupt(){" +
                "$a = 'a'; " +
                "}" +
                "}";
        String program2 = "chamber test1 { rock $a; " +
                "erupt(){" +
                "$a = 2; " +
                "}" +
                "}";
//        check(parseString(program1));
        checkFail("basic");
        check(parseString(program2));
    }




    private void checkFail(String filename) throws IOException {
        try {
            check(parse(filename));
            fail(filename + " shouldn't check but did");
        } catch (ParseException exc) {
            // this is the expected behaviour
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

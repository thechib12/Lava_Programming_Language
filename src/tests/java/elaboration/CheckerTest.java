package elaboration;

import org.antlr.v4.runtime.tree.ParseTree;
import elaboration.ParseException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Rogier on 16-06-16 in Enschede.
 */
public class CheckerTest {
    private final static String BASE_DIR = "./src/main/java/testprograms/";
    private final static String EXT = ".magma";
    private final LavaCompiler compiler = LavaCompiler
            .instance();


    @Test
    public void testBasicTypes() throws IOException, ParseException {
        ParseTree tree = parse("basic");
        CheckerResult result = check(tree);
        ParseTree body = tree.getChild(3).getChild(1);
        ParseTree assX = body.getChild(1);
        assertEquals(Type.INT, result.getType(assX.getChild(0)));
        assertEquals(Type.CHAR, result.getType(assX.getChild(2)));
        assertEquals(Type.BOOL, result.getType(assX.getChild(0)));
        assertEquals(Type.StringType, result.getType(assX.getChild(2)));
        assertEquals(Type.INT, result.getType(assX.getChild(0)));
        assertEquals(Type.INT, result.getType(assX.getChild(2)));
        assertEquals(Type.INT, result.getType(assX.getChild(0)));
        assertEquals(Type.INT, result.getType(assX.getChild(2)));
    }

//    @Test
//    public void testBasicEntries() throws IOException, ParseException {
//        ParseTree tree = parse("basic");
//        CheckerResult result = check(tree);
//        ParseTree body = tree.getChild(3).getChild(1);
//        ParseTree assX = body.getChild(1);
//        assertEquals(assX.getChild(2), result.getEntry(assX));
//        assertEquals(assX.getChild(2), result.getEntry(body));
//    }
//
//    @Test
//    public void testBasicOffsets() throws IOException, ParseException {
//        ParseTree tree = parse("basic");
//        CheckerResult result = check(tree);
//        ParseTree body = tree.getChild(3).getChild(1);
//        ParseTree assX = body.getChild(1);
//        assertEquals(0, result.getOffset(assX.getChild(0)));
//    }



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

    private CheckerResult check(ParseTree tree) throws ParseException {
        return this.compiler.check(tree);
    }
}

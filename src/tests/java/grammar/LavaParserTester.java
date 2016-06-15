package grammar;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.text.ParseException;

/**
 * Created by Christiaan on 15-06-16.
 */
public class LavaParserTester {

    private ParseTree parse(String testProgram) throws ParseException {
        ErrorListener listener = new ErrorListener();

        CharStream input = new ANTLRInputStream(testProgram);
        Lexer lexer = new LavaLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(listener);

        TokenStream tokens = new CommonTokenStream(lexer);
        LavaParser parser = new LavaParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(listener);

        ParseTree result = parser.program();

        listener.throwException();

        return result;
    }
}

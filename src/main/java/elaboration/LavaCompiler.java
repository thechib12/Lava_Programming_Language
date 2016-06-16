package elaboration;

import grammar.LavaLexer;
import grammar.LavaParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Christiaan + Rogier on 16-06-16 in Enschede.
 */
public class LavaCompiler {
    private final static LavaCompiler instance = new LavaCompiler();
    /** Debug flag. */
    private final static boolean SHOW = true;

    /** Returns the singleton instance of this class. */
    public static LavaCompiler instance() {
        return instance;
    }


    /** The fixed checker of this compiler. */
    private final Checker checker;
    /** The fixed generator of this compiler. */
//    private final Generator generator;

    private LavaCompiler() {
        this.checker = new Checker();
//        this.generator = new Generator();
    }

    /** Typechecks a given Simple Pascal string. */
    public CheckerResult check(String text) throws ParseException {
        return check(parse(text));
    }

    /** Typechecks a given Simple Pascal file. */
    public CheckerResult check(File file) throws ParseException, IOException {
        return check(parse(file));
    }

    /** Typechecks a given Simple Pascal parse tree. */
    public CheckerResult check(ParseTree tree) throws ParseException {
        return this.checker.check(tree);
    }



    /** Compiles a given Simple Pascal string into a parse tree. */
    public ParseTree parse(String text) throws ParseException {
        return parse(new ANTLRInputStream(text));
    }

    /** Compiles a given Simple Pascal string into a parse tree. */
    public ParseTree parse(File file) throws ParseException, IOException {
        return parse(new ANTLRInputStream(new FileReader(file)));
    }

    private ParseTree parse(CharStream chars) throws ParseException {
        ErrorListener listener = new ErrorListener();
        Lexer lexer = new LavaLexer(chars);
        lexer.removeErrorListeners();
        lexer.addErrorListener(listener);
        TokenStream tokens = new CommonTokenStream(lexer);
        LavaParser parser = new LavaParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(listener);
        ParseTree result = parser.program();
//		System.out.println(result.toStringTree(parser));

        listener.throwException();
        return result;
    }


}

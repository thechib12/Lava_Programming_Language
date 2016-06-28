package testutils;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.List;

/**
 * Antlr error listener to collect errors rather than send them to stderr.
 */
public class ErrorListener extends BaseErrorListener {
    /**
     * Errors collected by the listener.
     */
    private final List<String> errors = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol, int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        this.errors.add(String.format(" line %d:%d - %s", line,
                charPositionInLine,
                msg));
    }

    public void throwException() throws ParseException {
        if (hasErrors()) {
            throw new ParseException(getErrors());
        }
    }

    public void printErrors() {
        getErrors().forEach(System.out::println);
    }
    /**
     * Indicates if the listener has collected any errors.
     */
    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    /**
     * Returns the (possibly empty) list of errors collected by the listener.
     */
    public List<String> getErrors() {
        return this.errors;
    }
}

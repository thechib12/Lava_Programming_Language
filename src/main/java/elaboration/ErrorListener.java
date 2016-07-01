package elaboration;

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

    /**
     * Throw exception when the list is not empty.
     *
     * @throws ParseException the parse exception
     */
    public void throwException() throws ParseException {
        if (hasErrors()) {
            throw new ParseException(getErrors());
        }
    }


    /**
     * Indicates if the listener has collected any errors.
     */
    private boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    /**
     * Returns the (possibly empty) list of errors collected by the listener.
     *
     * @return the errors
     */
    public List<String> getErrors() {
        return this.errors;
    }
}

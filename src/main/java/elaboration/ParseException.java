package elaboration;

import java.util.List;

/**
 * Exception class wrapping a list of error messages.
 */
public class ParseException extends Exception {
    private final List<String> messages;

    public ParseException(List<String> messages) {
        super(messages.toString());
        this.messages = messages;
    }

    /**
     * Returns the error messages wrapped in this exception.
     */
    public List<String> getMessages() {
        return this.messages;
    }

    /**
     * Prints all error messages to stdout, line by line.
     */
    public void print() {
        for (String error : getMessages()) {
            System.out.println(error);
        }
    }
}
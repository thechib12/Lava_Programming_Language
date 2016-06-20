package model;

import java.util.ArrayList;
import java.util.List;

/** Exception class to collect errors found during
 * scanning, parsing and assembly of an ILOC program.
 * @author Arend Rensink
 */
public class FormatException extends Exception {
	/** Constructs an exception without a message. */
	public FormatException() {
		// empty
	}

	/** Constructs an exception with a formatted message. 
	 * @param message format string in {@link String#format(String, Object...)} syntax
	 * @param args arguments for the format string
	 */
	public FormatException(String message, Object... args) {
		super(String.format(message, args));
		this.messages.add(getMessage());
	}

	/** Constructs an exception from a list of messages. */
	public FormatException(List<String> messages) {
		super(concat(messages));
		this.messages.addAll(messages);
	}

	private final List<String> messages = new ArrayList<>();

	static private final String concat(List<String> args) {
		StringBuilder result = new StringBuilder();
		for (String arg : args) {
			result.append(arg);
			result.append('\n');
		}
		return result.toString();
	}
}

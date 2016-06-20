package model;

/** Label operand.
 * @author Arend Rensink
 */
public class Label extends Operand {
	/** Constructs a label object with a given label text. */
	public Label(String value) {
		super(Type.LABEL);
		assert wellformed(value) : String.format(
				"Label '%s' is not well-formed", value);
		this.value = value;
	}

	/** Returns the value of this label. */
	public String getValue() {
		return this.value;
	}

	private final String value;

	@Override
	public String toString() {
		return this.value;
	}

	@Override
	public int hashCode() {
		return getValue().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Label)) {
			return false;
		}
		Label other = (Label) obj;
		if (!getValue().equals(other.getValue())) {
			return false;
		}
		return true;
	}

	/** Tests if a string value is a well-formed label. */
	private boolean wellformed(String value) {
		if (value == null) {
			return false;
		}
		if (value.isEmpty()) {
			return false;
		}
		if (!Character.isLetter(value.charAt(0))) {
			return false;
		}
		for (int i = 1; i < value.length(); i++) {
			char c = value.charAt(i);
			if (!(Character.isLetterOrDigit(c) || c == '-' || c == '_')) {
				return false;
			}
		}
		return true;
	}
}
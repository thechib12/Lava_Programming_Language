package model;

/** Numeric operand.
 * A numeric operand can be a literal or a (symbolic) constant.
 * @author Arend Rensink
 */
public class Num extends Operand {
	/** Value of the numeric operand, if it is a literal. */
	private final int value;
	/** Name of the numeric operand, if it is a symbolic constant. */
	private final String name;
	/** Label wrapped in the numeric operand, if it is label-based. */
	private final Label label;
	/** The kind of numeric operand. */
	private final NumKind kind;

	/** Constructs a literal numeric operand. */
	public Num(int value) {
		super(Type.NUM);
		this.kind = NumKind.LIT;
		this.value = value;
		this.name = null;
		this.label = null;
	}

	/** Constructs a symbolic numeric operand.
	 * @name name symbolic name, without '@'-prefix
	 */
	public Num(String name) {
		super(Type.NUM);
		this.kind = NumKind.SYMB;
		assert wellformed(name);
		this.name = name;
		this.value = -1;
		this.label = null;
	}

	/** Constructs a label-based numeric operand. */
	public Num(Label label) {
		super(Type.NUM);
		this.kind = NumKind.LAB;
		this.label = label;
		this.value = -1;
		this.name = null;
	}

	/** Returns the kind of this numeric operand. */
	public NumKind getKind() {
		return this.kind;
	}

	/** Returns the label on which this operand is based, 
	 * if it is label-based. */
	public Label getLabel() {
		return this.label;
	}

	/** Returns the value of this numeric operand, if it is a literal. */
	public int getValue() {
		return this.value;
	}

	/** Returns the name of this numeric operand, if it is a constant. */
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		switch (getKind()) {
		case LAB:
			return "#" + getLabel();
		case LIT:
			return "" + getValue();
		case SYMB:
			return '@' + getName();
		default:
			assert false;
			return null;
		}
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = prime * getKind().hashCode();
		switch (getKind()) {
		case LAB:
			result += getLabel().hashCode();
			break;
		case LIT:
			result += getValue();
			break;
		case SYMB:
			result += getName().hashCode();
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Num)) {
			return false;
		}
		Num other = (Num) obj;
		if (getKind() != other.getKind()) {
			return false;
		}
		switch (getKind()) {
		case LAB:
			return getLabel().equals(other.getLabel());
		case LIT:
			return getValue() == other.getValue();
		case SYMB:
			return getName().equals(other.getName());
		default:
			assert false;
			return false;
		}
	}

	/** Tests if a string value is a well-formed name. */
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

	/** Type class for numeric operands. */
	public static enum NumKind {
		/** Literal constant. */
		LIT,
		/** Symbolic name. */
		SYMB,
		/** Label-based constant. */
		LAB;
	}
}
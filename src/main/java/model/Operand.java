package model;

/** Abstract supertype of all kinds of operands. */
abstract public class Operand {
	private final Type type;

	protected Operand(Type type) {
		this.type = type;
	}

	/** Returns the type of this operand. */
	public Type getType() {
		return this.type;
	}

	/** Enumeration of all available operand types. */
	public static enum Type {
		/** Register-type operand; class {@link Reg}. */
		REG,

		/** Target operand; class {@link Target}. */
		TARGET,

        ADDR,

		LABEL

	}
}

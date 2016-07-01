package model;

/**
 * Abstract supertype of all kinds of operands.
 */
abstract public class Operand {
	private final Type type;

	/**
	 * Instantiates a new Operand.
	 *
	 * @param type the type
	 */
	protected Operand(Type type) {
		this.type = type;
	}

	/**
	 * Returns the type of this operand.  @return the type
	 */
	public Type getType() {
		return this.type;
	}

	/**
	 * Enumeration of all available operand types.
	 */
	public enum Type {
		/**
		 * Register-type operand; class {@link Reg}.
		 */
		REG,

		/**
		 * Target operand; class {@link Target}.
		 */
		TARGET,

		/**
		 * Addr type.
		 */
		ADDR,

		/**
		 * Label type.
		 */
		LABEL

	}
}

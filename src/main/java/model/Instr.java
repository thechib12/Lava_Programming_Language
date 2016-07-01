package model;

import java.util.Iterator;

/**
 * Lava IR instruction
 *
 * @author Rogier Monshouwer
 */
public abstract class Instr implements Iterable<Op> {
	/**
	 * Label separator.
	 */
	private final static String LABEL_SEP = ": ";
	/** The line number of this instruction. */
	private int line = -1;
	/** The label of this instruction. */
	private Label label;
	/** The program in which this instruction occurs. */
	private Program prog;

	/**
	 * Returns the number of operations in this instruction.  @return the int
	 */
	public abstract int size();

	/** Returns an iterator over the operations in this instruction. */
	@Override
	public abstract Iterator<Op> iterator();

	/**
	 * Indicates if the line number of this instruction has been set.  @return the boolean
	 */
	boolean hasLine() {
		return getLine() >= 0;
	}

	/**
	 * Returns the line number of this instruction.
	 *
	 * @return the line number; {@code -1} if the line number has not been set.
	 */
	public int getLine() {
		return this.line;
	}

	/**
	 * Sets the line number of this instruction.  @param line the line
	 */
	void setLine(int line) {
		assert this.line < 0 && line >= 0;
		this.line = line;
	}

	/**
	 * Indicates if this instruction has a (non-<code>null</code>) label.  @return the boolean
	 */
	public boolean hasLabel() {
		return getLabel() != null;
	}

	/**
	 * Returns the optional label of this instruction.  @return the label
	 */
	public Label getLabel() {
		return this.label;
	}

	/**
	 * Sets the optional label of this instruction.
	 *
	 * @param label the label
	 */
	public void setLabel(Label label) {
		if (label == null) {
			throw new IllegalArgumentException("Label may not be null");
		}
		if (!(this.label == null || this.label.equals(label))) {
			throw new IllegalArgumentException("Conflicting labels '"
					+ this.label + "' and '" + label + "'");
		}
		assert this.label == null || label.equals(this.label);
		if (this.label == null) {
		this.label = label;
		if (this.prog != null) {
			this.prog.registerLabel(this);
		}
		}
	}

	/**
	 * Sets the program in which this instruction occurs.
	 *
	 * @param prog the prog
	 */
	void setProgram(Program prog) {
		assert this.prog == null & prog != null;
		this.prog = prog;
	}

	/**
	 * Returns the string representation of the optional label.  @return the string
	 */
	String toLabelString() {
		if (hasLabel()) {
			return getLabel() + LABEL_SEP;
		} else {
			return "";
		}
	}

	/**
	 * Returns a string of the form
	 * {@code label? opCode sources (arrow targets)? comment?}
	 * where the widths of the label, sources and targets parts
	 * are predetermined.
	 *
	 * @param labelSize  width of the {@code label} part
	 * @param sourceSize width of the {@code sources} part
	 * @param targetSize width of the {@code targets} part
	 * @return the string
	 */
	abstract public String prettyPrint(int labelSize, int sourceSize,
			int targetSize);

	@Override
	public int hashCode() {
		return (this.label == null) ? 0 : this.label.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Instr)) {
			return false;
		}
		Instr other = (Instr) obj;
		if (this.label == null) {
			if (other.label != null) {
				return false;
			}
		} else if (!this.label.equals(other.label)) {
			return false;
		}
		return true;
	}
}

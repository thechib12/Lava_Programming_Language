package model;

/** 
 * Class of operation: either normal or control flow.
 * @author Arend Rensink
 */
public enum OpClaz {
	/** A normal (non-control) operation. */
	NORMAL("=>"),
	/** A control operation, i.e., one that changes the PC. */
	CONTROL("->"),
	/** Special operation type holding a comment. */
	COMMENT("");

	private final String arrow;

	private OpClaz(String arrow) {
		this.arrow = arrow;
	}

	/** Returns the arrow symbol used for this operation type. */
	public String getArrow() {
		return this.arrow;
	}
}
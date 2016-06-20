package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** List of operations forming a single instruction. */
public class OpList extends Instr {
	/** The internally stored list of operations. */
	private final List<Op> opList;

	/** Constructs an operation list with an optional label. */
	public OpList() {
		this.opList = new ArrayList<>();
	}

	/** Adds an operation to this list. */
	public void addOp(Op op) {
		assert !hasLine() : "Line numer set; do not add new operations";
		this.opList.add(op);
	}

	/** Returns the list of operations. */
	public List<Op> getOps() {
		return this.opList;
	}

	@Override
	public int size() {
		return this.opList.size();
	}

	@Override
	public Iterator<Op> iterator() {
		return getOps().iterator();
	}

	@Override
	public void setLine(int line) {
		super.setLine(line);
		// also sets the line numbers of the operations in the list
		for (Op op : this) {
			op.setLine(line);
			line++;
		}
	}

	/** Returns a string consisting of this operation list in a nice layout.
	 * @param indent the number of columns by which the string should be indented.
	 * All lines except the first will be indented by this number of spaces. 
	 */
	@Override
	public String prettyPrint(int labelSize, int sourceSize, int targetSize) {
		StringBuilder result = new StringBuilder();
		result.append(String.format("%-" + labelSize + "s", toLabelString()));
		result.append(LIST_PREFIX);
		for (Op op : getOps()) {
			sourceSize = Math.max(sourceSize, op.toSourceString().length());
			targetSize = Math.max(targetSize, op.toTargetString().length());
		}
		int innerLabelSize = 0;
		for (Op op : getOps()) {
			result.append(op
					.prettyPrint(innerLabelSize, sourceSize, targetSize));
			innerLabelSize = labelSize + LIST_PREFIX.length();
		}
		result.append(String.format("%-" + labelSize + "s" + LIST_POSTFIX, ""));
		result.append('\n');
		return result.toString();
	}

	@Override
	public String toString() {
		return toLabelString() + this.opList.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + this.opList.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj)) {
			return false;
		}
		OpList other = (OpList) obj;
		if (!this.opList.equals(other.opList)) {
			return false;
		}
		return true;
	}

	private final static String LIST_PREFIX = "[   ";
	private final static String LIST_POSTFIX = "]";
}

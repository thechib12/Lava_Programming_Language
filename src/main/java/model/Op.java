package model;

import model.Operand.Type;

import java.util.*;


/**
 * Lava operation
 *
 * @author Rogier Monshouwer
 */
public class Op extends Instr {
	/** Comment separator. */
	private final static String COMMENT_SEP = "// ";
	/** Operand separator. */
	private final static String OP_SEP = ",";

	/** The operation code. */
	private final OpCode opCode;
	/** The list of arguments of this operation. */
	private final List<Operand> args;
	/** The optional comment for this operation. */
	private String comment;

    /**
     * Constructs an unlabelled operation with a given opcode and arguments.  @param opCode the op code
     *
     * @param args the args
     */
    public Op(OpCode opCode, Operand... args) {
		this(null, opCode, args);
    }

    /**
     * Constructs an unlabelled operation with a given opcode and arguments.  @param opCode the op code
     *
     * @param args the args
     */
	public Op(OpCode opCode, List<Operand> args) {
		this(null, opCode, args);
    }

    /**
     * Constructs a labelled operation with a given opcode and arguments.  @param label the label
     *
     * @param opCode the op code
     * @param args   the args
     */
	public Op(Label label, OpCode opCode, Operand... args) {
		this(label, opCode, Arrays.asList(args));
    }

    /**
     * Constructs a labelled operation with a given opcode and arguments.
     *
     * @param label  the label
     * @param opCode the op code
     * @param args   the args
     * @throws IllegalArgumentException if one of the arguments is not of the expected type
     */
	public Op(Label label, OpCode opCode, List<Operand> args)
			throws IllegalArgumentException {
		if (label != null) {
			super.setLabel(label);
		}
		this.opCode = opCode;
		int argsCount = opCode.getSigSize();
		if (args.size() != argsCount) {
			throw new IllegalArgumentException(String.format(
					"Operation '%s' expects %d arguments but has %d", opCode,
					argsCount, args.size()));
		}
		for (int i = 0; i < argsCount; i++) {
			Operand arg = args.get(i);
			Type expected = opCode.getSig().get(i);
			if (arg.getType() != expected) {
				throw new IllegalArgumentException(
						String.format(
								"Operation '%s' argument %d should be '%s' but is '%s'",
								this.opCode, i, expected, arg.getType()));
			}
		}
		this.args = new ArrayList<>(args);
    }


    /**
     * Returns the opcode of this operation.
     * @return the op code
     */
	public OpCode getOpCode() {
		return this.opCode;
    }

    /**
     * Returns the list of all (source + target) arguments.  @return the args
     */
	public List<Operand> getArgs() {
		return this.args;
    }

    /**
     * Convenience method to retrieve a given argument as {@link Reg}.  @param i the
     *
     * @return the reg
     */
	public Reg reg(int i) {
		return (Reg) this.args.get(i);
    }

    /**
     * Convenience method to retrieve a given argument as {@link Address}.  @param i the
     *
     * @return the address
     */
    public Address addr(int i) {
        return (Address) this.args.get(i);
    }

    /**
     * Convenience method to retrieve a given argument as {@link Target}.  @param i the
     *
     * @return the target
     */
    public Target target(int i){
        return (Target) this.args.get(i);
    }


    /**
     * Convenience method to retrieve a given operand as {@link Label}.  @param i the
     *
	 * @return the label
	 */
	public Label label(int i) {
		return (Label) this.args.get(i);
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public Iterator<Op> iterator() {
		return Collections.singleton(this).iterator();
	}

	@Override
	public String prettyPrint(int labelSize, int sourceSize, int targetSize) {
		StringBuilder result = new StringBuilder();
		if (labelSize > 0) {
			result.append(String
					.format("%-" + labelSize + "s", toLabelString()));
		}
		int arrowSize = 4;
//		if (getOpCode() == OpCode.out) {
//			int size = sourceSize + targetSize + arrowSize;
//			result.append(String.format("%-8s", getOpCode().name()));
//			result.append(String.format("%-" + size + "s ", toSourceString()));
//			result.append(toCommentString());
//		} else {
        result.append(String.format("%-8s", getOpCode().name()));
        if (sourceSize > 0) {
            result.append(String.format("%-" + sourceSize + "s",
                    toSourceString()));
        }
        if (targetSize > 0) {
            result.append(String.format("%-" + targetSize + "s ",
                    toTargetString()));
        }
//		}
		result.append('\n');
		return result.toString();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(toLabelString());
			result.append(getOpCode());
			if (getOpCode().getSourceCount() > 0) {
				result.append(' ');
				result.append(toSourceString());
			}
			if (getOpCode().getTargetCount() > 0) {
				result.append(' ');
				result.append(' ');
				result.append(toTargetString());
			}
			result.append(' ');
		return result.toString();
	}


	/** Returns the string representation of the optional comment. */

    /**
     * Returns the string representation of the source operands.  @return the string
     */
	String toSourceString() {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for (int i = 0; i < getOpCode().getSourceCount(); i++) {
			Operand o = getArgs().get(i);
			if (first) {
				first = false;
			} else {
				result.append(OP_SEP);
			}
			result.append(o);
        }
        return result.toString();
    }

    /**
     * Returns the string representation of the target operands.  @return the string
     */
	String toTargetString() {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for (int i = getOpCode().getSourceCount(); i < getOpCode()
				.getSigSize(); i++) {
			Operand o = getArgs().get(i);
			if (first) {
				first = false;
			} else {
				result.append(OP_SEP);
			}
			result.append(o);
		}
		return result.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + super.hashCode();
		result = prime * result
				+ ((this.comment == null) ? 0 : this.comment.hashCode());
		result = prime * result + this.opCode.hashCode();
		result = prime * result + this.args.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		Op other = (Op) obj;
		if (this.opCode != other.opCode) {
			return false;
		}
		if (!this.args.equals(other.args)) {
			return false;
		}
		return true;
	}
}

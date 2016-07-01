package model;

import java.util.*;

import static model.Operand.Type.*;

/**
 * The enum Op code.
 */
public enum OpCode {

	//Operators
	/**
	 * r0 + r1 => r2
	 */
	Add(2, REG, REG, REG),
	/**
	 * r0 - r1 => r2
	 */
	Sub(2, REG, REG, REG),
	/**
	 * r0 * r1 => r2
	 */
	Mul(2, REG, REG, REG),
	/**
	 * r0 == r1 => r2
	 */
	Equal(2, REG, REG, REG),
	/**
	 * r0 != r1 => r2
	 */
	NEQ(2, REG, REG, REG),
	/**
	 * r0 > r1 => r2
	 */
	Gt(2, REG, REG, REG),
	/**
	 * r0 >= r1 => r2
	 */
	GtE(2, REG, REG, REG),
	/**
	 * r0 < r1 => r2
	 */
	Lt(2, REG, REG, REG),
	/**
	 * r0 <= r1 => r2
	 */
	LtE(2, REG, REG, REG),
	/**
	 * r0 && r1 => r2
	 */
	And(2, REG, REG, REG),
	/**
	 * r0 || r1 => r2
	 */
	Or(2, REG, REG, REG),
	/**
	 * r0 xor r1 => r2
	 */
	Xor(2, REG, REG, REG),
	/**
	 * r0 shiftleft r1 => r2
	 */
	LShift(2, REG, REG, REG),
	/**
	 * r0 shiftright r1 => r2
	 */
	RShift(2, REG, REG, REG),

	/**
	 * The Load d.
	 */
//Load from address a1, store at a2
	LoadD(1, ADDR, REG),
	/**
	 * Load ind op code.
	 */
	LoadInd(1, ADDR, REG),
	/**
	 * The Load im.
	 */
//Load Immediate value from address a1, store at a2
	LoadIm(1, ADDR, REG),
	/**
	 * Store d op code.
	 */
	StoreD(1, REG, ADDR),
	/**
	 * Store ind op code.
	 */
	StoreInd(1, REG, ADDR),
	/**
	 * 2 i op code.
	 */
	I2I(1, REG, REG),

	/**
	 * Branch op code.
	 */
	Branch(1, REG, LABEL),
	/**
	 * Branch i op code.
	 */
	BranchI(1, REG, TARGET),

	/**
	 * Jump i op code.
	 */
	Jump(0, TARGET),
	/**
	 * Push op code.
	 */
	Push(1, REG),
	/**
	 * Pop op code.
	 */
	Pop(0, REG),
	/**
	 * Incr sp op code.
	 */
	IncrSP(0),
	/**
	 * Decr sp op code.
	 */
	DecrSP(0),
	/**
	 * Nop op code.
	 */
	Nop(0),
	/**
	 * End prog op code.
	 */
	EndProg(0),


	/**
	 * The Read d.
	 */
//System instructions
	ReadD(1, ADDR),
	/**
	 * Read ind op code.
	 */
	ReadInd(1, ADDR),
	/**
	 * Receive op code.
	 */
	Receive(0, REG),
	/**
	 * Write d op code.
	 */
	WriteD(1, REG, ADDR),
	/**
	 * Write ind op code.
	 */
	WriteInd(1, REG, ADDR),
	/**
	 * Test and set d op code.
	 */
	TestAndSetD(1, ADDR),
	/**
	 * Test and set ind op code.
	 */
	TestAndSetInd(1, ADDR);

	private static final Map<String, OpCode> codeMap = new HashMap<>();

	static {
		for (OpCode op : values()) {
			codeMap.put(op.name(), op);
		}
	}

	/** The source operand types. */
	private final List<Operand.Type> sourceSig;
    /**
     * The target operand types.
     */
    private final List<Operand.Type> targetSig;
    /**
     * The operand types.
     */
    private final List<Operand.Type> sig;

	/** Returns the class of this opcode (normal or control flow). */
	/**
	 * Sourcecount
     */
    private final int sourceCount;

	OpCode(int sourceCount, Operand.Type... sig) {
		this.sourceCount = sourceCount;

		this.sourceSig = new ArrayList<>(sourceCount);
		for (int i = 0; i < sourceCount; i++) {
			this.sourceSig.add(sig[i]);
		}
		this.targetSig = new ArrayList<>(sig.length - sourceCount);
		for (int i = sourceCount; i < sig.length; i++) {
			this.targetSig.add(sig[i]);
		}
		this.sig = new ArrayList<>(Arrays.asList(sig));
	}

	/**
	 * Returns the {@link OpCode} for a given string, if any.  @param code the code
	 *
	 * @return the op code
	 */
	public static OpCode parse(String code) {
		return codeMap.get(code);
	}

	/**
	 * Returns the number of operands.  @return the sig size
	 */
	public int getSigSize() {
		return getSourceCount() + getTargetCount();
	}

	/**
	 * Returns the list of expected operand types.  @return the sig
	 */
	public List<Operand.Type> getSig() {
		return this.sig;
	}

	/**
	 * Returns the number of source operands.  @return the source count
	 */
	public int getSourceCount() {
		return getSourceSig().size();
	}

	/**
	 * Returns the list of expected source operand types.  @return the source sig
	 */
	public List<Operand.Type> getSourceSig() {
		return this.sourceSig;
	}

	/**
	 * Returns the number of target operands.  @return the target count
	 */
	public int getTargetCount() {
		return getTargetSig().size();
	}

	/**
	 * Returns the list of expected target operand types.  @return the target sig
	 */
	public List<Operand.Type> getTargetSig() {
		return this.targetSig;
	}
}

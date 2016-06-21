package model;

import java.util.*;

import static model.Operand.Type.*;

public enum OpCode {

	//Operators
	/**
	 * r0 + r1 => r2
	 */
	Add(2, REG, REG, REG),
	/** r0 - r1 => r2 */
	Sub(2, REG, REG, REG),
	/** r0 * r1 => r2 */
	Mul(2, REG, REG, REG),
	/** r0 == r1 => r2 */
	Equal(2, REG, REG, REG),
	/** r0 != r1 => r2 */
	NEQ(2, REG, REG, REG),
	/** r0 > r1 => r2 */
	Gt(2, REG, REG, REG),
	/** r0 >= r1 => r2 */
	GtE(2, REG, REG, REG),
	/** r0 < r1 => r2 */
	Lt(2, REG, REG, REG),
	/** r0 <= r1 => r2 */
	LtE(2, REG, REG, REG),
	/** r0 && r1 => r2 */
	And(2, REG, REG, REG),
	/** r0 || r1 => r2 */
	Or(2, REG, REG, REG),
	/** r0 xor r1 => r2 */
	Xor(2, REG, REG, REG),
	/** r0 shiftleft r1 => r2 */
	LShift(2, REG, REG, REG),
	/** r0 shiftright r1 => r2 */
	RShift(2, REG, REG, REG),

	//Load from address a1, store at a2
	LoadD(1, ADDR, REG),
	LoadInd(1, ADDR, REG),
	//Load Immediate value from address a1, store at a2
	LoadIm(1, ADDR, REG),
	StoreD(1, REG, ADDR),
	StoreInd(1, REG, ADDR),

	Branch(1, REG, LABEL),
	BranchI(1, REG, TARGET),
	Jump(0, LABEL),
	JumpI(0,TARGET),
	Push(1, REG),
	Pop(0, REG),
	Nop(0),
	EndProg(0),


	//System instructions
	ReadD(1, ADDR),
	ReadInd(1, ADDR),
	Receive(0, REG),
	WriteD(1, REG, ADDR),
	WriteInd(1, REG, ADDR),
	TestAndSetD(1, ADDR),
	TestAndSetInd(1, ADDR);

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

    /**
     * Sourcecount
     */
    private final int sourceCount;

	private OpCode(int sourceCount, Operand.Type... sig) {
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

	/** Returns the class of this opcode (normal or control flow). */


	/** Returns the number of operands. */
	public int getSigSize() {
		return getSourceCount() + getTargetCount();
	}

	/** Returns the list of expected operand types. */
	public List<Operand.Type> getSig() {
		return this.sig;
	}

	/** Returns the number of source operands. */
	public int getSourceCount() {
		return getSourceSig().size();
	}

	/** Returns the list of expected source operand types. */
	public List<Operand.Type> getSourceSig() {
		return this.sourceSig;
	}

	/** Returns the number of target operands. */
	public int getTargetCount() {
		return getTargetSig().size();
	}

	/** Returns the list of expected target operand types. */
	public List<Operand.Type> getTargetSig() {
		return this.targetSig;
	}

	/** Returns the {@link OpCode} for a given string, if any. */
	public static OpCode parse(String code) {
		return codeMap.get(code);
	}

	private static final Map<String, OpCode> codeMap = new HashMap<>();
	static {
		for (OpCode op : values()) {
				codeMap.put(op.name(), op);
		}
	}
}

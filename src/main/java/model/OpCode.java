package model;

import java.util.*;

import static model.Operand.Type.*;

/**
 * Code defining the type of a (non-control flow) operation.
 * @author Arend Rensink
 */
public enum OpCode {
	// Placeholder
	/** Placeholder (no operation). */
	nop(0),

	// Register arithmetic
	/** Addition (reg0 + reg1 => reg2). */
	add(2, REG, REG, REG),
	/** Subtraction (reg0 - reg1 => reg2). */
	sub(2, REG, REG, REG),
	/** Multiplication (reg0 * reg1 => reg2). */
	mult(2, REG, REG, REG),
	/** Division (reg0 / reg1 => reg2). */
	div(2, REG, REG, REG),

	// Immediate arithmetic
	/** Addition of immediate value (reg0 + num1 => reg2). */


	// Other bitwise operations
	/** Bitwise OR (reg0 | reg1 => reg2). */
	or(2, REG, REG, REG),
	/** Bitwise AND (reg0 & reg1 => reg2). */
	and(2, REG, REG, REG),
	/** Bitwise XOR (reg0 ^ reg1 => reg2). */
	xor(2, REG, REG, REG),
	/** Bitwise XOR with immediate value (reg0 ^ num1 => reg2). */

	// Memory operations
	/** Load immediate (num0 => reg1). */
	loadI(1, NUM, REG),
	/** Load (mem(reg0) => reg1). */
	load(1, REG, REG),
	/** Load address + immediate (mem(reg0 + num1) => reg2). */
	loadAI(2, REG, NUM, REG),
	/** Load address + offset (mem(reg0 + reg1) => reg2). */
	loadAO(2, REG, REG, REG),
	/** Character load (mem(reg0) => reg1). */
	cload(1, REG, REG),
	/** Character load address + immediate (mem(reg0 + num1) => reg1). */
	cloadAI(2, REG, NUM, REG),
	/** Character load address + offset (mem(reg0 + reg1) => reg2). */
	cloadAO(2, REG, REG, REG),
	/** Store (reg0 => mem(reg1)). */
	store(1, REG, REG),
	/** Store (reg0 => mem(reg1 + num2)). */
	storeAI(1, REG, REG, NUM),
	/** Store (reg0 => mem(reg1 + reg2)). */
	storeAO(1, REG, REG, REG),
	/** Character store (reg0 => mem(reg)). */
	cstore(1, REG, REG),
	/** Character store (reg0 => mem(reg1 + num2)). */
	cstoreAI(1, REG, REG, NUM),
	/** Character store (reg0 => mem(reg1 + reg2)). */
	cstoreAO(1, REG, REG, REG),

	// Copy operations
	/** Integer-to-integer copy (reg0 => reg1). */
	i2i(1, REG, REG),
	/** Character-to-character copy (reg0 => reg1). */
	c2c(1, REG, REG),
	/** Character-to-integer conversion (reg0 => reg1). */
	c2i(1, REG, REG),
	/** Integer-to-character conversion (reg0 => reg1). */
	i2c(1, REG, REG),

	// Comparison operations
	/** Less-than comparison (reg0 < reg1 => reg2). */
	cmp_LT(2, REG, REG, REG),
	/** Less-or-equal comparison (reg0 <= reg1 => reg2). */
	cmp_LE(2, REG, REG, REG),
	/** Equals comparison (reg0 == reg1 => reg2). */
	cmp_EQ(2, REG, REG, REG),
	/** Greater-or-equal comparison (reg0 >= reg1 => reg2). */
	cmp_GE(2, REG, REG, REG),
	/** Greater-than comparison (reg0 > reg1 => reg2). */
	cmp_GT(2, REG, REG, REG),
	/** Not-equals comparison (reg0 != reg1 => reg2). */
	cmp_NE(2, REG, REG, REG),

	// Jump operations
	/** Conditional branch (reg0 != 0 ? #label0 : #label1 => pc). */
	cbr(CONTROL, 1, REG, LABEL, LABEL),
	/** Immediate jump (#label0 => pc). */
	jumpI(CONTROL, 0, LABEL),
	/** Register jump (mem(reg0) => pc). */
	jump(CONTROL, 0, REG),
	/** Pseudo-op to record labels of a register jump. */
	tbl(2, REG, LABEL),

	// Extra ops for stack manipulation
	/** Push the (4-byte integer) value of a register onto the stack. 
	 * Not official ILOC. */
	push(1, REG),
	/** Pop the (4-byte integer) stack top into a register.
	 * Not official ILOC. */
	pop(0, REG),
	/** Push the (1-byte character) value of a register onto the stack. 
	 * Not official ILOC. */
	cpush(1, REG),
	/** Pop the (1-byte character) stack top into a register.
	 * Not official ILOC. */
	cpop(0, REG),
	// Extra ops for simulation and debugging
	/** Value input (str0 => stdout and stdin => reg1).
	 * Not official ILOC. */
	in(1, STR, REG),
	/** Value output (str0 + reg1 => stdout).
	 * Not official ILOC. */
	out(2, STR, REG),
	/** String input (str0 => stdout and stdin => stack).
	 * The string is represented as length + chars (first char on top).
	 * Not official ILOC. */
	cin(1, STR),
	/** Value output (str0 + stack => stdout).
	 * The string is represented as length + chars (first char on top).
	 * Not official ILOC. */
	cout(1, STR),
	/** Stand-alone program comment; effect = nop.
	 * Not official ILOC. */
	comment(COMMENT, 0);


	/** The class that this opcode falls into. */
	private final OpClaz claz;

	/** The source operand types. */
	private final List<Operand.Type> sourceSig;

	/** The target operand types. */
	private final List<Operand.Type> targetSig;

	/** The operand types. */
	private final List<Operand.Type> sig;

	private OpCode(int sourceCount, Operand.Type... sig) {
		this(NORMAL, sourceCount, sig);
	}

	private OpCode(OpClaz claz, int sourceCount, Operand.Type... sig) {
		this.claz = claz;
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
	public OpClaz getClaz() {
		return this.claz;
	}

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
			if (op.getClaz() != COMMENT) {
				codeMap.put(op.name(), op);
			}
		}
	}
}

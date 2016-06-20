package model;

import java.util.*;

import static model.OpClaz.COMMENT;
import static model.OpClaz.CONTROL;
import static model.OpClaz.NORMAL;
import static model.Operand.Type.*;

/**
 * Code defining the type of a (non-control flow) operation.
 * @author Arend Rensink
 */
public enum OpCode {

//	Add	Add
//	Sub	Subtract
//	Mul	Multiply
//	Div*	Divide
//	Mod*	Modulo
//	Equal	Equals
//	NEq	Not equals
//	Gt	Greater than
//	GtE	Greater than or equal to
//	Lt	Lesser than
//	LtE	Lesser than or equal to
//	And	Bitwise AND
//	Or	Bitwise OR
//	Xor	Bitwise XOR
//	LShift	Left shift
//	RShift	Right shift
	// Placeholder

	//Operators
	Add(REG, REG, REG),
	Sub(REG, REG, REG),
	Mul(REG, REG, REG),
	Equal(REG, REG, REG),
	NEQ(REG, REG, REG),
	Gt(REG, REG, REG),
	GtE(REG, REG, REG),
	Lt(REG, REG, REG),
	LtE(REG, REG, REG),
	And(REG, REG, REG),
	Or(REG, REG, REG),
	Xor(REG, REG, REG),
	LShift(REG, REG, REG),
	RShift(REG, REG, REG),

	//load
	LoadD(ADDR, REG),
	LoadInd(ADDR, REG),
	LoadIm(ADDR, REG),
	StoreD(REG, ADDR),
	StoreInd(REG, ADDR),

	Branch(REG, TARGET),
	Jump(TARGET),
	Push(REG),
	Pop(REG),
	Nop(),
	EndProg(),


	//System instructions
	ReadD(ADDR),
	ReadInd(ADDR),
	Receive(REG),
	WriteD(REG, ADDR),
	WriteInd(REG, ADDR),
	TestAndSetD(ADDR),
	TestAndSetInd(ADDR);

	//const


	/** The class that this opcode falls into. */

	/** The source operand types. */
//	private final List<Operand.Type> sourceSig;
//
//	/** The target operand types. */
//	private final List<Operand.Type> targetSig;
//
//	/** The operand types. */
//	private final List<Operand.Type> sig;
	private OpCode(Operand.Type... sig) {
//		this.sourceSig = new ArrayList<>(sourceCount);
//		for (int i = 0; i < sourceCount; i++) {
//			this.sourceSig.add(sig[i]);
//		}
//		this.targetSig = new ArrayList<>(sig.length - sourceCount);
//		for (int i = sourceCount; i < sig.length; i++) {
//			this.targetSig.add(sig[i]);
//		}
//		this.sig = new ArrayList<>(Arrays.asList(sig));
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

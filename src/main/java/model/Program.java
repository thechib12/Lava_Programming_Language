package model;


import java.util.*;

import static model.Num.NumKind.SYMB;
import static model.Operand.Type.REG;

/** ILOC program.
 * @author Arend Rensink
 */
public class Program {
	/** Indexed list of all instructions in the program. */
	private final List<Instr> instrList;
	/**
	 * Indexed list of all operations in the program.
	 * This is the flattened list of instructions.
	 */
	private final List<Op> opList;
	/** Mapping from labels defined in the program to corresponding
	 * index locations.
	 */
	/** (Partial) mapping from symbolic constants used in the program
	 * to corresponding numeric values. */
	private final Map<Num, Integer> symbMap;

	/** Creates a program with an initially empty instruction list. */
	public Program() {
		this.instrList = new ArrayList<>();
		this.opList = new ArrayList<>();
		this.symbMap = new LinkedHashMap<>();
	}

	/** Adds an instruction to the instruction list of this program.
	 * @throws IllegalArgumentException if the instruction has a known label 
	 */
	public void addInstr(Instr instr) {
		instr.setProgram(this);
		instr.setLine(this.opList.size());
		this.instrList.add(instr);
		for (Op op : instr) {
			this.opList.add(op);
		}
	}

	/** Returns the current list of instructions of this program. */
	public List<Instr> getInstr() {
		return Collections.unmodifiableList(this.instrList);
	}

	/** Returns the operation at a given line number. */
	public Op getOpAt(int line) {
		return this.opList.get(line);
	}

	/** Returns the size of the program, in number of operations. */
	public int size() {
		return this.opList.size();
	}


	/** Assigns a fixed numeric value to a symbolic constant.
	 * It is an error to assign to the same constant twice.
	 * @param symb constant name, without preceding '@'
	 */
	public void setSymb(Num symb, int value) {
		if (this.symbMap.containsKey(symb)) {
			throw new IllegalArgumentException("Constant '" + symb
					+ "' already assigned");
		}
		this.symbMap.put(symb, value);
	}

	/** 
	 * Returns the value with which a given symbol has been
	 * initialised, if any.
	 */
	public Integer getSymb(Num symb) {
		return this.symbMap.get(symb);
	}

	/** 
	 * Returns the value with which a given named symbol has been
	 * initialised, if any.
	 * @param name name of the symbol, without '@'-prefix
	 */
	public Integer getSymb(String name) {
		return getSymb(new Num(name));
	}

	/**
	 * Checks for internal consistency, in particular whether
	 * all used labels are defined.
	 */
	public void check() throws FormatException {
		List<String> messages = new ArrayList<>();
		if (!messages.isEmpty()) {
			throw new FormatException(messages);
		}
	}


	/**
	 * Returns a mapping from registers to line numbers
	 * in which they appear.
	 */
	public Map<String, Set<Integer>> getRegLines() {
		Map<String, Set<Integer>> result = new LinkedHashMap<>();
		for (Op op : this.opList) {
			for (Operand opnd : op.getArgs()) {
				if (opnd.getType() == REG) {
					Set<Integer> ops = result.get(((Reg) opnd).getName());
					if (ops == null) {
						result.put(((Reg) opnd).getName(),
								ops = new LinkedHashSet<>());
					}
					ops.add(op.getLine());
				}
			}
		}
		return result;
	}

	/**
	 * Returns a mapping from (symbolic) variables to line numbers
	 * in which they appear.
	 */
	public Map<String, Set<Integer>> getSymbLines() {
		Map<String, Set<Integer>> result = new LinkedHashMap<>();
		for (Op op : this.opList) {
			for (Operand opnd : op.getArgs()) {
				if (!(opnd instanceof Num)) {
					continue;
				}
				if (((Num) opnd).getKind() != SYMB) {
					continue;
				}
				String name = ((Num) opnd).getName();
				Set<Integer> lines = result.get(name);
				if (lines == null) {
					result.put(name, lines = new LinkedHashSet<>());
				}
				lines.add(op.getLine());
			}
		}
		return result;
	}

	/** Returns a line-by-line printout of this program. */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Map.Entry<Num, Integer> symbEntry : this.symbMap.entrySet()) {
			result.append(String.format("%s <- %d%n", symbEntry.getKey()
					.getName(), symbEntry.getValue()));
		}
		for (Instr instr : getInstr()) {
			result.append(instr.toString());
			result.append('\n');
		}
		return result.toString();
	}

	@Override
	public int hashCode() {
		return this.instrList.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Program)) {
			return false;
		}
		Program other = (Program) obj;
		if (!this.instrList.equals(other.instrList)) {
			return false;
		}
		return true;
	}

	/** Returns a string consisting of this program in a nice layout.
	 */
	public String prettyPrint() {
		StringBuilder result = new StringBuilder();
		// first print the symbolic declaration map
		int idSize = 0;
		for (Num symb : this.symbMap.keySet()) {
			idSize = Math.max(idSize, symb.getName().length());
		}
		for (Map.Entry<Num, Integer> symbEntry : this.symbMap.entrySet()) {
			result.append(String.format("%-" + idSize + "s <- %d%n", symbEntry
					.getKey().getName(), symbEntry.getValue()));
		}
		if (idSize > 0) {
			result.append('\n');
		}
		// then print the instructions
		int labelSize = 0;
		int sourceSize = 0;
		int targetSize = 0;
		for (Instr i : getInstr()) {
			if (i instanceof Op) {
				Op op = (Op) i;
				sourceSize = Math.max(sourceSize, op.toSourceString().length());
				targetSize = Math.max(targetSize, op.toTargetString().length());
			}
		}
		for (Instr i : getInstr()) {
			result.append(i.prettyPrint(labelSize, sourceSize, targetSize));
		}
		return result.toString();
	}
}

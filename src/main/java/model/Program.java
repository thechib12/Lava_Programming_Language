package model;


import elaboration.ParseException;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import static model.Operand.Type.REG;

/**
 * Lava Intermediate Representation program class.
 *
 * @author Rogier Monshouwer
 */
public class Program {

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
	private final Map<Label, Integer> labelMap;

	/**
	 * Creates a program with an initially empty instruction list.
	 */
	public Program() {
		this.opList = new ArrayList<>();
        this.labelMap = new LinkedHashMap<>();
	}

	/**
	 * Adds an instruction to the instruction list of this program.
	 *
	 * @param instr the instr
	 * @throws IllegalArgumentException if the instruction has a known label
	 */
	public void addInstr(Instr instr) {
		instr.setProgram(this);
		instr.setLine(this.opList.size());
        if (instr.hasLabel()) {
            registerLabel(instr);
        }
		for (Op op : instr) {
			this.opList.add(op);
		}
	}


	/**
     * Registers the label of a given instruction.
     * @param instr the instr
     */
    void registerLabel(Instr instr) {
		Label label = instr.getLabel();
        Integer loc = this.labelMap.get(label);
        if (loc != null) {
            throw new IllegalArgumentException(String.format(
                    "Label %s already occurred at location %d", label, loc));
        }
        this.labelMap.put(label, instr.getLine());
	}

	/**
	 * Returns the location at which a given label is defined, if any.
	 *
	 * @param label the label
	 * @return the location of an instruction with the label, or {@code -1} if the label is undefined
	 */
	public int getLine(Label label) {
		Integer result = this.labelMap.get(label);
        return result == null ? -1 : result;
	}

	/**
	 * Returns the operation at a given line number.  @param line the line
	 *
	 * @return the op at
	 */
	public Op getOpAt(int line) {
		return this.opList.get(line);
	}

	/**
	 * Returns the size of the program, in number of operations.  @return the int
	 */
	public int size() {
		return this.opList.size();
	}


	/**
	 * Checks for internal consistency, in particular whether
	 * all used labels are defined.
	 *
     * @throws ParseException the format exception
     */
    public void check() throws ParseException {
        List<String> messages = new ArrayList<>();
        for (Instr instr : getOpList()) {
            for (Op op : instr) {
                messages.addAll(checkOpnds(op.getLine(), op.getArgs()));
            }
        }
        if (!messages.isEmpty()) {
            throw new ParseException(messages);
        }
    }

    private List<String> checkOpnds(int loc, List<Operand> opnds) {
        List<String> result = new ArrayList<>();
        for (Operand opnd : opnds) {
            if (opnd instanceof Label) {
                if (getLine((Label) opnd) < 0) {
                    result.add(String.format("Line %d: Undefined label '%s'",
                            loc, opnd));
                }
            }
        }
		return result;
	}


	/**
	 * Gets registers.
	 *
	 * @return the registers
	 */
	public List<String> getRegisters() {
		CopyOnWriteArrayList<String> registers = new CopyOnWriteArrayList<>();
        for (Op op : this.getOpList()) {
            for (Operand operand : op.getArgs()) {
                if (operand.getType() == REG) {
                    registers.addIfAbsent(((Reg) operand).getName());
                }
            }
        }
        return new ArrayList<>(registers);
    }


	/**
	 * Returns a mapping from registers to line numbers
	 * in which they appear.
	 *
	 * @return the reg lines
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


	/** Returns a line-by-line printout of this program. */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Instr instr : getOpList()) {
			result.append(instr.toString());
			result.append('\n');
		}
		return result.toString();
	}

	/**
	 * Gets op list.
	 *
	 * @return the op list
	 */
	public List<Op> getOpList() {
		return Collections.unmodifiableList(opList);
    }

    @Override
	public int hashCode() {
		return this.opList.hashCode();
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
        return this.opList.equals(other.opList);
    }


}

package model;

/**
 * Register operand
 *
 * @author Christiaan van den Bogaard.
 */
public class Reg extends Operand {
    private String name;

	/**
	 * Constructs an operand with a given name.  @param name the name
	 */
	public Reg(String name) {
		super(Type.REG);
		assert name != null && name.length() > 1 : "Register names must be non-empty strings";
		this.name = name;
	}

	/**
	 * Returns the name of this register.  @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets name.
	 *
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
    }

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public int hashCode() {
		return getName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Reg)) {
			return false;
		}
		Reg other = (Reg) obj;
		return getName().equals(other.getName());
	}
}
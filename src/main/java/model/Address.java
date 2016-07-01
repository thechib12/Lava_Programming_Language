package model;

/**
 * Created by Rogier on 20-06-16 in Enschede.
 * Address Operand.
 */
public class Address extends Operand {
    /**
     * Haskell prefix for the code generation represented as an Enum.
     */
    private AddressType prefix;
    /** Register which contains the memory address. */
    private Reg register;
    /** Value representing the memory address or an immediate value depending on the prefix. */
    private int value;
    /**
     * Label which will translate to an instruction line.
     */
    private Label label;

    /**
     * Creates an Address with a type and a register to point to.
     *
     * @param type     type should be {@link AddressType} IndAddr.
     * @param register register containing the memory address.
     */
    public Address(AddressType type, Reg register) {
        super(Type.ADDR);
        assert type == AddressType.IndAddr;
        this.prefix = type;
        this.register = register;
        this.value = -1;
        this.label = null;
    }

    /**
     * Creates an Address object with a type and an integer, which represent a memory location or
     * an immediate value depending on the type
     *
     * @param type  type should be ImmValue or DirAddr.
     * @param value integer value.
     */
    public Address(AddressType type, int value) {
        super(Type.ADDR);
        assert type == AddressType.ImmValue || type == AddressType.DirAddr;
        this.prefix = type;
        this.value = value;
        this.register = null;
        this.label = null;
    }


    /**
     * Instantiates a new Address with an label. This will translate to a program line.
     * This is an convenience method to load return addresses into memory.
     *
     * @param type  the type
     * @param label the label
     */
    public Address(AddressType type, Label label) {
        super(Type.ADDR);
        this.prefix = type;
        this.value = -1;
        this.register = null;
        this.label = label;
    }

    @Override
    public String toString() {
        if (label != null) {
            return prefix + " " + label.toString();
        }


        if (value != -1) {
            return prefix + " " + value;
        }

        if (register != null) {
            return prefix + " " + register;
        }

        return super.toString();
    }

    /**
     * Gets prefix.
     *
     * @return the prefix
     */
    public AddressType getPrefix() {
        return prefix;
    }

    /**
     * Gets label.
     *
     * @return the label
     */
    public Label getLabel() {
        return label;
    }

    /**
     * Enum containing the various address types.
     */
    public enum AddressType {
        /**
         * Imm value lab address type.
         */
        ImmValueLab,
        /**
         * Ind addr address type.
         */
        IndAddr,
        /**
         * Imm value address type.
         */
        ImmValue,
        /**
         * Dir addr address type.
         */
        DirAddr
    }
}

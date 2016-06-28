package model;

/**
 * Created by Rogier on 20-06-16 in Enschede.
 * Address Operand.
 */
public class Addr extends Operand {
    /**
     * Haskell prefix for the code generation represented as an Enum
     */
    private AddrType prefix;
    /** Register which contains the memory address. */
    private Reg register;
    /** Value representing the memory address or an immediate value depending on the prefix. */
    private int value;

    private Label label;

    /**
     * Creates an Addr with a type and a register to point to.
     * @param type type should be {@link AddrType} IndAddr.
     * @param register register containing the memory address.
     */
    public Addr(AddrType type, Reg register){
        super(Type.ADDR);
        assert type == AddrType.IndAddr;
        this.prefix = type;
        this.register = register;
        this.value = -1;
        this.label = null;
    }

    /**
     * Creates an Addr object with a type and an integer, which represent a memory location or
     * an immediate value depending on the type
     * @param type type should be ImmValue or DirAddr.
     * @param value integer value.
     */
    public Addr(AddrType type,int value){
        super(Type.ADDR);
        assert type == AddrType.ImmValue || type == AddrType.DirAddr;
        this.prefix = type;
        this.value = value;
        this.register = null;
        this.label = null;
    }


    public Addr(AddrType type, Label label) {
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

    public AddrType getPrefix() {
        return prefix;
    }

    public Label getLabel() {
        return label;
    }

    /**
     * Enum containing the various address types.
     */
    public enum AddrType {
        ImmValueLab,
        IndAddr,
        ImmValue,
        DirAddr
    }
}

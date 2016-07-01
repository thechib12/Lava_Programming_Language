package model;

import static model.Target.TargetType.*;

/**
 * Created by Rogier on 20-06-16 in Enschede.
 */
public class Target extends Operand {
    private final TargetType prefix;
    private final Reg register;
    private final int value;
    private final Label label;


    /**
     * Instantiates a new Target.
     *
     * @param label the label
     */
    public Target(Label label) {
        super(Type.TARGET);
        prefix = Abs;
        this.label = label;
        value = -1;
        register = null;
    }

    /**
     * Instantiates a new Target.
     *
     * @param type  the type
     * @param value the value
     */
    public Target(TargetType type, int value) {
        super(Type.TARGET);
        prefix = type;
        this.label = null;
        this.value = value;
        register = null;
    }


    /**
     * Instantiates a new Target.
     *
     * @param value the value
     */
    public Target(int value) {
        super(Type.TARGET);
        prefix = Rel;
        this.value = value;
        this.label = null;
        this.register = null;
    }

    /**
     * Instantiates a new Target.
     *
     * @param register the register
     */
    public Target(Reg register){
        super(Type.TARGET);
        prefix = Ind;
        this.register = register;
        value = -1;
        label = null;
    }

    /**
     * Gets register.
     *
     * @return the register
     */
    public Reg getRegister() {
        return register;
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
     * Gets value.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }


    @Override
    public String toString() {
        if (register != null) {
            return prefix + " " + register;
        } else if (label != null) {
            return prefix + " " + label;
        } else if (value != -1) {
            return prefix + " " + value;
        }

        return super.toString();
    }

    /**
     * The enum Target type.
     */
    static enum TargetType {
        /**
         * Ind target type.
         */
        Ind,
        /**
         * Rel target type.
         */
        Rel,
        /**
         * Abs target type.
         */
        Abs
    }
}

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


    public Target(Label label) {
        super(Type.TARGET);
        prefix = Abs;
        this.label = label;
        value = -1;
        register = null;
    }

    public Target(int value) {
        super(Type.TARGET);
        prefix = Rel;
        this.value = value;
        this.label = null;
        this.register = null;
    }

    public Target(Reg register){
        super(Type.TARGET);
        prefix = Ind;
        this.register = register;
        value = -1;
        label = null;
    }

    public Reg getRegister() {
        return register;
    }

    public Label getLabel() {
        return label;
    }

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

    static enum TargetType {
        Ind,
        Rel,
        Abs
    }
}

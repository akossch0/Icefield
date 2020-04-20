package Game;

import Field.Field;
import Skeleton.Skeleton;

import java.util.List;

public abstract class Entity implements Actor{
    protected Field field = null;
    /**
     * A player a parameterben megadott mezore lep
     * @param f A mezo amire az entity lep
     */
    public void Step(Field f){
        field.Remove(this);
        f.Accept(this);
    }
    public void setField(Field field) {
        this.field = field;
    }
    public Field getField(){return field;}
    public abstract void setInWater(boolean b);
}

package Player;

import Field.Field;

/**
 * Egy jatekos altal iranyitott karaktert reprezental, aki meg tudja nezni, hogy egy szomszedos jegtabla hany jatekost bir el.
 */
public class Researcher extends Player {
    final static int maxHealt = 4;
    final static int maxWorkUnit = 4;
    public Researcher(Field _field) {
        super(maxHealt, maxWorkUnit, maxHealt, _field);
    }
    public Researcher(){
        super(maxHealt, maxWorkUnit, maxHealt);
    }

    /**
     * @param f A mezo amire a kepesseget hasznalja majd a player (Oda epit Iglut vagy deriti fel)
     * @return visszater a mezo teherbiro kepessegevel
     */
    @Override
    public int UseAbility(Field f) {
        if (getActualWorkUnit()>0){
            if(!isInWater()){
                setActualWorkUnit(getActualWorkUnit() - 1);
                return f.getCapacity();
            }
        }
        return -1;
    }

    @Override
    public String getType() {return "researcher";}

    /**
     * toString hivasra az osztaly nevevel ter vissza
     *
     */
    @Override
    public String toString(){
        return "researcher";
    }
}

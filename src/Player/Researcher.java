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

    /**
     * @param f A mező amire a kepesseget hasznalja majd a player (Oda epit Iglut vagy deriti fel)
     * @return visszater a mezo teherbiro kepessegevel
     */
    @Override
    public int UseAbility(Field f) {
        return f.getCapacity();
    }

    @Override
    public String getType() {return "researcher";}
}

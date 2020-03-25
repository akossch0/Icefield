package Player;

import Field.Field;

public class Researcher extends Player {
    /**
     * @param f A mező amire a kepesseget hasznalja majd a player (Oda epit Iglut vagy deriti fel)
     * @return visszater a mezo teherbiro kepessegevel
     */
    @Override
    public int UseAbility(Field f){return 0;}

}

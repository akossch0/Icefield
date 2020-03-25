package Player;

import Field.*;

public class Eskimo extends Player {

    /**
     * @param f A mező amire a kepesseget hasznalja majd a player (Oda epit Iglut vagy deriti fel)
     * @return visszater nullaval
     */
    @Override
    public int UseAbility(Field f){
        return 0;
    }

}

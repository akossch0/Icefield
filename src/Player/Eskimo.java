package Player;

import Coverable.Igloo;
import Field.*;
import Skeleton.Skeleton;

/**
 * Egy jatekos altal iranyitott karaktert reprezental, aki iglu epitesere kepes, annak
 * erdekeben, hogy a jatekosok at tudjak veszelni a hovihart.
 */
public class Eskimo extends Player {

    public Eskimo(int _actualHealth, int _actualWorkUnit, int _maxHealth, Field _field) {
        super(_actualHealth, _actualWorkUnit, _maxHealth, _field);
    }

    /**
     * @param f A mező amire a kepesseget hasznalja majd a player (Oda epit Iglut vagy deriti fel)
     * @return visszater nullaval
     */
    @Override
    public int UseAbility(Field f){
        getField().Gloo(new Igloo());
        return -1;
    }

}

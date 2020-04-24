package Field;


import Coverable.Coverable;
import Game.Entity;
import Player.Player;
import Skeleton.Skeleton;

import java.util.List;

/**
 * A mezo egy tipusa. A jegtablak kozott levo lyukat reprezentalja a jatekban.
 * Nem lehet ra iglut epiteni. Teherbírása 0. Nem lehetnek rajta targyak.
 */
public class Hole extends Field {

    @Override
    public void Accept(Entity e) {
        entities.add(e);
        e.setInWater(true);
        e.setField(this);
        for (Entity i: entities) {
            i.Meet(e);
        }
    }

    /**
     *  Beallitja az fedettseg strategiat.
     * @param c
     */
    public void Cover(Coverable c){ }


}

package Field;


import Coverable.Coverable;
import Game.Entity;
import Player.Player;
import Skeleton.Skeleton;

import java.util.List;

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

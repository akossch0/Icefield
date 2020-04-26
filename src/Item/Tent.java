package Item;

import Coverable.TentCover;
import Player.Player;

/**
 * A satrat reprezentalja a jatekban. Hasznalataval sator epitheto.
 */
public class Tent extends Item {

    /**
     * satorhasznalat
     * @param p a player akin az item hasznalva lesz (megegyezhet a hasznalojaval is)
     */
    @Override
    public void Use(Player p) {
        this.getHolder().decreaseWorkUnits();
        p.getField().Cover(new TentCover());
        getHolder().RemoveItem(this);
    }

    /**
     * toString hivasra az osztaly nevevel ter vissza
     *
     */
    @Override
    public String toString(){
        return "tent";
    }
}

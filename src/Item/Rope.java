package Item;

import Field.Field;
import Player.*;

/**
 * A kotelet reprezentalja a jatekban. Hasznalataval a jatekos kihuz magahoz egy szomszedos vizbe esett jatekost.
 */
public class Rope extends Item {
    /**
     *
     * @param p a player akin az item hasznalva lesz (megegyezhet a haszan,lojaval is)
     */
    @Override
    public void Use(Player p){
        Field target = this.getHolder().getField();
        p.setInWater(false);
        p.Step(target);
    }
}

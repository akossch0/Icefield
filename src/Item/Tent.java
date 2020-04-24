package Item;

import Coverable.TentCover;
import Player.Player;

/**
 * A satrat reprezentalja a jatekban. Hasznalataval sator epitheto.
 */
public class Tent extends Item {
    @Override
    public void Use(Player p) {
        p.getField().Cover(new TentCover());
    }
}

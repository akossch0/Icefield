package Item;

import Coverable.TentCover;
import Player.Player;

public class Tent extends Item {
    @Override
    public void Use(Player p) {
        p.getField().Cover(new TentCover());
    }
}

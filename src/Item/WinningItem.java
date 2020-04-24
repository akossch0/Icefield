package Item;

import Game.Game;
import Game.Manager;
import Player.*;
import Skeleton.Skeleton;

public class WinningItem extends Item {
    /**
     *
     * @param p a player akin az item hasznalva lesz (megegyezhet a haszan,lojaval is)
     */
    @Override
    public void Use(Player p){
        p.RemoveItem(this);
        Manager manager = Manager.getInstance();
        manager.addItem(this);
    }
}

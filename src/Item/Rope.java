package Item;

import Player.*;
import Skeleton.Skeleton;

public class Rope extends Item {
    /**
     *
     * @param p a player akin az item hasznalva lesz (megegyezhet a haszan,lojaval is)
     */
    @Override
    public void Use(Player p){
        Skeleton.Called("Rope-Use");
        Skeleton.Return();
    }
}

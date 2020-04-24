package Item;

import Player.*;
import Skeleton.Skeleton;

/**
 * Az etelt reprezentalja a jatekban.
 * Hasznalataval a jatekos actualHealth valtozoja 1-gyel no (ha ezzel nem lepi tul a maximalis erteket).
 */
public class Food extends Item {
    /**
     *
     * @param p a player akin az item hasznalva lesz (megegyezhet a haszan,lojaval is)
     */
    @Override
    public void Use(Player p){
        p.IncrHp();
        p.RemoveItem(this);
    }
}

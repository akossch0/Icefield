package Item;

import Player.*;
import Skeleton.Skeleton;

public abstract class Item {
    /**
     * A birtokosa az itemnek
     */
    private Player holder = null;

    /**
     * Az itemek kepesseget ezen a metoduson keresztul lehete hasznalni
     * @param p a player akin az item hasznalva lesz (megegyezhet a haszan,lojaval is)
     */
    public abstract void Use(Player p);

    /**
     * A tulajdonost allitja be
     * @param p az uj tulajdonosa az itemnek
     */
    public void setHolder(Player p){
        holder = p;
    }

    public Player getHolder(){
        return holder;
    }
}

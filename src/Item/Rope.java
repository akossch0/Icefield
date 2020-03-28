package Item;

import Field.Field;
import Player.*;
import Skeleton.Skeleton;

public class Rope extends Item {
    /**
     *
     * @param p a player akin az item hasznalva lesz (megegyezhet a haszan,lojaval is)
     */
    @Override
    public void Use(Player p){
        Skeleton.Called(this,"Use");
        Field field = p.getField();
        p.Step(field);
        p.setInWater(false);
        Skeleton.Return();


    }
}

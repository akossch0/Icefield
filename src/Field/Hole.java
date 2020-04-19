package Field;


import Coverable.Coverable;
import Game.Entity;
import Player.Player;
import Skeleton.Skeleton;

public class Hole extends Field {



    @Override
    public void Accept(Entity e) {
        getEntites().add(e);
        e.setInWater(true);
    }

    /**
     *  Beallitja az fedettseg strategiat.
     * @param c
     */
    public void Cover(Coverable c){
        Skeleton.Called(this,"Gloo");

        Skeleton.Return();
    }


}

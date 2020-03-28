package Field;


import Coverable.Coverable;
import Player.Player;
import Skeleton.Skeleton;

public class Hole extends Field {

    @Override
    public void Accept(Player p) {
        Skeleton.Called(this,"Accept");
        getPlayers().add(p);
        p.setInWater(true);
        Skeleton.Return();
    }

    /**
     *  Beallitja az fedettseg strategiat.
     * @param c
     */
    public void Gloo(Coverable c){
        Skeleton.Called(this,"Gloo");

        Skeleton.Return();
    }


}

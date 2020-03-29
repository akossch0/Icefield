package Field;


import Coverable.Coverable;
import Player.Player;
import Skeleton.Skeleton;

public class Hole extends Field {
    /**
     * Ez a fuggveny hivodik amikor egy player ralep erre mezore
     * @param p a jatekos aki a mezore lep
     */
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

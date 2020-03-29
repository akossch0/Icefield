package Game;

import Coverable.*;
import Field.Field;
import Player.Player;
import Skeleton.Skeleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Egy singleton osztaly ami a hoviharokert felel
 */
public final class Weather {
    /**
     * Az osszes mezo a palyan
     */
    private List<Field> fields = new ArrayList<Field>();
    /**
     * A weather egyetlen peldanya
     */
    private static Weather INSTANCE;

    /**
     * Ha szuksegunk van a weather osztaly peldanyara ezt a fuggvenyt kell meghivni
     * @return
     */
    public static Weather getInstance(){
        if(INSTANCE == null)
            INSTANCE = new Weather();

        return INSTANCE;
    }

    /**
     * Ha private a konstruktor senki sem tudja majd hibasan hasznalni az osztalyt
     * kotelezoen a getInstance metodust fogjak hasznalni
     */
    private Weather(){}
    /**
     * hovihar fuggveny
     */
    public void Blizzard() {
        Skeleton.Called(this,"Blizzard");

        //nem az összes fieldre kell, a map egy részére
        for (Field f : fields){
            boolean  b =  f.IsCovered();
            if (!b){
                f.IncrLayerOfSnow();
                List<Player> ps = f.getPlayers();
                for (Player p : ps){
                    p.DecrHp();
                    if(Game.getGameOver())
                        break;
                }
            }
            else{
                Coverable ng = new NoGloo();
                f.Gloo(ng);
            }
            if(Game.getGameOver())
                break;
        }
        Skeleton.Return();
    }

    /**
     *
     * @param fs hozzáadott lista
     */
    public void add(List<Field> fs){
        fields = fs;
    }
}

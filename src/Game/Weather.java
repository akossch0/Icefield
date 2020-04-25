package Game;

import Coverable.*;
import Field.Field;
import Player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Egy singleton osztaly ami a hoviharokert felel
 */
public final class Weather implements Actor{
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
    // Ezzel valamit kell kezdeni mert lehet nem jó a Prptotype.Test ~256. sora
    public void Blizzard(List<Field> f) {

        for (Field struck : fields){
            boolean  b = struck.IsCovered();
            if (!b){
                struck.IncrLayerOfSnow();
                List<Entity> ps = struck.getEntites();
                for (Entity e : ps){
                    e.Meet(this);
                    if(Game.isGameLost())
                        break;
                }
            }
            else{
                Coverable nc = new NoCover();
                struck.Cover(nc);
            }
            if(Game.isGameLost())
                break;
        }

    }

    /**
     *
     * @param fs hozzáadott lista
     */
    public void add(List<Field> fs){
        fields = fs;
    }

    /**
     * weather talalkozik aktorral
     * @param a
     */
    @Override
    public void Meet(Actor a) {
        return;
    }

    /**
     * weather a soros
     */
    @Override
    public void yourTurn() {
        List<Field> struck = new ArrayList<Field>();
        /*
        *
        * Ide kell még random generálás
        * WIP
        *
        * */
        Blizzard(struck);

    }

    /**
     * weather maci interakcio
     * @param p a jegesmedve akivel interaktol az weather
     */
    @Override
    public void InteractWith(PolarBear p) {
        return;
    }

    /**
     * weather player interakcio
      * @param p a player akivel az aktor interakcioba lep
     */
    @Override
    public void InteractWith(Player p) {
        if(!p.getField().IsCovered())
            p.DecrHp();
    }
}

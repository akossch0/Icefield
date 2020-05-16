package Game;

import Coverable.*;
import Field.Field;
import Player.Player;
import views.Controller;
import views.Direction;

import java.util.*;

/**
 * Egy singleton osztaly ami a hoviharokert felel
 */
public final class Weather implements Actor{
    /**
     * Az osszes mezo a palyan
     */
    private static List<Field> fields = Game.getInstance().getFields();
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
    public static void Reset(){
        fields = new ArrayList<>();
    }
    /**
     * Ha private a konstruktor senki sem tudja majd hibasan hasznalni az osztalyt
     * kotelezoen a getInstance metodust fogjak hasznalni
     */
    private Weather(){}
    /**
     * hovihar fuggveny
     */
    public void Blizzard(List<Field> f) {

        for (Field struck : f){
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
     * @param fs hozzaadott lista
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


    void recStruckField(HashSet<Field> str, Field field, int depth){
        if(depth <= 0)
            return;

        for(Direction dir : field.getNeighboursWithDir().keySet()){
            Field chosen = field.getNeighboursWithDir().get(dir);
            if(chosen != null) {
                str.add(chosen);
                System.out.println(depth);
                recStruckField(str, chosen, depth - 1);
            }
        }
    }

    /**
     * weather a soros
     */
    @Override
    public void yourTurn() {
        //majd gui-ban meghatarozott mezokre tortenik ez a hivas
        List<Field> struck;
        int recDepth = 5;
        Random rand = new Random(40);
        Field randField = fields.get(rand.nextInt(fields.size()));
        HashSet<Field> targetSet = new HashSet<>();
        recStruckField(targetSet, randField, recDepth);
        struck = new ArrayList<Field>(targetSet);
        System.out.println(struck.size());
        Blizzard(struck);
        //Controller.UpdateRequired();
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

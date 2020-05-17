package Game;

import Coverable.NoCover;
import Field.Field;
import Item.Item;
import Player.Player;
import Item.WinningItem;


import java.util.*;

/**
 * Player és a Game kozotti kapcsolatot megteremto osztaly, a jatek megnyerhetosegeert felelos.
 * Szol a Game-nek, ha a jateknak vege valamilyen okbol.
 */
public final class Manager {

    private static ArrayList<Actor> actors = new ArrayList<Actor>();

    private static HashMap<Player,Integer> timeInWater = new HashMap<Player, Integer>();
    private static HashMap<Field,Integer> timeTent = new HashMap<Field,Integer>();
    private static ArrayList<Item> parts = new ArrayList<Item>();
    private static ArrayList<Player> players = new ArrayList<Player>();
    private static ArrayList<WinningItem> winningItems = new ArrayList<>();

    private static Player currentPlayer;

    public void AddActor(Actor a){
        actors.add(a);
    }
    /**
     * Az egyetlen manager peldany
     */
    private static Manager INSTANCE;
    public static void Reset(){
        timeInWater = new HashMap<Player, Integer>();
        timeTent = new HashMap<Field,Integer>();
        parts = new ArrayList<Item>();
        players = new ArrayList<Player>();
        winningItems = new ArrayList<>();
        actors = new ArrayList<Actor>();
    }
    /**
     * Az egyetlen manager peldannyal visszater, ha meg nem letezik meg is konstrualja
     * @return Az egyetlen manager peldany
     */
    public static Manager getInstance(){
        if(INSTANCE == null)
            INSTANCE = new Manager();

        return INSTANCE;
    }

    /**
     * Letiltjuk ennnek a hasznalatat nehogy valaki a skeletonban ezzel hozzon letre managert
     * mivel a helyes hasznalat a getInstance fuggveny meghivasa
     */
    private Manager(){
    }

    public static void AddPlayer(Player p){
        players.add(p);
        actors.add(p);
    }
    public static void register(WinningItem item){
        winningItems.add(item);
    }
    public static boolean WinningItemUsed(){
        boolean samePlace = true;

        for (int l = 0;players.size()>l&&samePlace;l++){
            if(!players.get(l).getField().equals(players.get(0).getField())){ samePlace = false;}
        }
        boolean everythingOwned = true;
        for (WinningItem i : winningItems){
            if (i.getHolder() == null)
                everythingOwned = false;
        }
        if(samePlace && everythingOwned && winningItems.size() == 3){
            Game.getInstance().Win();
            return true;
        }
        return false;
    }

    /**
     * jelenlegi allapot frissitese a hashmapben, ha vizbe kerult a jatekos, illetve ha kikerult onnan
      * @param p a jatekos, akinek az allapota valtozott
     */
    public static void Update(Player p){
        if(!p.isWaterproof()) {
            if (p.IsInWater()) {
                timeInWater.put(p, 0);
            } else {
                timeInWater.remove(p);
            }
        }
    }

    /**
     * hashmapbe berakas ha tent epult az adott mezon, illetve kiveves ha nem az epult
     * @param TentEpult tent epult e,
     * @param f hol tortent
     */
    public static void Update(boolean TentEpult,Field f){
        if(TentEpult){
            timeTent.put(f,0);
        }
        else{
            timeTent.remove(f);
        }

    }

    /**
     * Minden vizben levo ember es a satrak szamlalojat szamlalojat noveli
     */
    public static void TurnPassed() {
        timeInWater.replaceAll((key,oldValue)->oldValue+1);
        for(Player i:timeInWater.keySet()) {
            if (timeInWater.get(i) >= actors.size()) Game.getInstance().Lose();
        }
        timeTent.replaceAll((key,oldValue)->oldValue+1);
        for (Field i: timeTent.keySet()) {
            if(timeTent.get(i)>=actors.size()) i.Cover(new NoCover());
        }
    }

    /**
     * Elinditja a jatekosok lepeseit
     */
    public static void Start() throws InterruptedException {
        while(!Game.isGameWon() && !Game.isGameLost()){
            for(Actor a : actors) {
                if (Game.isGameWon() || Game.isGameLost()) {
                    break;
                }
                //Allt egy korig a tent
                for (Field i : timeTent.keySet()) {
                    if (timeTent.get(i) > actors.size()) i.Cover(new NoCover());
                }
                //Player e a jelenlegi actor, ha igen akkor ha sok ideig volt vizben es nem vizallo, akkor vege a jateknak
                //minden vizben levo ember szamlalojat noveli
                TurnPassed();

                //Actor kore jon
                a.yourTurn();

            }
        }
    }

    /**
     * Jatekos halalanal hivodik
     */
    public static void Lose(){
        Game.getInstance().Lose();
    }

}

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

    /** A jatek Game osztalya, szukseges nehany dolog menedzselese miatt (pl halal)**/
    private static Game game = Game.getInstance();

    private static ArrayList<Actor> actors = new ArrayList<Actor>();

    private static HashMap<Player,Integer> timeInWater = new HashMap<Player, Integer>();
    private static HashMap<Field,Integer> timeTent = new HashMap<Field,Integer>();
    private static ArrayList<Item> parts = new ArrayList<Item>();
    private static ArrayList<Player> players = new ArrayList<Player>();
    private static ArrayList<WinningItem> winningItems = new ArrayList<>();

    private static Player currentPlayer;
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
            if (i.getHolder().equals(null))
                everythingOwned = false;
        }
        if(samePlace && everythingOwned && winningItems.size() == 3){
            game.Win();
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
        if(currentPlayer==null)return;
        if(TentEpult){
            timeTent.put(f,0);
        }
        else{
            timeTent.remove(f);
        }

    }

    /**
     *
     * @param i a targy amit a jatekos atad a managernek a jatek megnyeresehez
     */
    // Elméletileg sehol sem használva!
    //
    /**
    public static void addItem(Item i){
        parts.add(i);
        boolean egyhelyen = true;

        for (int l = 0;players.size()>l&&egyhelyen;l++){
            if(!players.get(l).getField().equals(players.get(0).getField())){ egyhelyen = false;}
        }

        if(egyhelyen){
            if(parts.size()==3){
                Game game = Game.getInstance();
                game.Win();
            }else{
                Player holder = i.getHolder();
                holder.IncreaseWorkUnit();
            }
        }else{
            for (Item temp : parts){
                Player holder = temp.getHolder();
                holder.AcceptItem(temp);

                parts.remove(temp);
            }
            i.getHolder().IncreaseWorkUnit();
        }
    }**/

    public static void TurnPassed() {
        //minden vízben lévő ember számlálóját növeli
        timeInWater.replaceAll((key,oldValue)->oldValue+1);
        for(Player i:timeInWater.keySet()) {
            if (timeInWater.get(i) >= actors.size()) game.Lose();
        }
        timeTent.replaceAll((key,oldValue)->oldValue+1);
        for (Field i: timeTent.keySet()) {
            if(timeTent.get(i)>=actors.size()) game.Lose();
        }
    }

    /**
     * elinditja a jatekosok lepeseit
     */
    public static void Start(){
        actors.add(PolarBear.getInstance());
        actors.add(Weather.getInstance());

        while(!game.isGameWon() && !game.isGameLost()){
            for(Actor a : actors){
                //Állt egy körig a tent
                for (Field i:timeTent.keySet()) {
                    if(timeTent.get(i)>actors.size())i.Cover(new NoCover());
                }
                //Player e a jelenlegi actor, ha igen akkor ha sok ideig volt vízben és nem vízálló akkor vége a játéknak
                //minden vízben lévő ember számlálóját növeli
                TurnPassed();

                int index = (actors.indexOf(a)>=players.size()?-1:actors.indexOf(a));
                if(index!=-1){
                    currentPlayer = players.get(index);
                }
                //Actor köre jön
                a.yourTurn();


                //minden tent számlálóját növeli
                timeTent.replaceAll((key,oldValue)->oldValue+1);

            }


        }
    }

    /**
     * jatekos halalanal hivodik
     */
    public static void Lose(){
        game.Lose();
    }

}

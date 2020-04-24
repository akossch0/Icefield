package Game;

import Field.Field;
import Item.Item;
import Player.Player;
import Skeleton.Skeleton;

import java.util.*;

/**
 * Player és a Game kozotti kapcsolatot megteremto osztaly, a jatek megnyerhetosegeert felelos.
 * Szol a Game-nek, ha a jateknak vege valamilyen okbol.
 */
public final class Manager {

    /** A jatek Game osztalya, szukseges nehany dolog menedzselese miatt (pl halal)**/
    private static Game game = Game.getInstance();

    private static List<Actor> actors = new ArrayList<Actor>();

    private static HashMap<Player,Integer> timeInWater = new HashMap<Player, Integer>();
    private static HashMap<Field,Integer> timeTent = new HashMap<Field,Integer>();
    private static List<Item> parts = new ArrayList<Item>();
    private static List<Player> players = new ArrayList<Player>();


    private static Player currentPlayer;
    /**
     * Az egyetlen manager peldany
     */
    private static Manager INSTANCE;

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
        /*
        * Játékosok kellenek ide
        *
        * */

        actors.add(Weather.getInstance());
        actors.add(PolarBear.getInstance());

    }
    static void Update(Player p){
        if(p.IsInWater()){
            timeInWater.put(p,0);
        }
        else{
            timeInWater.remove(p);
        }

    }
    static void Update(boolean TentEpult){
        if(TentEpult){
            timeTent.put(currentPlayer.getField(),0);
        }
        else{
            timeTent.put(currentPlayer.getField(),0);
        }
    }
    /**
     *
     * @param i a targy amit a jatekos atad a managernek a jatek megnyeresehez
     */
    public static void addItem(Item i){
        parts.add(i);
        boolean egyhelyen = true;
        for (Player player: players) {
            if(!player.getField().equals(players.get(0).getField())) egyhelyen = false;
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
            parts.remove(i);
            Player holder = i.getHolder();
            holder.AcceptItem(i);
            holder.IncreaseWorkUnit();
        }
    }

    /**
     * elinditja a jatekosok lepeseit
     */
    public static void Start(){

        while(!game.isGameWon() && !game.isGameLost()){
            /*
            for all player in hashmap do
			    waterproof ← player.IsWaterproof()
			    if the int connected to the player is bigger than size of actors and waterproof
			    is false then
				    function call Lose()
			    end if
             */
            for(Actor a : actors){
                a.yourTurn();
            }
            /*
            for all player in hashmap do
			    if the int connected to the player is bigger than -1 then
				    increase the int with 1
			    end if
             */
        }

        /*
        * forciklusba majd egy uj forciklus h minden értéket növeljünk
        *
        *
        for (Player i: timeInWater.keySet()) {
            timeInWater.put(i,timeInWater.get(i)+1);
        }
        for (Field i: timeTent.keySet()) {
            timeTent.put(i,timeTent.get(i)+1);
        }
        * */
    }

    /**
     * jatekos halalanal hivodik
     */
    public static void Lose(){
        game.Lose();
    }
}

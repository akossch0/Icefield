package Game;

import Coverable.NoCover;
import Field.Field;
import Item.Item;
import Player.Player;


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
    }
    public static void AddPlayer(Player p){
        players.add(p);
        actors.add(p);
    }

    /**
     * jelenlegi allapot frissitese a hashmapben, ha vizbe kerult a jatekos, illetve ha kikerult onnan
      * @param p a jatekos, akinek az allapota valtozott
     */
    public static void Update(Player p){
        if(p.IsInWater()){
            timeInWater.put(p,0);
        }
        else{
            timeInWater.remove(p);
        }

    }

    /**
     * hashmapbe berakas ha tent epult az adott mezon, illetve kiveves ha nem az epult
     * @param TentEpult
     */
    public static void Update(boolean TentEpult){/*
        if(TentEpult){
            timeTent.put(currentPlayer.getField(),0);
        }
        else{
            timeTent.remove(currentPlayer.getField());
        }
        */
    }
    /**
     *
     * @param i a targy amit a jatekos atad a managernek a jatek megnyeresehez
     */
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
        actors.add(PolarBear.getInstance());
        actors.add(Weather.getInstance());

        while(!game.isGameWon() && !game.isGameLost()){
            for(Actor a : actors){
                //Állt egy körig a tent
                for (Field i:timeTent.keySet()) {
                    if(timeTent.get(i)>actors.size())i.Cover(new NoCover());
                }
                //Player e a jelenlegi actor, ha igen akkor ha sok ideig volt vízben és nem vízáló akkor vége a játéknak
                int index = (actors.indexOf(a)>=players.size()?-1:actors.indexOf(a));
                if(index!=-1){
                    currentPlayer = players.get(index);

                    if(timeInWater.get(currentPlayer)>actors.size()&&!currentPlayer.isWaterproof()) game.Lose();
                }
                //Actor köre jön
                a.yourTurn();

                //minden vízben lévő ember számlálóját növeli
                timeInWater.replaceAll((key,oldValue)->oldValue+1);

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

package Game;

import Item.Item;
import Player.Player;
import Skeleton.Skeleton;

import java.util.*;

public final class Manager {
    private Game game = null;

    /**
     * a jatekban szereplo jatekosok
     */
    private List<Player> players = new ArrayList<>();

    /**
     * az idojaras melynek felelossege a vihar lebonyolitasa
     */
    private Weather weather = null;
    private static Manager INSTANCE;

    public static Manager getInstance(){
        if(INSTANCE == null)
            INSTANCE = new Manager();

        return INSTANCE;
    }

    /**
     *
     * @param i a targy amit a jatekos atad a managernek a jatek megnyeresehez
     */
    public static void addItem(Item i){
        Skeleton.Called("addItem");
        Skeleton.Return();
    }

    /**
     * elinditja a jatekosok lepeseit
     */
    public static void Start(){
        Skeleton.Called("Start()");
        Skeleton.Return();
    }

    /**
     * jatekos halalanal hivodik
     */
    public static void Lose(){
        Skeleton.Called("Lose()");
        Skeleton.Return();
    }
}

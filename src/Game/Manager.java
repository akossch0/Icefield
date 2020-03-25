package Game;

import Item.Item;
import Player.Player;

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
     * @param i    a targy ami
     */
    public static void addItem(Item i){}

    /**
     * elinditja a jatekosok lepeseit
     */
    public static void Start(){}

    /**
     * jatekos halalanal hivodik
     */
    public static void Lose(){}
}

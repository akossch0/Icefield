package Game;

import Item.Item;
import Player.Player;
import Skeleton.Skeleton;

import java.util.*;

public final class Manager {

    /** A jatek Game osztalya, szukseges nehany dolog menedzselese miatt (pl halal)**/
    private static Game game = Game.getInstance();

    private List<Actor> actors = new ArrayList<Actor>();




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

    /**
     *
     * @param i a targy amit a jatekos atad a managernek a jatek megnyeresehez
     */
    public static void addItem(Item i){
        Skeleton.Called(getInstance(),"addItem");

        if(Skeleton.Question("<<Minden játékos ezen a jégtáblán tartózkodik?(Igen/Nem)>>")){
            if(Skeleton.Question("<<Ez az utolsó hiányzó tárgy?(Igen/Nem)>>")){
                Game game = Game.getInstance();
                game.Win();
            }
        }else{
            Player holder = i.getHolder();
            holder.AcceptItem(i);
        }
        Skeleton.Return();
    }

    /**
     * elinditja a jatekosok lepeseit
     */
    public static void Start(){
        Skeleton.Called(getInstance(),"Start");
        Skeleton.Return();
    }

    /**
     * jatekos halalanal hivodik
     */
    public static void Lose(){
        Skeleton.Called(getInstance(),"Lose");
        game.Lose();
        Skeleton.Return();
    }
}

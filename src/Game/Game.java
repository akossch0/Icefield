package Game;

import Field.Field;

import java.util.*;
import Skeleton.*;

/**
 * Inicializalja a jegtablakat. Inicializalja a jatekot, majd szamontartja, hogy eppen melyik jatekos lep.
 * Hoviharokat general a jatekosok lepesei kozott.
 */
public final class Game {

    private static boolean gameWon = false;
    private static boolean gameLost = false;
    /**
     * A jatekteren talalhato osszes mezo
      */
    private List<Field> fields = new ArrayList<>();

    /**
     * a statikus valtozo amin hivjuk a fuggvenyeket
     */
    private static Game INSTANCE;

    /**
     * @return visszakuldi a statikus valtozot ha nem ures, amugy pedig peldanyosit
     */
    public static Game getInstance(){
        // Ha meg egyszer sem keszitettunk el Game objektumot akkor most lesz elkeszitve
        if(INSTANCE == null)
            INSTANCE = new Game();

        return INSTANCE;
    }

    /**
     * Megnyert-e a jatek
     * @return
     */
    public static boolean isGameWon(){ return gameWon; }

    /**
     * Elvesztett-e a jatek
     * @return
     */
    public static boolean isGameLost(){ return gameLost; }

    /**
     * Ha privat a konstruktor senki sem tudja osszekeverni a dolgokat
     * es mindenki helyesen a getInstance fuggvenyt fogja hasznali
     */
    private Game(){};
    /**
     * elinditja a jatekot
     */
    public void StartGame(){
        Skeleton.Called(this,"StartGame");
        InitMap();
        Manager.Start();
        Skeleton.Return();
    }

    /**
     * inicializalja a jatekteret, vagyis beallitja a jegtablak es targyak elhelyezkedeset
     */
    public void InitMap(){
        //IDE KELL PALYAGENERALAS
    }

    /**
     * Jatek megnyerese
     */
    public void Win(){ gameWon = true; }

    /**
     * Jatek elvesztese
     */
    public void Lose(){ gameLost = true; }
}

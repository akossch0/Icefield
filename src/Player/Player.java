package Player;

import ClothesEquipped.*;
import Game.*;
import Item.*;
import Field.*;

import java.util.ArrayList;
import java.util.List;

public class Player {

    /**
     * A mezo amin a player tartozkodik
     */
    private Field field = null;
    /**
     * A jatek menedzsere
     */
    private Manager manager = null;
    /**
     * A player alltal birtokolt itemek listaja
     */
    private List<Item> items = new ArrayList<Item>();
    /**
     * ??????????????????????????????????????
     */
    private ClothesEquipped clothes = null;


    /**
     * @param f A mező amire a kepesseget hasznalja majd a player (Oda epit Iglut vagy deriti fel)
     * @return Ha Researcher hivja meg akkor ter vissza fontos szammal, ha Eszkimo akkor 0 a visszateresi ertek
     */
    public int UseAbility (Field f){return 0;}

    /**
     * Noveli a player HP-jat 1 el
     */
    public void IncrHp(){}

    /**
     * CSokkenti a player HP-jat  1 el
     */
    public void DecrHp(){}

    /**
     * A player a parameterben megadott mezore lep
     * @param f A mezo amire a player lep
     */
    public void Step(Field f){}

    /**
     * Ezzel a metodussal a player ellapatol egy kevés havat a mezorol amin all
     */
    public void Dig(){}

    /**
     * @return Visszaadja a mezot amin a player all
     */
    public Field getField(){return null;}

    /**
     * @param i az item amit a player hasznalni fog, meghivja  az itemre a use()-t
     * @param target a player amin az item hasznalva lesz (pl rope)
     */
    public void UseItem(Item i, Player target){}

    /**
     * A player ezzel a metodussal felveszi a mezojen talalhato itemet
     */
    public void PickUpItem(){}

    /**
     * @param c a ruha amit a player felvesz magara
     */
    public void setClothes(ClothesEquipped c){}

    /**
     *  A menedzser kozli a playerrel, hogy az o kore kovetkezik
     */
    public void yourTurn(){}

    /**
     * Elveszi a playertol az itemet amit parameterkent megkap
     * @param i az item amit elvesznek
     */
    public void RemoveItem(Item i){}

    /**
     * @return visszater azzal, hogy a player vizbe van-e esve
     */
    public boolean isWaterproof(){return true;}

    /**
     * Elfogad a player egy itemet, igy lehet neki adni pl asot
     * @param i az item amit elfogad
     */
    public void AcceptItem(Item i){}

}

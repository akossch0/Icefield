package Player;

import ClothesEquipped.*;
import Game.*;
import Item.*;
import Field.*;
import Prototype.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Absztrakt alaposztaly, a konkret peldanyai az Eszkimo (Eskimo) vagy a Sarkkutato (Researcher).
 */

public abstract class Player extends Entity implements OutputToString{
    private int actualHealth ;// A játékos aktuális élete.
    private int actualWorkUnit ;// A játékos a körben még hány munkát tud elvégezni. Minden körben 4 egységnyi munkát tud elvégezni az összes játékos.
    private int maxHealth ;// A játékos maximális élete. Eszkimóknak (Eskimo) 5, Sarkkutatóknak (Researcher) 4.
    private List<Item> items = new ArrayList<Item>();// A játékosnál lévő tárgyak.
    private boolean inWater = false;// Megmondja hogy a játékos vízbe vanprivate e.
    private ClothesEquipped clothes = new NoClothesEquipped();// A ruha viselése stratégiát tároló attribútum.
    public Player(int _actualHealth,int _actualWorkUnit,int _maxHealth,Field _field){
        actualHealth = _actualHealth;
        actualWorkUnit = _actualWorkUnit;
        maxHealth = _maxHealth;
        setField(_field);
        Manager.AddPlayer(this);
    };

    private boolean endTurn = false;
    public void setEndTurn(boolean _endturn){endTurn = _endturn;}

    /**
     * A jatek menedzsere
     */
    private Manager manager = Manager.getInstance();
    public void IncreaseWorkUnit(){actualWorkUnit++;}

    /**
     * @param f A mező amire a kepesseget hasznalja majd a player (Oda epit Iglut vagy deriti fel)
     * @return Ha Researcher hivja meg akkor ter vissza fontos szammal, ha Eszkimo akkor 0 a visszateresi ertek
     */
    public abstract int UseAbility (Field f);

    /**
     * Noveli a player HP-jat 1 el
     */
    public void IncrHp(){
        if(actualHealth+1<=maxHealth) actualHealth++;
    }

    /**
     * Csokkenti a player HP-jat  1 el
     */
    public void DecrHp(){
        actualHealth--;
        if(actualHealth==0){
            Manager.Lose();
        }
    }



    /**
     * Ezzel a metodussal a player ellapatol egy kevés havat a mezorol amin all
     */
    public void Dig(){
        field.DecrLayerOfSnow(1);
    }

    /**
     * @return Visszaadja a mezot amin a player all
     */
    public Field getField(){
        return field;
    }

    /**
     * @param i az item amit a player hasznalni fog, meghivja  az itemre a use()-t
     * @param target a player amin az item hasznalva lesz (pl rope)
     */
    public void UseItem(Item i, Player target){
        i.Use(target);
    }

    /**
     * A player ezzel a metodussal felveszi a mezojen talalhato itemet
     */
    public void PickUpItem(){
        Item item = field.RemoveItem();
        if (item != null){
            items.add(item);
            item.setHolder(this);
        }
    }

    /**
     * @param c a ruha amit a player felvesz magara
     */
    public void setClothes(ClothesEquipped c){
        clothes = c;
    }

    @Override
    public void Meet(Actor a) {

        a.InteractWith(this);

    }

    /**
     *  A menedzser kozli a playerrel, hogy az o kore kovetkezik
     */
    public void yourTurn(){
/*

       Ide valami függvényhívás ami átadja magát amire hívjuk majd a függvényt
*/
        while(!endTurn&&actualWorkUnit!=0){

        }
    }

    @Override
    public void InteractWith(PolarBear p) {

        Manager.Lose();
    }

    @Override
    public void InteractWith(Player p) {

        return;
    }

    /**
     * Elveszi a playertol az itemet amit parameterkent megkap
     * @param i az item amit elvesznek
     */
    public void RemoveItem(Item i){
        items.remove(i);
    }

    /**
     * @return visszater azzal, hogy a player vizbe van-e esve
     */
    public boolean isWaterproof(){

        return clothes.isWaterproof();
    }

    /**
     * Elfogad a player egy itemet, igy lehet neki adni pl asot
     * @param i az item amit elfogad
     */
    public void AcceptItem(Item i){
        items.add(i);
        i.setHolder(this);
    }
    public void setInWater(boolean _inWater){
        inWater = _inWater;
        Manager.Update(this);
    }
    public boolean IsInWater(){return inWater;}

    /**
     * kimeneti nyelv a playerre
     * @param objects a hashmap ami tarolja az objektum-id-ket es a hozza tartozo objektumokat
     * @return
     */
    public String toString(HashMap<String,Object> objects){
        String result = "player\n" +
                "\tID: " + Test.getKeyByValue(objects,this) + "\n" +
                "\tTYPE: " + this.getClass() + "\n" +
                "\tactualHealth: " + this.actualHealth + "\n" +
                "\titems: " + concatItems(items,objects) + "\n" +
                "\tinWater: " +  this.inWater + "\n" +
                "\tactualWorkUnit: " + this.actualWorkUnit + "\n" +
                "\tfield: " + Test.getKeyByValue(objects,this.field) + "\n" +
                "\tclothes: " + this.clothes.getClass() + "\n";
        return result;
    }

    /**
     * A kimeneti nyelv miatt szukseges fuggveny, egy jatekos inventory-jabol csinal egy string-et
     * ami az item-ek id-jet felsorolja egymas utan space-el elvalasztva
     * @param items egy jatekos inventory-ja
     * @param objects a hashmap amiben tarolva vannak az id-k objectekkel parositva
     * @return az eloallitott string
     */
    private String concatItems(List<Item> items, HashMap<String,Object> objects){
        StringBuilder result = new StringBuilder();
        for(Item i : items){
            result.append(Test.getKeyByValue(objects, i)).append(" ");
        }
        return result.toString();
    }
}

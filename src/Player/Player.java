package Player;

import ClothesEquipped.*;
import Game.*;
import Item.*;
import Field.*;
import Prototype.Test;

import java.util.*;

/**
 * Absztrakt alaposztaly, a konkret peldanyai az Eszkimo (Eskimo) vagy a Sarkkutato (Researcher).
 */

public abstract class Player extends Entity implements OutputToString{
    private int actualHealth ;
    private int actualWorkUnit ;
    private int maxHealth ;
    private List<Item> items = new ArrayList<Item>();
    private boolean inWater = false;
    private ClothesEquipped clothes = new NoClothesEquipped();
    public Player(int _actualHealth,int _actualWorkUnit,int _maxHealth,Field _field){
        actualHealth = _actualHealth;
        actualWorkUnit = _actualWorkUnit;
        maxHealth = _maxHealth;
        setField(_field);
        Manager.AddPlayer(this);
    };

    private boolean endTurn = false;
    public void setEndTurn(boolean _endturn){endTurn = _endturn;}

    public int getActualWorkUnit() {
        return actualWorkUnit;
    }

    public void setActualWorkUnit(int actualWorkUnit) {
        this.actualWorkUnit = actualWorkUnit;
    }

    /**
     * A jatek menedzsere
     */
    private Manager manager = Manager.getInstance();
    public void IncreaseWorkUnit(){actualWorkUnit++;}
    public List<Item> getItems(){
        return items;
    }
    /**
     * @param f A mezo amire a kepesseget hasznalja majd a player (Oda epit Iglut vagy deriti fel)
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
    @Override
    public void Step(Field f){

        field.Remove(this);
        field = f;
        f.Accept(this);
        actualWorkUnit = actualWorkUnit-1;
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
            this.decreaseWorkUnits();
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
        //while(!endTurn&&actualWorkUnit!=0){ }
        //Ez a resz majd tenyleges jatekmenetkor lesz lenyeges, tesztelesnel, amikor a prototipust hasznaljuk meg nincs ra szukseg
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
        String result = "player:\n" +
                "\tID: " + Test.getKeyByValue(objects,this) + "\n" +
                "\tTYPE: " + this.getType() + "\n" +
                "\tactualHealth: " + this.actualHealth + "\n" +
                "\titems: " + concatItems(items,objects) + "\n" +
                "\tinWater: " +  this.inWater + "\n" +
                "\tactualWorkUnit: " + this.actualWorkUnit + "\n" +
                "\tfield: " + Test.getKeyByValue(objects,this.field) + "\n" +
                "\tclothes: " + this.clothes.getType();
        return result;
    }


    public abstract String getType();

    /**
     * A kimeneti nyelv miatt szukseges fuggveny, egy jatekos inventory-jabol csinal egy string-et
     * ami az item-ek id-jet felsorolja egymas utan space-el elvalasztva
     * @param items egy jatekos inventory-ja
     * @param objects a hashmap amiben tarolva vannak az id-k objectekkel parositva
     * @return az eloallitott string
     */

    private String concatItems(List<Item> items, HashMap<String,Object> objects){
        StringBuilder result = new StringBuilder();
        List<String> strs = new ArrayList<>();
        for (Item i: items ){
            strs.add(Test.getKeyByValue(objects, i));
        }
        Collections.sort(strs);
        for(String s : strs){
            result.append(s).append(" ");
        }
        return result.toString();
    }

    /**
     * Csokkenti a jatekos munkaegysegeit eggyel
     */
    public void decreaseWorkUnits(){
        actualWorkUnit = actualWorkUnit - 1;
    }
}

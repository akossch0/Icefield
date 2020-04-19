package Player;

import ClothesEquipped.*;
import Game.*;
import Item.*;
import Field.*;
import Skeleton.Skeleton;

import java.util.ArrayList;
import java.util.List;

public class Player extends  Entity{
    /**
     * A mezo amin a player tartozkodik
     */

    /**
     * A jatek menedzsere
     */
    private Manager manager = Manager.getInstance();
    /**
     * A player alltal birtokolt itemek listaja
     */
    private List<Item> items = new ArrayList<Item>();
    /**
     * A player strategy je vízbeesésre
     */
    private ClothesEquipped clothes = new NoClothesEquipped();



    /**
     * @param f A mező amire a kepesseget hasznalja majd a player (Oda epit Iglut vagy deriti fel)
     * @return Ha Researcher hivja meg akkor ter vissza fontos szammal, ha Eszkimo akkor 0 a visszateresi ertek
     */
    public int UseAbility (Field f){
        Skeleton.Called(this, "UseAbility");
        Skeleton.Return();
        return 0;}

    /**
     * Noveli a player HP-jat 1 el
     */
    public void IncrHp(){
        Skeleton.Called(this, "IncrHp");
        Skeleton.Return();
    }

    /**
     * Csokkenti a player HP-jat  1 el
     */
    public void DecrHp(){
        Skeleton.Called(this,"DecrHp");

        if(Skeleton.Question("<<Elfogyott az összes élete a játékosnak?(Igen/Nem)>> ")){
            Manager.Lose();
        }
        Skeleton.Return();
    }



    /**
     * Ezzel a metodussal a player ellapatol egy kevés havat a mezorol amin all
     */
    public void Dig(){
        Skeleton.Called(this,"Dig");
        field.DecrLayerOfSnow(1);
        Skeleton.Return();
    }

    /**
     * @return Visszaadja a mezot amin a player all
     */
    public Field getField(){
        Skeleton.Called(this,"getField");
        Skeleton.Return();
        return field;
    }

    /**
     * @param i az item amit a player hasznalni fog, meghivja  az itemre a use()-t
     * @param target a player amin az item hasznalva lesz (pl rope)
     */
    public void UseItem(Item i, Player target){
        Skeleton.Called(this,"UseItem");
        i.Use(target);
        Skeleton.Return();
    }

    /**
     * A player ezzel a metodussal felveszi a mezojen talalhato itemet
     */
    public void PickUpItem(){
        Skeleton.Called(this,"PickUpItem");
        Item item = field.RemoveItem();
        if (item != null){
            items.add(item);
            item.setHolder(this);
        }
        Skeleton.Return();
    }

    /**
     * @param c a ruha amit a player felvesz magara
     */
    public void setClothes(ClothesEquipped c){
        Skeleton.Called(this,"setClothes");
        Skeleton.Return();
    }

    @Override
    public void Meet(Actor a) {
        a.InteractWith(this);
    }

    /**
     *  A menedzser kozli a playerrel, hogy az o kore kovetkezik
     */
    public void yourTurn(){
        Skeleton.Called(this,"yourTurn");

        if(Skeleton.Question("<<A játékos benne van a vízben, és már nem az első kör óta van ez?(Igen/Nem)>>")){
            isWaterproof();
            if(!Skeleton.Question("<<Van búvárruha rajta?(Igen/Nem)>> ")){
                manager.Lose();
            }
        }

        Skeleton.Return();
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
        Skeleton.Called(this,"RemoveItem");
        Skeleton.Return();
    }

    /**
     * @return visszater azzal, hogy a player vizbe van-e esve
     */
    public boolean isWaterproof(){
        Skeleton.Called(this,"isWaterproof");
        Skeleton.addNames(clothes,"ClothesEquipped");
        boolean isWP = clothes.isWaterproof();
        Skeleton.Return();
        return isWP;
    }

    /**
     * Elfogad a player egy itemet, igy lehet neki adni pl asot
     * @param i az item amit elfogad
     */
    public void AcceptItem(Item i){
        Skeleton.Called(this,"AcceptItem");
        i.setHolder(this);
        Skeleton.Return();
    }
    public void setInWater(boolean inWater){
        Skeleton.Called(this,"setInWater");
        Skeleton.Return();
    }

}

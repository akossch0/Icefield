package Field;

import Coverable.*;
import Player.*;
import Item.*;
import Skeleton.Skeleton;

import java.util.ArrayList;
import java.util.List;

public abstract class Field {
    /** A mezon allo playerek listaja **/
    private List<Player> players = new ArrayList<Player>();
    /** A szomszedos mezok listaja**/
    private List<Field> fields = new ArrayList<Field>();
    /** A mezo strategyje, alapertelmezetten minden mezo fedettlen **/
    protected Coverable cover = new NoGloo();
    /** A mezon talalhato item **/
    protected Item item = null;

    /**
     * Ezzel a setterrel lehet itemet adni a mezonek
     * @param item az item amit elfogad
     */
    public void setItem(Item item){
        this.item = item;
    }

    /**
     * Uj jatekos erkezik a mezore. Ha meg elbirja a mezo, akkor a jatekos ezentul ezen a mezon áll.
     * Ha nem birja el, akkor a jatekos a vizbe esik.
     * @param p a jatekos aki a mezore lep
     */
    public abstract void Accept(Player p);

    /**
     *A parameterkent kapott jatekos elhagyja a mezot.
     * @param p a jatekos aki tavozik a mezorol
     */
    public void Remove(Player p){
        Skeleton.Called(this,"Remove");
        players.remove(p);
        Skeleton.Return();
    }

    /**
     * Visszaad egy mar kiasott targyat és eltavolitja azt a mezobol.
     * @return a visszaadott item
     */
    public Item RemoveItem(){
        Skeleton.Called(this,"RemoveItem");
        Item i = item;
        item = null;
        Skeleton.Return();
        return i;
    }

    /**
     * Visszaadja a mezon tartozkodo jatekosokat.
     * @return a visszaadott jatekosok
     */
    public List<Player> getPlayers() {
        //Skeleton.Called(this,"getPlayers");
        //Skeleton.Return();
        return players;
    }

    /**
     * Megnoveli a mezon levo horetegek szamat.
     */
    public void IncrLayerOfSnow(){
        Skeleton.Called(this,"IncrLayerOfSnow");
        Skeleton.Return();
    }

    /**
     * Csokkenti a mezon levo horetegek szamat.
     * @param n
     */
    public void DecrLayerOfSnow(int n){
        Skeleton.Called(this,"DecrLayerOfSnow");
        Skeleton.Return();
    }

    /**
     * Visszaadja, hogy a mezo hany jatekost bir el.
     * @return kapacitas
     */
    public int getCapacity(){
        Skeleton.Called(this,"getCapacity");
        Skeleton.Return();
        return 0;
    }

    /**
     * Meghivja a strategiajanak az IsCovered() fuggvenyet,
     * vagyis megmondja, hogy fedett-e a mezo vagy sem.
     * @return fedett-e
     */
    public boolean IsCovered(){
        Skeleton.Called(this,"IsCovered");
        cover.IsCovered();
        Skeleton.Return();
        return false;
    }
    /**
     *  Beallitja az fedettseg strategiat.
     * @param c a strategy amit beallit
     */
    public void Gloo(Coverable c){
        Skeleton.Called(this,"Gloo");
        cover = c;
        Skeleton.Return();
    }
}

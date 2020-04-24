package Field;

import Coverable.*;
import Game.Entity;
import Player.*;
import Item.*;
import Skeleton.Skeleton;

import java.util.ArrayList;
import java.util.List;

public abstract class Field {
    /** A mezon allo playerek listaja **/
    protected List<Entity> entities = new ArrayList<>();

    /** A szomszedos mezok listaja**/
    private List<Field> neighbours = new ArrayList<Field>();

    /** A mezo strategyje, alapertelmezetten minden mezo fedettlen **/
    protected Coverable cover = new NoCover();

    private  int layerOfSnow = 0;

    private  int capacity = 0;


    public List<Field> getNeighbours(){return neighbours;}

    public void AddNeighbour(Field e){neighbours.add(e);}
    public void RemoveNeighbour(Field e){neighbours.remove(e);}



    /**
     * Ezzel a setterrel lehet itemet adni a mezonek
     * @param item az item amit elfogad
     */
    public abstract void setItem(Item item);

    /**
     * Visszaad egy mar kiasott targyat és eltavolitja azt a mezobol.
     * @return a visszaadott item
     */
    public abstract Item RemoveItem();

    /**
     * Uj jatekos erkezik a mezore. Ha meg elbirja a mezo, akkor a jatekos ezentul ezen a mezon áll.
     * Ha nem birja el, akkor a jatekos a vizbe esik.
     * @param e az entity aki a mezore lep
     */
    public abstract void Accept(Entity e);

    /**
     *A parameterkent kapott jatekos elhagyja a mezot.
     * @param e az entity aki tavozik a mezorol
     */
    public void Remove(Entity e){
        entities.remove(e);
    }

    /**
     * Visszaadja a mezon tartozkodo entity-ket.
     * @return a visszaadott jatekosok
     */
    public List<Entity> getEntites() {
        return entities;
    }

    /**
     * Megnoveli a mezon levo horetegek szamat.
     */
    public void IncrLayerOfSnow(){
        layerOfSnow++;
    }



    /**
     * Csokkenti a mezon levo horetegek szamat.
     * @param n
     */
    public void DecrLayerOfSnow(int n){
        if(n>=layerOfSnow) layerOfSnow = 0;
        else layerOfSnow -=n;
    }

    /**
     * Visszaadja, hogy a mezo hany jatekost bir el.
     * @return kapacitas
     */
    public int getCapacity(){
       return capacity;
    }

    /**
     * Meghivja a strategiajanak az IsCovered() fuggvenyet,
     * vagyis megmondja, hogy fedett-e a mezo vagy sem.
     * @return fedett-e
     */
    public boolean IsCovered(){

        return cover.IsCovered();

    }
    public boolean IsBearProof(){
        return cover.IsBearProof();
    }
    /**
     *  Beallitja az fedettseg strategiat.
     * @param c a strategy amit beallit
     */
    public void Cover(Coverable c){
        Skeleton.Called(this,"Gloo");
        cover = c;
        Skeleton.Return();
    }

    public int getLayerOfSnow() {
        return layerOfSnow;
    }

    public void setLayerOfSnow(int LayerOfSnow) {
        layerOfSnow = LayerOfSnow;
    }

    public void setCapacity(int Capacity) {
        capacity = Capacity;
    }
}

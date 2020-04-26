package Field;

import Coverable.*;
import Game.Entity;

import Game.OutputToString;
import Item.*;
import Prototype.Test;

import java.util.*;

/**
 * Absztrakt alaposztaly. Ebbol oroklodik az IceBlock és a Hole.
 * Egy mezot reprezentál. Minden mezot boríthat ho (tobb retegben is),
 * egyes mezok csak bizonyos szamu jatekost birnak el,
 * ezt a limitet tullepve a mezorol a jatekosok a vizbe kerulnek.
 */
public abstract class Field implements OutputToString {
    /** A mezon allo playerek listaja **/
    protected List<Entity> entities = new ArrayList<>();

    /** A szomszedos mezok listaja**/
    private List<Field> neighbours = new ArrayList<Field>();

    /** A mezo strategyje, alapertelmezetten minden mezo fedettlen **/
    protected Coverable cover = new NoCover();

    /**
     * A horetegek szama a mezon
     */
    private  int layerOfSnow = 0;

    /**
     * Ennyi jatekost bir el a mezo
     */
    private  int capacity = 0;

    public int X;
    public int Y;


    /**
     * neighbours adattag gettere
     * @return
     */
    public List<Field> getNeighbours(){return neighbours;}

    /**
     * hozzaad a szomszedokhoz egy fieldet
     * @param e a hozzaadott szomszed
     */
    public void AddNeighbour(Field e){neighbours.add(e);}

    /**
     * kitorli a parameterkent kapott fieldet a szomszedok kozul
     * @param e a kitorlendo field
     */
    public void RemoveNeighbour(Field e){neighbours.remove(e);}

    /**
     * abstract, iceblockban van megvalositva
     * @return
     */
    public abstract boolean IsOpen();

    /**
     * Ezzel a setterrel lehet itemet adni a mezonek
     * @param item az item amit elfogad
     */
    public abstract void setItem(Item item);
    public abstract Item getItem();
    /**
     * Visszaad egy mar kiasott targyat es eltavolitja azt a mezobol.
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
    public abstract void DecrLayerOfSnow(int n);

    /**
     * Visszaadja, hogy a mezo hany jatekost bir el.
     * @return kapacitas
     */
    public int getCapacity(){
       return capacity;
    }

    /**
     * Beallitja a capacity-t a megadott ertekre
     *
     */
    public void setCapacity(int Capacity) {
        capacity = Capacity;
    }

    /**
     *  Beallitja az fedettseg strategiat.
     * @param c a strategy amit beallit
     */
    public abstract void Cover(Coverable c);

    /**
     * Meghivja a strategiajanak az IsCovered() fuggvenyet,
     * vagyis megmondja, hogy fedett-e a mezo vagy sem.
     * @return fedett-e
     */
    public boolean IsCovered(){ return cover.IsCovered(); }

    /**
     * Visszater azzal, hogy megveallo-e a mezo
     *
     */
    public boolean IsBearProof(){
        return cover.IsBearProof();
    }

    /**
     * Visszater a horeteg szamaval, ami a mezon talalhato
     *
     */
    public int getLayerOfSnow() {
        return layerOfSnow;
    }

    /**
     *
     * @param LayerOfSnow beallitja a mezon levo ho mennyiseget a kapott ertekre
     */
    public void setLayerOfSnow(int LayerOfSnow) {
        layerOfSnow = LayerOfSnow;
    }

    /**
     * A kimeneti nyelv miatt szukseges fuggveny, egy field szomszedos fieldjeibol csinal egy string-et
     * ami a field-ek id-jet felsorolja egymas utan space-el elvalasztva
     * @param nbs szomszedos field-ek
     * @param objects hashmap ami tarolja az id-ket
     * @return az osszefuzott string
     */
    protected String concatNeighbours(List<Field> nbs, HashMap<String,Object> objects){
        StringBuilder result = new StringBuilder();
        List<String> strs = new ArrayList<>();
        for (Field nb: nbs ){
            strs.add(Test.getKeyByValue(objects, nb));
        }
        Collections.sort(strs);
        for(String s : strs){
            result.append(s).append(" ");
        }
        if(result.lastIndexOf(" ") >= 0)
            result.deleteCharAt(result.lastIndexOf(" "));
        return result.toString();
    }

}

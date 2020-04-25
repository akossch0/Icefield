package Coverable;

import Game.Manager;

/**
 * A Field-nek egy strategy-je. Ha ez a tipus a Field strategy-je, akkor fedett a Field.
 */
public class IglooCover implements Coverable{
    /**
     * Konstruktor
     */
    public IglooCover(){
        Manager.Update(false);
    }
    /**
     * Igazzal ter vissza, vagyis jelzi, hogy fedett a mező.
     * @return boolean
     */
    @Override
    public boolean IsCovered() { return false;}

    /**
     * Igazzal ter vissza, mivel az igloo-ba nem tud a medve bejutni
     * @return
     */
    @Override
    public boolean IsBearProof() { return true; }
    @Override
    public String toString(){
        return "IglooCover";
    }
}

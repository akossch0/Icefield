package Coverable;

import Game.Manager;

/**
 * A Field-nek egy strategy-je. Ha ez a tipus a Field strategy-je, akkor egy korig fedett a Field.
 */
public class TentCover implements Coverable {
    /**
     * Konstruktor
     */
    public TentCover(){
      //  Manager.Update(true);

    }

    /**
     * Sator megved a hovihar elol
     * @return igazzal ter vissza
     */
    @Override
    public boolean IsCovered() { return true; }

    /**
     * Sator nem ved meg a jegesmedve elol
     * @return hamissal ter vissza
     */
    @Override
    public boolean IsBearProof() { return false; }

    /**
     * toString hivasra az osztaly nevevel ter vissza
     *
     */
    @Override
    public String toString(){
        return "TentCover";
    }
}

package Coverable;



/**
 * A Field-nek egy strategy-je. Ha ez a tipus a Field strategy-je, akkor egy korig fedett a Field.
 */
public class TentCover implements Coverable {
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
    @Override
    public String toString(){
        return "TentCover";
    }
}

package Coverable;



/**
 * A Field-nek egy strategy-je. Ha ez a tipus a Field strategy-je, akkor fedett a Field.
 */
public class IglooCover implements Coverable{

    /**
     * Igazzal ter vissza, vagyis jelzi, hogy fedett a mezo.
     * @return boolean
     */
    @Override
    public boolean IsCovered() { return true;}

    /**
     * Igazzal ter vissza, mivel az igloo-ba nem tud a medve bejutni
     * @return
     */
    @Override
    public boolean IsBearProof() { return true; }

    /**
     * toString hivasra az osztaly nevevel ter vissza
     *
     */
    @Override
    public String toString(){
        return "IglooCover";
    }
}

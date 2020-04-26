package Coverable;

/**
 * A Field-nek egy strategy-je. Ha ez a tipus a Field strategy-je, akkor nem fedett a Field.
 */
public class NoCover implements Coverable {
    /**
     * Hamisat ad vissza, vagyis jelzi hogy nem fedett a mezo.
     * @return false
     */
    @Override
    public boolean IsCovered() {return false; }

    /**
     * Hamisat ad vissza, vagyis jelzi, hogy a medve ellen nem ved
     * @return false
     */
    @Override
    public boolean IsBearProof() {return false; }
    @Override
    public String toString(){
        return "NoCover";
    }
}

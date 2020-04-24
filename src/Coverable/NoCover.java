package Coverable;

import Coverable.Coverable;
import Skeleton.Skeleton;

public class NoCover implements Coverable {
    /**
     * Konstruktora Nogloo-nak
     * @param
     */
    public NoCover(){
        Skeleton.addNames(this,"IglooCoverable");
        Skeleton.Called(this,"Igloo");
        Skeleton.Return();
    }
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
}

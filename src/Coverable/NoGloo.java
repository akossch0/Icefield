package Coverable;

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
     * @return boolean
     */
    @Override
    public boolean IsCovered() {
        Skeleton.Called(this,"IsCovered");
        Skeleton.Return();
        return false;
    }

    @Override
    public boolean IsBearProof() {
        return false;
    }
}

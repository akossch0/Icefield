package Coverable;

import Skeleton.Skeleton;

public class Igloo implements Coverable{
    /**
     * Konstruktora Igloo-nak
     * @param
     */
    public Igloo(){
        Skeleton.addNames(this,"IglooCoverable");
        Skeleton.Called(this,"Igloo");
        Skeleton.Return();
    }
    /**
     * Igazzal ter vissza, vagyis jelzi, hogy fedett a mező.
     * @return boolean
     */
    @Override
    public boolean IsCovered() {
        Skeleton.Called(this,"IsCovered");
        Skeleton.Return();
        return false;
    }

    /**
     * Igazzal ter vissza, mivel az igloo-ba nem tud a medve bejutni
     * @return
     */
    @Override
    public boolean IsBearProof() {
        return true;
    }
}

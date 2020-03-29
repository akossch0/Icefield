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
}

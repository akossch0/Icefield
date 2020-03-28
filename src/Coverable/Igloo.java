package Coverable;

import Skeleton.Skeleton;

public class Igloo implements Coverable{
    public Igloo(){
        Skeleton.addNames(this,"IglooCoverable");
        Skeleton.Called(this,"Igloo");
        Skeleton.Return();
    }
    /**
     * Igazzal ter vissza, vagyis jelzi, hogy fedett a mező.
     * @return
     */
    @Override
    public boolean IsCovered() {
        Skeleton.Called(this,"IsCovered");
        Skeleton.Return();
        return false;
    }
}

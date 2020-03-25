package Coverable;

import Skeleton.Skeleton;

public class Igloo implements Coverable{

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

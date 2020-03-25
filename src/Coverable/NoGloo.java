package Coverable;

import Skeleton.Skeleton;

public class NoGloo implements Coverable {

    /**
     * Hamisat ad vissza, vagyis jelzi hogy nem fedett a mezo.
     * @return
     */
    @Override
    public boolean IsCovered() {
        Skeleton.Called("IsCovered");
        Skeleton.Return();
        return false;
    }
}

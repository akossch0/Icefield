package ClothesEquipped;

import Skeleton.Skeleton;

public class SwimsuitEquipped implements ClothesEquipped {

    /**
     * Konstruktora SwimsuitEquipped-nek
     * @param 
     */
    public SwimsuitEquipped(){

        Skeleton.addNames(this, "SwimsuitEquipped");
        Skeleton.Called(this, "SwimsuitEquipped");

        Skeleton.Return();
    }

    /**Hm
     * @return igazzal ter vissza; jelentes: a jatekos visel buvarruhat
     */
    @Override
    public boolean isWaterproof() {
        Skeleton.Called(this,"isWaterproof");
        Skeleton.Return();
        return true;
    }
}

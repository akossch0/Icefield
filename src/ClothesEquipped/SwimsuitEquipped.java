package ClothesEquipped;

import Skeleton.Skeleton;

public class SwimsuitEquipped implements ClothesEquipped {

    public SwimsuitEquipped(String name){
        Skeleton.addNames(this,name);
        Skeleton.Called(this, name);

        Skeleton.Return();
    }

    /**
     * @return igazzal ter vissza; jelentes: a jatekos visel buvarruhat
     */
    @Override
    public boolean isWaterproof() {
        Skeleton.Called(this,"isWaterproof");
        Skeleton.Return();
        return true;
    }
}

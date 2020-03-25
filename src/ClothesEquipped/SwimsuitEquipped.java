package ClothesEquipped;

import Skeleton.Skeleton;

public class SwimsuitEquipped implements ClothesEquipped {

    /**
     * @return igazzal ter vissza; jelentes: a jatekos visel buvarruhat
     */
    @Override
    public boolean isWaterproof() {
        Skeleton.Called("isWaterproof");
        Skeleton.Return();
        return true;
    }
}

package ClothesEquipped;
import Skeleton.Skeleton;
public class NoSwimsuitEquipped implements ClothesEquipped {
    /**
     * @return hamissal ter vissza; jelentes: a jatekos nem visel buvarruhat
     */
    @Override
    public boolean isWaterproof() {
        Skeleton.Called("isWaterproof");
        Skeleton.Return();
        return false;
    }



}

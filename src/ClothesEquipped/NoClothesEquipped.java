package ClothesEquipped;
import Skeleton.Skeleton;
public class NoClothesEquipped implements ClothesEquipped {
    /**
     * @return hamissal ter vissza; jelentes: a jatekos nem visel buvarruhat
     */
    @Override
    public boolean isWaterproof() {
        Skeleton.Called(this, "isWaterproof");
        Skeleton.Return();
        return false;
    }



}

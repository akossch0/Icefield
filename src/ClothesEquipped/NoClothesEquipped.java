package ClothesEquipped;
import Skeleton.Skeleton;
public class NoClothesEquipped implements ClothesEquipped {

    /**
     * Konstruktora NoClothesEquipped-nek
     * @param
     */
    public NoClothesEquipped(){

        Skeleton.addNames(this, "NoClothesEquipped");
        Skeleton.Called(this, "NoClothesEquipped");

        Skeleton.Return();
    }
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

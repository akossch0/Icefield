package ClothesEquipped;

/**
 * A Player-nek egy strategy-je. Ha ez a tipus a Player strategy-je,
 * akkor a Player-en nincs semmilyen különösebb kepesseget ado oltozek.
 */
public class NoClothesEquipped implements ClothesEquipped {
    /**
     * @return hamissal ter vissza; jelentes: a jatekos nem visel buvarruhat
     */
    @Override
    public boolean isWaterproof() {return false;}
}

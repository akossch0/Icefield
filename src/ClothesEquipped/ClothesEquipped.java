package ClothesEquipped;

/**
 * Minden oltozek ezt az interface-t kell megvalositsa, hogy a Player viselje oket.
 */
public interface ClothesEquipped {
    /**
     * @return megadja, hogy egy jatekos visel-e buvarruhat
     */
    public boolean isWaterproof();

    public String getType();
}

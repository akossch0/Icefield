package ClothesEquipped;

/**
 * A buvarruhat reprezentalja a jatekban. Hasznalataval a jatekos vizallo lesz,
 * igy ha vizbe esik onnan ki tud egyedul maszni, lepni.
 */
public class SwimsuitEquipped implements ClothesEquipped {
    /**
     * Buvarruha viselet
     * @return igazzal ter vissza; jelentes: a jatekos visel buvarruhat
     */
    @Override
    public boolean isWaterproof() {
        return true;
    }

    @Override
    public String getType() {return "SwimsuitEquipped";}
}

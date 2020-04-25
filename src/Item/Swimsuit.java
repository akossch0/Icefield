package Item;

import ClothesEquipped.SwimsuitEquipped;
import Player.*;

/**
 * A buvarruhat reprezentalja a jatekban. Hasznalataval a jatekos vizallo lesz, igy ha vizbe esik onnan ki tud egyedul maszni, lepni.
 */
public class Swimsuit extends Item {
    /**
     *
     * @param p a player akin az item hasznalva lesz (megegyezhet a haszan,lojaval is)
     */
    @Override
    public void Use(Player p){
        this.getHolder().decreaseWorkUnits();
        SwimsuitEquipped swimsuit = new SwimsuitEquipped();
        p.setClothes(swimsuit);
    }
}

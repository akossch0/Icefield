package Coverable;

/**
 * A Coverable interfeszt megvalosito osztalyok dontik el, hogy egy Field fedett-e vagy sem.
 */
public interface Coverable {
    /**
     * Visszateresi erteke megmondja, hogy a Field fedett-e vagy sem.
     * @return
     */
    boolean IsCovered();

    /**
     * Megmondja egy epitmenyrol hogy a medve elol megved-e
     * @return
     */
    boolean IsBearProof();
}

package Coverable;

public class TentCover implements Coverable {


    public TentCover(){
        /*
        Itt még kell olyan rész hogy szól a managernek hogy tent épült
         */

    }

    /**
     * Sator megved a hovihar elol
     * @return igazzal ter vissza
     */
    @Override
    public boolean IsCovered() {
        return true;
    }

    /**
     * Sator nem ved meg a jegesmedve elol
     * @return hamissal ter vissza
     */
    @Override
    public boolean IsBearProof() {
        return false;
    }
}

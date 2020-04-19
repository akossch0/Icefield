package Coverable;

public class TentCover implements Coverable {
    public TentCover(){
        /*
        Itt még kell olyan rész hogy szól a managernek hogy tent épült
         */

    }
    @Override
    public boolean IsCovered() {
        return true;
    }

    @Override
    public boolean IsBearProof() {
        return false;
    }
}

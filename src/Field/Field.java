package Field;

import Coverable.Coverable;
import Player.*;
import Item.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Field {
    private List<Player> players = new ArrayList<Player>();
    private List<Field> fields = new ArrayList<Field>();
    private Coverable cover = null;

    public abstract void Gloo(Coverable c);

    public void Accept(Player p){

    }

    public void Remove(Player p){

    }

    public Item RemoveItem(){
        return null;
    }

    public Coverable getCover() {
        return cover;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void DecrLayerOfSnow(int n){

    }
}

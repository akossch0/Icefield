package Player;

import ClothesEquipped.*;
import Game.*;
import Item.*;
import Field.*;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Field field = null;
    private Manager manager = null;
    private List<Item> items = new ArrayList<Item>();
    private ClothesEquipped clothes = null;


    public int UseAbility (Field f){return 0;}
    public void IncrHp(){}
    public void DecrHp(){}
    public void Step(Field f){}
    public void Dig(){}
    public Field getField(){return null;}
    public void UseItem(Item i, Player target){}
    public void PickUpItem(){}
    public void setClothes(ClothesEquipped c){}
    public void yourTurn(){}
    public void RemoveItem(Item i){}
    public boolean isWaterproof(){return true;}
    public void AcceptItem(Item i){}

}

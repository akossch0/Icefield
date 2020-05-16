package views;



import java.awt.*;
import java.util.ArrayList;

public class View {
    private ArrayList<IView> views = new ArrayList<IView>();
    public void Update(Graphics graphics){
        // System.out.println(Integer.toString(views.size()));
        for (IView item: views) {
            item.RefreshData();
            item.Draw(graphics);
        }
    }
    public void AddView(IView newView){
        views.add(newView);
    }
    public void RemoveView(IView badView){
        views.remove(badView);
    }
    public void Init(){
    };
}

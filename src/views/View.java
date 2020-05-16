package views;



import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View {
    private ArrayList<IView> views = new ArrayList<IView>();
    Graphics graphics;

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public void Update(){
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
}

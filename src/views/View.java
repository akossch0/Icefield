package views;

import java.awt.*;
import java.util.ArrayList;

/**
 * a modellhez tartozo nezet
 */
public class View {
    private ArrayList<IView> views = new ArrayList<IView>();
    Graphics graphics;

    /**
     * grafika beallitasa
     * @param graphics
     */
    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    /**
     * az osszes nezet frissitese
     */
    public void Update(){
        for (IView item: views) {
            item.Draw(graphics);
        }
    }

    /**
     * egy objektum hozzaadasa a nezetlistahoz
     * @param newView
     */
    public void AddView(IView newView){
        views.add(newView);
    }

    /**
     * egy objektum kitorlese a nezetlistabol
     * @param badView
     */
    public void RemoveView(IView badView){
        views.remove(badView);
    }
}

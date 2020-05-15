package views;



import java.util.ArrayList;

public class View {
    private ArrayList<IView> views = new ArrayList<IView>();
    public void Update(){
        for (IView item: views) {
            item.Draw();
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

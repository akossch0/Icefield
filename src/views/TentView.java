package views;

import Field.Field;
import Item.Tent;

import java.awt.*;
import java.awt.image.BufferedImage;


public class TentView implements IView {
    Tent tent;
    BufferedImage image = null;
    public TentView(Tent t){
        tent = t;
    }

    @Override
    public void Draw(Graphics graphics) {
        if (tent.getHolder() == null)   {
            Field field = tent.getField();
            graphics.drawImage(image, field.X*64, field.Y*64,null );
        }
    }

    @Override
    public void RefreshData() {

    }
}

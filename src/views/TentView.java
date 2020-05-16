package views;

import Field.Field;
import Item.Tent;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class TentView implements IView {
    Tent tent;
    BufferedImage image;
    public TentView(Tent t){
        tent = t;
        try{
            image = (BufferedImage) ImageIO.read(new File("src/images/tent.png"));
        }
        catch(IOException e){
            System.out.println("Valami baj van a sátor i/o-val");
        }
    }

    @Override
    public void Draw(Graphics graphics) {
        if (tent.getHolder() == null) {
            Field field = tent.getField();
            if(field.getLayerOfSnow()==0)graphics.drawImage(image, field.X*64, field.Y*64, null );
        }
    }

    @Override
    public void RefreshData() {

    }
}

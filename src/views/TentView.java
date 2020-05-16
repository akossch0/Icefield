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
    BufferedImage image = new BufferedImage(64,64, BufferedImage.TYPE_INT_ARGB);
    public TentView(Tent t){
        tent = t;
        try{
            BufferedImage big = (BufferedImage) ImageIO.read(new File("src/images/tent.png"));
            Graphics2D g = image.createGraphics();
            g.drawImage(big, 0, 0, 64, 64, null);
            g.dispose();
        }
        catch(IOException e){
            System.out.println("Valami baj van a sátor i/o-val");
        }
    }

    @Override
    public void Draw(Graphics graphics) {
        if (tent.getHolder() == null)   {
            Field field = tent.getField();
            graphics.drawImage(image, field.X*64, field.Y*64, null );
        }
    }

    @Override
    public void RefreshData() {

    }
}

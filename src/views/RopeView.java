package views;

import Field.Field;
import Field.IceBlock;
import Item.Rope;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class RopeView implements IView {
    Rope rope;
    BufferedImage image = null;
    BufferedImage imageO = null;

    public RopeView(Rope r) {
        rope = r;
        try {
            image = (BufferedImage) ImageIO.read(new File("src/images/rope.png"));
            imageO = (BufferedImage) ImageIO.read(new File("src/images/rope_fifty.png"));
        }
        catch(IOException e) {
            System.out.println("nem jo a kotel rajzolas");
        }
    }
    @Override
    public void Draw(Graphics graphics) {
        //if(!rope.getField().IsOpen()) { /*opacity valtoztatasa*/}
        if (rope.getHolder() == null) {
            Field field = rope.getField();
            if(field.getLayerOfSnow()==0){
                if(field.IsOpen())graphics.drawImage(image, field.X*64, field.Y*64, null );
                else graphics.drawImage(imageO, field.X*64, field.Y*64, null );
            }
        }

    }

    @Override
    public void RefreshData() {

    }
}

package views;

import Item.Swimsuit;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class SwimsuitView implements IView {
    Swimsuit swimsuit;



    BufferedImage image = null;
    public SwimsuitView(Swimsuit s) {
        swimsuit = s;
        try {
            image = (BufferedImage) ImageIO.read(new File("src/images/swimsuit.png")).getScaledInstance(64, 64, Image.SCALE_DEFAULT);
        }
        catch(IOException e) {
            System.out.println("nem jo a swimsuit rajzolas");
        }
    }
    @Override
    public void Draw(Graphics graphics) {
        graphics.drawImage(image, swimsuit.getField().X * 64, swimsuit.getField().Y * 64, null);
    }

    @Override
    public void RefreshData() {

    }
}

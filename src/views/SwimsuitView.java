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
    public SwimsuitView(Swimsuit s) throws IOException {
        swimsuit = s;
        try {
            image = (BufferedImage) ImageIO.read(new File("src/images/swimsuit.png"));
        }
        catch(IOException e) {
            System.out.println("nem jo a kotel rajzolas");
        }
    }
    @Override
    public void Draw(Graphics graphics) {

    }

    @Override
    public void RefreshData() {

    }
}

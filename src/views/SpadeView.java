package views;

import Item.Rope;
import Item.Spade;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class SpadeView implements IView {
    Spade spade;
    BufferedImage image = null;

    public SpadeView(Spade s)  {
        spade = s;
        try {
            image = (BufferedImage) ImageIO.read(new File("src/images/spade.png"));
        }
        catch(IOException e) {
            System.out.println("nem jo a spade rajzolas");
        }
    }
    @Override
    public void Draw(Graphics graphics) {
        graphics.drawImage(image, spade.getField().X * 64, spade.getField().Y * 64, null);
    }

    @Override
    public void RefreshData() {

    }
}

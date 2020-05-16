package views;

import Item.Rope;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class RopeView implements IView {
    Rope rope;
    BufferedImage image = null;

    RopeView(Rope r) {
        rope = r;
        try {
            image = (BufferedImage) ImageIO.read(new File("src/images/rope.png"));
        }
        catch(IOException e) {
            System.out.println("nem jo a kotel rajzolas");
        }
    }
    @Override
    public void Draw(Graphics graphics) {
        graphics.drawImage(image, rope.getField().X * 64, rope.getField().Y * 64, null);

    }

    @Override
    public void RefreshData() {

    }
}

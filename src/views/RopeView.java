package views;

import Item.Rope;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class RopeView implements IView {
    Rope rope;
    BufferedImage image = ImageIO.read(new File("src/images/rope.png"));
    RopeView(Rope r) throws IOException {rope = r;}
    @Override
    public void Draw(Graphics graphics) {
        graphics.drawImage(image, rope.getField().X * 64, rope.getField().Y * 64, null);
    }

    @Override
    public void RefreshData() {

    }
}

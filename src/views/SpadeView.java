package views;

import Item.Spade;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class SpadeView implements IView {
    Spade spade;
    BufferedImage image = ImageIO.read(new File("src/images/spade.png"));
    public SpadeView(Spade s) throws IOException {spade = s;}
    @Override
    public void Draw(Graphics graphics) {
        graphics.drawImage(image, spade.getField().X * 64, spade.getField().Y * 64, null);
    }

    @Override
    public void RefreshData() {

    }
}

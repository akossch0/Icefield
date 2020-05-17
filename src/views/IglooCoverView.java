package views;

import Coverable.IglooCover;
import Coverable.TentCover;
import Field.Field;
import Game.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class IglooCoverView implements IView {
    Field field;
    BufferedImage image;
    IglooCoverView(Field f){
        field = f;
        try {
            image = (BufferedImage) ImageIO.read(new File("src/images/igloo.png"));

        }
        catch(IOException e) {
            System.out.println("nem jo a igloo rajzolas");
        }
    }
    @Override
    public void Draw(Graphics graphics) {
        if(!(field.getCover() instanceof IglooCover)) Game.getInstance().getView().RemoveView(this);
        else graphics.drawImage(image, field.X*64, field.Y*64, null );

    }

    @Override
    public void RefreshData() {

    }
}

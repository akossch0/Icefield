package views;

import Field.IceBlock;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class IceBlockView implements IView {
    IceBlock iceBlock;

    BufferedImage image;

    BufferedImage imagewithsnow;
    BufferedImage imagewithoutsnow;
    public IceBlockView(IceBlock i){
        iceBlock = i;
        try {
            imagewithoutsnow =  ImageIO.read(new File("src/images/iceblock.png"));
            imagewithsnow = ImageIO.read(new File("src/images/snow.png"));
        } catch (IOException e) {
            System.out.println("Baj van - IceBlockView betoltese");
        }
    }
    @Override
    public void Draw(Graphics graphics) {
        if(iceBlock.getLayerOfSnow()==0)
            graphics.drawImage(imagewithoutsnow,iceBlock.X*64,iceBlock.Y*64,null);
        else
            graphics.drawImage(imagewithsnow,iceBlock.X*64,iceBlock.Y*64,null);
    }

    @Override
    public void RefreshData() {

    }
}

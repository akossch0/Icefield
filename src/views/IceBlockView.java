package views;

import Field.IceBlock;

import java.awt.*;
import java.awt.image.BufferedImage;


public class IceBlockView implements IView {
    IceBlock iceBlock;

    BufferedImage image;
    public IceBlockView(IceBlock i){
        iceBlock = i;
        image = null;
        System.out.println("Még nincs betöltve");
    }
    @Override
    public void Draw(Graphics graphics) {
        graphics.drawImage(image.getScaledInstance(64,64,Image.SCALE_DEFAULT),iceBlock.X*64,iceBlock.Y*64,null);
    }

    @Override
    public void RefreshData() {

    }
}

package views;

import Field.Field;
import Item.WinningItem;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class WinningItemView implements IView{

    WinningItem winningItem;
    BufferedImage image;
    public WinningItemView(WinningItem w){
        winningItem = w;
        String path = null;
        if(w.id == 0)
            path = "src/images/flare.png";
        else if (w.id == 1)
            path = "src/images/gun.png";
        else if (w.id == 2)
            path = "src/images/cartridge.png";
        try{
            image = (BufferedImage) ImageIO.read(new File(path));
        }
        catch(IOException e){
            System.out.println("Valami baj van a winningitem i/o-val");
        }
    }
    @Override
    public void Draw(Graphics graphics) {
        if (winningItem.getHolder() == null)   {
            Field field = winningItem.getField();
            if(field.getLayerOfSnow()==0)graphics.drawImage(image, field.X*64, field.Y*64,null );
        }
    }

    @Override
    public void RefreshData() {

    }
}

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
    WinningItemView(WinningItem w){
        winningItem = w;
        String path = null;
        if(w.id == 1)
            path = "src/images/flare.png";
        else if (w.id == 2)
            path = "src/images/pistol.png";
        else if (w.id ==3)
            path = "src/images/cartridge.png";
        try{
            image = (BufferedImage) ImageIO.read(new File(path)).getScaledInstance(64,64,Image.SCALE_DEFAULT);
        }
        catch(IOException e){
            System.out.println("Valami baj van a sátor i/o-val");
        }
    }
    @Override
    public void Draw(Graphics graphics) {
        if (winningItem.getHolder() == null)   {
            Field field = winningItem.getField();
            graphics.drawImage(image, field.X*64, field.Y*64,null );
        }
    }

    @Override
    public void RefreshData() {

    }
}

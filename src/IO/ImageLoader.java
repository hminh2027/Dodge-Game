package IO;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageLoader {
    BufferedImage image;

    public Image getImage(String s){
        try {
            image = ImageIO.read(new File("resources/image/"+s));
            return image;
        } catch (Exception e){
            System.out.println("Image path not found!");
        }
        return null;
    }
}

package GUI.Background;

import GUI.Window.GameWindow;
import IO.ImageLoader;
import java.awt.*;

public class Background {
    private Image image;
    private ImageLoader imageLoader;

    public Background(String s){
        imageLoader = new ImageLoader();
        image = imageLoader.getImage(s);
    }
    public void render(Graphics g){
        g.drawImage(image,0,0, GameWindow.GAME_WIDTH,GameWindow.GAME_HEIGHT,null);
    }
}

package GUI.Objects.Player;

import GUI.HUD.Heath;
import GUI.Objects.Object;
import Logic.ObjectHandler;
import GUI.Window.GameWindow;
import IO.ImageLoader;
import Logic.Collision;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Object {
    private char Direction = ' ';
    public static int x;
    public static int y;
    ImageLoader imageLoader;
    Image image;

    public Player( ObjectHandler objectHandler) {
        super(objectHandler);
        velX =0;
        velY =0;
        width = 32;
        height = 32;
        speed = 5;
        x = GameWindow.GAME_WIDTH/2 - width;
        y = GameWindow.GAME_HEIGHT/2- height;

        heath = new Heath(10,10);
        imageLoader = new ImageLoader();
        image = imageLoader.getImage("player.png");
    }

    @Override
    public Rectangle collision() {
        return new Rectangle(x,y,width,height);
    }

    @Override
    public void checkCollision() {
    //    Hit the screen
        x = Collision.clampCollision(x,0, GameWindow.GAME_WIDTH-this.width);
        y = Collision.clampCollision(y,0, GameWindow.GAME_HEIGHT-this.height);
    }

    @Override
    public void update() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image,x,y,width,height,null);
    }


    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP  ) {this.Direction='u';this.velY = -speed;}
        if(key == KeyEvent.VK_DOWN ) {this.Direction='d';this.velY = speed;}
        if(key == KeyEvent.VK_RIGHT ) {this.Direction='r';this.velX = speed;}
        if(key == KeyEvent.VK_LEFT ) {this.Direction='l';this.velX = -speed;}
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP && Direction !='d') this.velY = 0;
        if(key == KeyEvent.VK_DOWN && Direction !='u') this.velY = 0;
        if(key == KeyEvent.VK_RIGHT && Direction !='l') this.velX = 0;
        if(key == KeyEvent.VK_LEFT && Direction !='r') this.velX = 0;
    }
}

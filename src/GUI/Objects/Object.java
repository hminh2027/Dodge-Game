package GUI.Objects;

import GUI.HUD.Heath;
import IO.AudioLoader;
import Logic.ObjectHandler;

import java.awt.*;

public abstract class Object {
    protected int x;
    protected int y;
    protected float velX;
    protected float velY;
    protected int width;
    protected int height;
    protected int speed;
    protected Heath heath;
    protected ObjectHandler objectHandler;
    protected AudioLoader audio;

    public Object(ObjectHandler objectHandler){
        this.objectHandler = objectHandler;
        audio = new AudioLoader();
    }
    public abstract Rectangle collision();
    public abstract void checkCollision();
    public abstract void update();
    public abstract void render(Graphics g);
//
    public int getX(){return x;}
    public int getY(){return y;}
    public int getWidth(){return width;}
    public int getHeight(){return height;}
    public Heath getHeath(){return heath;}
}

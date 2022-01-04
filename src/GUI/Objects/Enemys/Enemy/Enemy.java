package GUI.Objects.Enemys.Enemy;

import GUI.Objects.Object;
import Logic.ObjectHandler;
import IO.ImageLoader;
import Logic.Collision;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.util.Random;

public class Enemy extends Object {
    ObjectHandler objectHandler;
    ImageLoader imageLoader;
    Image image;
    String image_path;
    Random random;
    Clip attacked;
    protected int damage;

    public Enemy(ObjectHandler objectHandler, String image_path){
        super(objectHandler);
        this.objectHandler = objectHandler;
        this.image_path = image_path;
        imageLoader = new ImageLoader();
        image = imageLoader.getImage(image_path);
        random = new Random();
        attacked = audio.getAudio("attacked.wav");
    }

    @Override
    public Rectangle collision() {return new Rectangle(x,y,width,height);}

    @Override
    public void checkCollision() {
        //    Hit the wall
        if(Collision.isHitXWall(this)) velY*=-1;
        if(Collision.isHitYWall(this)) velX*=-1;
        //    Hit player
        if(Collision.isHitPlayer(this,objectHandler.getObj(0))) {
            objectHandler.removeObj(this);
            objectHandler.getObj(0).getHeath().setHealth(objectHandler.getObj(0).getHeath().getHealth() - damage);
            attacked.start();
        };
    }

    @Override
    public void update() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image,x, y,width,height,null);
    }
}

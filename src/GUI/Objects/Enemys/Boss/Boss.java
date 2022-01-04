package GUI.Objects.Enemys.Boss;

import GUI.HUD.Heath;
import GUI.Objects.Object;
import Logic.ObjectHandler;
import GUI.Window.GameWindow;
import IO.AudioLoader;
import IO.ImageLoader;
import Logic.Collision;

import javax.sound.sampled.Clip;
import java.awt.*;

public class Boss extends Object {
    ObjectHandler objectHandler;
    ImageLoader imageLoader;
    Image image;
    Heath heath_boss;
    String image_path;
    AudioLoader audio;
    Clip boss_alert;
    protected int damage;
    protected int count = 130;
    protected float x;
    protected float y;
    boolean isShow = false;

    public Boss(ObjectHandler objectHandler, String image_path){
        super(objectHandler);
        this.objectHandler = objectHandler;

        velX = 0;
        velY = 1;
        width = 128;
        height = 128;
        x = GameWindow.GAME_WIDTH/2 - width/2;
        y = -height;
        damage = 100;

        this.image_path = image_path;
        imageLoader = new ImageLoader();
        image = imageLoader.getImage(image_path);
        heath_boss = new Heath(GameWindow.GAME_WIDTH-200-10,10);
        audio = new AudioLoader();
        boss_alert = audio.getAudio("boss_alert.wav");
    }

    @Override
    public Rectangle collision() {
        return new Rectangle((int)x,  (int)y,width,height);
    }

    @Override
    public void checkCollision() {
        //  Hit the wall
        if(this.x<=0 || this.x >= GameWindow.GAME_WIDTH-width) velX*=-1;
        // Hit the player
        if(Collision.isHitPlayer(this,objectHandler.getObj(0))) {
            objectHandler.getObj(0).getHeath().setHealth(objectHandler.getObj(0).getHeath().getHealth() - damage);
        };
    }

    public void animation(){

    }

    public void skill(){

    }

    public void loseHealthOvertime(){
        heath_boss.setHealth(heath_boss.getHealth()-0.1);
    }

    @Override
    public void update() {
        x += velX;
        y += velY;
        animation();
        if(isShow==true) skill();
        loseHealthOvertime();
    }
    @Override
    public void render(Graphics g) {
        g.drawImage(image,(int)x, (int)y, width,height,null);
        heath_boss.render(g);
    }
}

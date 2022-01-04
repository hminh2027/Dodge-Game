package GUI.Objects.Enemys.Boss;

import Logic.ObjectHandler;
import GUI.Objects.Player.Player;
import GUI.Window.GameWindow;
import Logic.Collision;

import java.awt.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Boss2 extends Boss {
    private int count2 = 300;
    ObjectHandler objectHandler;

    public Boss2(ObjectHandler objectHandler){
        super(objectHandler,"boss2.png");
        this.objectHandler = objectHandler;
        speed = 1;
    }

    public Rectangle collision() {
        return new Rectangle((int)x,  (int)y,width,height);
    }

    @Override
    public void checkCollision() {
        //  Hit the wall
        if(this.x<=0 || this.x >= GameWindow.GAME_WIDTH-width) velX*=-1;
        //    Hit player
        if(Collision.isHitPlayer(this,objectHandler.getObj(0))) {
            objectHandler.getObj(0).getHeath().setHealth(objectHandler.getObj(0).getHeath().getHealth() - damage);
        }
    }

    @Override
    public void skill(){
        //  Speed Up
        if(count2 == 0){
            speedUp();
            count2 = 300;
        }
        else count2--;
    }

    public void animation(){
        if(count == 0) {
            isShow=true;
            tracking();
        }
        else if(count > 0) count--;
    }

    public void speedUp(){
        speed++;
    }

    public void tracking(){
        //  Track player
        float difX = (x - Player.x);
        float difY = (y - Player.y);
        //  Pytago
        float dis = (float) sqrt(pow(difX,2) + pow(difY,2));
        //  Li do de dau - la vi phu thuoc vao difX,difY duong hay am de doan dc vi tri 2 vat
        velX=  ((-1/dis) * (difX))* speed;
        velY=  ((-1/dis) * (difY)) * speed;
    }
}

package GUI.Objects.Enemys.Boss;

import GUI.Objects.Enemys.Enemy.Enemy;
import Logic.ObjectHandler;
import GUI.Window.GameWindow;
import Logic.Collision;

import javax.sound.sampled.Clip;
import java.util.Random;

public class Boss1 extends Boss {
    ObjectHandler objectHandler;
    Random random;
    Clip boss_shoot;

    public Boss1(ObjectHandler objectHandler){
        super(objectHandler,"boss.png");
        this.objectHandler = objectHandler;

        random = new Random();
        boss_shoot = audio.getAudio("boss_shoot.wav");
        boss_alert.start();
    }

    public void shootingBullets(){
        if(random.nextInt(10) == 1){
            objectHandler.addObj(new Bullet((int)x+width/2,(int)y+height, objectHandler));
        }
    }

    @Override
    public void skill(){
        shootingBullets();
    }

    @Override
    public void animation(){
        if(count == 0) {
            boss_alert.stop();
            isShow=true;
            velY = 0;
            velX=-1;
            count=-1;
        }
        else if(count > 0) count--;
    }

    public class Bullet extends Enemy {
        ObjectHandler objectHandler;
        Clip attacked;

        public Bullet(int x, int y, ObjectHandler objectHandler){
            super(objectHandler,"bullet.png");
            this.objectHandler = objectHandler;
            this.x = x;
            this.y = y;
            velX = random.nextInt(10)-5;
            velY = 5;
            speed = 4;
            width = 32;
            height = 32;
            damage = 4;

            attacked = audio.getAudio("attacked.wav");
        }

        @Override
        public void checkCollision() {
            //    Hit player
            if(Collision.isHitPlayer(this,objectHandler.getObj(0))) {
                objectHandler.removeObj(this);
                objectHandler.getObj(0).getHeath().setHealth(objectHandler.getObj(0).getHeath().getHealth() - damage);
                attacked.start();
            };
            //  Out of the screen
            if(x<0 || x> GameWindow.GAME_WIDTH) objectHandler.removeObj(this);
            if(y<0 || x> GameWindow.GAME_HEIGHT) objectHandler.removeObj(this);
        }

    }
}

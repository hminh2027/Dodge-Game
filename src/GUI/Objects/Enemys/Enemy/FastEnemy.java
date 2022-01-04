package GUI.Objects.Enemys.Enemy;

import Logic.ObjectHandler;
import GUI.Window.GameWindow;

public class FastEnemy extends Enemy {
    ObjectHandler objectHandler;

    public FastEnemy(ObjectHandler objectHandler){
        super(objectHandler,"fast_enemy.png");
        this.objectHandler = objectHandler;
        speed = 8;
        width = 16;
        height = 16;
        x = random.nextInt(GameWindow.GAME_WIDTH - width);
        y = random.nextInt(GameWindow.GAME_HEIGHT - height);
        velX = speed;
        velY = speed;
        damage = 3;
    }
}

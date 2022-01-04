package GUI.Objects.Enemys.Enemy;

import Logic.ObjectHandler;
import GUI.Window.GameWindow;

public class ZigzagEnemy extends Enemy {
    ObjectHandler objectHandler;

    public ZigzagEnemy(ObjectHandler objectHandler) {
        super(objectHandler, "zigzag_enemy.png");
        this.objectHandler = objectHandler;
        width = 32;
        height = 32;
        speed = 1;
        damage = 10;
        x = random.nextInt(GameWindow.GAME_WIDTH - width);
        y = random.nextInt(GameWindow.GAME_HEIGHT - height);
        velX = speed*5;
        velY = speed;
    }
}


package GUI.Objects.Enemys.Enemy;

import Logic.ObjectHandler;
import GUI.Window.GameWindow;

public class SlowEnemy extends Enemy {
    ObjectHandler objectHandler;

    public SlowEnemy(ObjectHandler objectHandler){
        super(objectHandler,"slow_enemy.png");
        this.objectHandler = objectHandler;
        speed = 4;
        width = 16;
        height = 16;
        velX = speed;
        velY = speed;
        damage = 5;

        x = random.nextInt(GameWindow.GAME_WIDTH - width);
        y = random.nextInt(GameWindow.GAME_HEIGHT - height);
    }
}

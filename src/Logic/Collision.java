package Logic;

import GUI.Objects.Object;
import GUI.Window.GameWindow;

public class Collision {

    public static int clampCollision(int value,int min,int max){
        if(value <= min) return value = min;
        if(value >= max) return value = max;
        return value;
    }

    public static boolean isHitXWall(Object o){
        if (o.getY() <= 0 || o.getY() >= GameWindow.GAME_HEIGHT-o.getHeight()) return true;
        return false;
    }

    public static boolean isHitYWall(Object o){
        if (o.getX() <= 0 || o.getX() >= GameWindow.GAME_WIDTH-o.getWidth()) return true;
        return false;
    }

    public static boolean isHitPlayer(Object o1, Object o2){
        if(o1.collision().intersects(o2.collision())) {
            return true;
        }
        return false;
    }
}

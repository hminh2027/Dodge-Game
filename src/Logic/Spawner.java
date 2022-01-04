package Logic;

import GUI.Objects.Enemys.Boss.Boss1;
import GUI.Objects.Enemys.Boss.Boss2;
import GUI.Objects.Enemys.Enemy.FastEnemy;
import GUI.Objects.Enemys.Enemy.SlowEnemy;
import GUI.Objects.Enemys.Enemy.ZigzagEnemy;
import GUI.Objects.Player.Player;

public class Spawner {
    ObjectHandler objectHandler;
    //    Objects
    Player player;
    SlowEnemy slowEnemy;
    FastEnemy fastEnemy;
    ZigzagEnemy zigzagEnemy;
    Boss1 boss1;
    Boss2 boss2;

    public Spawner(ObjectHandler objectHandler ){
        this.objectHandler = objectHandler;
    }

    public Player newPlayer(){
        player = new Player(objectHandler);
        objectHandler.addObj(player);
        return player;
    }

    public SlowEnemy newSlowEnemy(){
        slowEnemy = new SlowEnemy(objectHandler);
        objectHandler.addObj(slowEnemy);
        return slowEnemy;
    }

    public FastEnemy newFastEnemy(){
        fastEnemy  = new FastEnemy(objectHandler);
        objectHandler.addObj(fastEnemy);
        return fastEnemy;
    }

    public ZigzagEnemy newZigzagEnemy(){
        zigzagEnemy = new ZigzagEnemy(objectHandler);
        objectHandler.addObj(zigzagEnemy);
        return zigzagEnemy;
    }

    public Boss1 newBoss1(){
        boss1 = new Boss1(objectHandler);
        objectHandler.addObj(boss1);
        return boss1;
    }

    public Boss2 newBoss2(){
        boss2= new Boss2(objectHandler);
        objectHandler.addObj(boss2);
        return boss2;
    }
}

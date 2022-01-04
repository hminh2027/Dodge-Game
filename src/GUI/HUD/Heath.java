package GUI.HUD;

import java.awt.*;

public class Heath {
    private  double health = 100;
    private int width = 200;
    private int height = 30;
    private int x;
    private int y;

    public Heath(int x,int y){
        this.x = x;
        this.y = y;
    }

    public double getHealth(){
        return health;
    }

    public void setHealth(double health){
        this.health = health;
    }

    public void render(Graphics g) {
        if(health >66) g.setColor(Color.green);
        else if(20 < health && health <= 66) g.setColor(Color.orange);
        else g.setColor(Color.red);
        g.fillRect(x,y, (int) (health*2),height);
        g.setColor(Color.white);
        g.drawRect(x,  y,width,height);
    }
}

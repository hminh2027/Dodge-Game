package GUI.HUD;

import Logic.GameLogic;

import java.awt.*;

public class Score  {
    private int SCORE = 0;
    private int width = 15;
    private int height = 64;

    public Score(){}

    public void update(){
        if(!GameLogic.isDead && !GameLogic.isBoss) SCORE++;
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.drawString("SCORE: " + SCORE,width,height);
    }

    public int getScore(){return SCORE;}

    public void setScore(int score){SCORE=score;}
}

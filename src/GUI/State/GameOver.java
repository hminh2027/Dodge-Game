package GUI.State;

import GUI.Background.Background;
import GUI.HUD.Score;
import GUI.Window.GameWindow;
import Logic.GameLogic;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameOver {
    GameLogic gameLogic;
    Background background;
    Score score;
    private int highest_score;

    public GameOver(GameLogic gameLogic,Score score, int highest_score){
        background = new Background("background.png");
        this.highest_score = highest_score;
        this.gameLogic=gameLogic;
        this.score=score;
    }

    public void render(Graphics g) {
    //  Draw background
        background.render(g);
        g.setFont(new Font("Century Gothic", Font.BOLD, 90));
        g.setColor(Color.RED);
        g.drawString("GAME OVER", GameWindow.GAME_WIDTH/3-150, GameWindow.GAME_HEIGHT/5);

    //  Set font, size and color for Body
        g.setFont(new Font("Cosolas",Font.PLAIN,40));
        g.setColor(Color.white);
        g.drawString("Your score: "+ score.getScore(), 150, 400);
        g.drawString("Highest score: " + highest_score, 150, 500);
        g.drawString("Press R to replay!", 150, 700);
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key==KeyEvent.VK_R) gameLogic.restart();
    }
}

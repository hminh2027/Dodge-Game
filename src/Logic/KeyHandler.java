package Logic;

import GUI.Objects.Player.Player;
import GUI.State.GameOver;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter {
    Player player;
    GameOver gameOver;

    public KeyHandler(Player player, GameOver gameOver){
        this.player = player;
        this.gameOver = gameOver;
    }

    public void keyPressed(KeyEvent e){
        player.keyPressed(e);
        gameOver.keyPressed(e);
    }
    public void keyReleased(KeyEvent e){player.keyReleased(e);}
}

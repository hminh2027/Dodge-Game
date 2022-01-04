package Logic;

import Database.Database;
import GUI.Background.Background;
import GUI.HUD.Score;
import GUI.Objects.Player.Player;
import GUI.State.GameOver;
import IO.FileIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class GameLogic extends JPanel implements Runnable, ActionListener {
    //    Game variables
    private static final int DELAY = 5;
    private boolean running = false;
    public static boolean isDead = false;
    public static boolean isBoss = false;
    //    Package
    Timer timer;
    Thread thread;
    ObjectHandler objectHandler;
    Player player;
    Spawner spawner;
    Background background;
    Score score;
    GameOver gameOver;
    Level level;
    Database con;
    FileIO file;
    Properties p;
    ThemeAudioHandler theme;

    public GameLogic(Database con, Properties p, Dimension SCREEN_SIZE){
        this.p = p;
    //  Panel Properties
    this.setPreferredSize(SCREEN_SIZE);
    this.setFocusable(true);
    //  Init Libraries
    thread = new Thread(this);
    timer = new Timer(DELAY,this);
    score = new Score();
    objectHandler = new ObjectHandler();
    spawner = new Spawner(objectHandler);
    background = new Background("background.png");
    gameOver = new GameOver(this,score,con.getScore());
    this.con = con;
    theme = new ThemeAudioHandler();
    file = new FileIO();
    //  Init Objects
    init();
    }

    public void init(){
        background = new Background("background.png");
        theme.gameTheme();
        player = spawner.newPlayer();
        level = new Level(score,spawner,objectHandler,con,theme);
        level.generateLevel();
        this.addKeyListener(new KeyHandler(player,gameOver));
    }

    public void start(){
        thread.start();
        running = true;
    }

    public void stop(){
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void restart(){
        if(isDead){
            theme.restart();
            score.setScore(0);
            player.getHeath().setHealth(100);
            objectHandler.clearObj();
            init();
            isDead=false;
        }
    }

    public void render(Graphics g){
        if(running && !isDead){
            background.render(g);
            objectHandler.render(g);
            player.getHeath().render(g);
            score.render(g);
            level.render(g);
        }
        else if(isDead) gameOver.render(g);
        else stop();
    }

    public void update(){
        if(running && !isDead ){
            objectHandler.update();
            score.update();
            level.update();
        }
        else {
            stop();
        }
    }

    public void checkCollision(){
        objectHandler.checkCollision();
        if(player.getHeath().getHealth()<=0){
            isDead=true;
            gameOver();
            theme.loseTheme();
        }
    }

    public void gameOver(){
        if(score.getScore() > con.getScore()) con.updateScore(score.getScore());
        file.writeFile(score.getScore());
        level.setCurLevel(1);
        isDead=true;
        isBoss=false;
    }

    public void checkWin(){
        if(level.getCurLevel()== level.getLevelsSize()-1){
            gameOver();
            theme.winTheme();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        render(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            update();
            checkCollision();
            checkWin();
        }
        repaint();
    }

    @Override
    public void run() {
        timer.start();
    }
}

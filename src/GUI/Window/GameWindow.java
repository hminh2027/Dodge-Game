package GUI.Window;

import Database.Database;
import IO.FileIO;
import Logic.GameLogic;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Properties;

public class GameWindow extends JFrame {
    GameLogic gl;
    Database con;
    Properties p;
    FileIO file;
    //    Size variables
    public static int GAME_WIDTH ;
    public static int GAME_HEIGHT;
    private static Dimension SCREEN_SIZE;

    public GameWindow() throws IOException {
        //  Get Config
        p = new Properties();
        file = new FileIO();
        p = file.readProps();
        //  Set window setting
        GAME_WIDTH = Integer.parseInt(p.getProperty("GAME_WIDTH"));
        GAME_HEIGHT = Integer.parseInt(p.getProperty("GAME_HEIGHT"));
        SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
        //  Init Database
        con = new Database(p);
        //        Init Game Logic
        gl = new GameLogic(con,p,SCREEN_SIZE);
        this.add(gl);
        gl.start();
        //        Frame Props
        this.setTitle("DODGE");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}

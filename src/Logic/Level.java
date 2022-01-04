package Logic;

import Database.Database;
import GUI.HUD.Score;

import java.awt.*;
import java.util.Vector;

public class Level {
    Spawner spawner;
    Score score;
    ObjectHandler objectHandler;
    Database con;
    ThemeAudioHandler theme;

    private int width = 15;
    private int height = 64;
    private int count = 0;
    private int CUR_LEVEL = 1;
    private int levels_size;
    private Vector<Vector<Integer>> levels;

    public Level(Score score, Spawner spawner, ObjectHandler objectHandler, Database con, ThemeAudioHandler theme){
        this.con = con;
        this.score = score;
        this.spawner = spawner;
        levels = new Vector<>();
        this.levels = con.getLevels();
        this.levels_size = levels.size();
        this.objectHandler = objectHandler;
        this.theme = theme;
    }

    public void generateLevel(){
        int n = levels.get(CUR_LEVEL).size();

        for(int i=0;i<n;i++){
            int m = levels.get(CUR_LEVEL).get(i);

            switch (i){
                case 0:
                    for (int j=0;j<m;j++) spawner.newSlowEnemy();
                    break;
                case 1:
                    for (int j=0;j<m;j++) spawner.newFastEnemy();
                    break;
                case 2:
                    for (int j=0;j<m;j++) spawner.newZigzagEnemy();
                    break;
                case 3:
                    for (int j=0;j<m;j++) {objectHandler.clearObjButPlayer();spawner.newBoss1();GameLogic.isBoss=true;}
                    break;
                case 4:
                    for(int j=0;j<m;j++) {objectHandler.clearObjButPlayer();spawner.newBoss2();GameLogic.isBoss=true;}
                    break;
                default:
                    System.out.println("NOT FOUND ENEMY OBJ");
                    break;
            }
        }
    }

    public int getCurLevel(){return CUR_LEVEL;}
    public void setCurLevel(int n){CUR_LEVEL=n;}

    public int getLevelsSize(){return levels_size;}

    public void update(){
        CUR_LEVEL = (score.getScore() / 100);
        count++;
        if(GameLogic.isBoss){
            theme.bossTheme();
        //  Boss Level will last for 1000 then clear all obj except player
            if(count==1000){
                count=0;
                objectHandler.clearObjButPlayer();
                GameLogic.isBoss=false;
                theme.gameTheme();
            }
        }
        else {
        //  Each 100 point will level up
            if ( count==100 && CUR_LEVEL != levels_size){
                generateLevel();
                count=0;
            }
        }
    }

    public void render(Graphics g){
        g.setColor(Color.white);
        g.drawString("LEVEL: " + CUR_LEVEL,width,height+16);
    }
}

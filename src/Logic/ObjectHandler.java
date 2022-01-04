package Logic;

import GUI.Objects.Object;
import GUI.Objects.Player.Player;

import java.awt.*;
import java.util.LinkedList;

public class ObjectHandler {
    LinkedList<Object> object_list;

    public ObjectHandler(){
        object_list = new LinkedList<Object>();
    }

    public void update(){
        for(int i=0;i<object_list.size();i++){
            object_list.get(i).update();
        }
    }
    public void render(Graphics g){
        for(int i=0;i<object_list.size();i++){
            object_list.get(i).render(g);
        }
    }

    public void checkCollision(){
        for (int i=0;i<object_list.size();i++){
            object_list.get(i).checkCollision();
        }
    }
    public Object getObj(int i){return this.object_list.get(i);}
    public void clearObj(){this.object_list.clear();}
    public void addObj(Object obj){
        this.object_list.add(obj);
    }
    public void removeObj(Object obj){
        this.object_list.remove(obj);
    }
    public void clearObjButPlayer(){
            Player temp = (Player) object_list.get(0);
            object_list.clear();
            object_list.add(temp);
    }
}

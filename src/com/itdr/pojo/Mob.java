package com.itdr.pojo;

import com.itdr.client.MainClient;
import com.itdr.util.ImageMap;

import java.awt.*;

public class Mob {
    private static Image[] images = new Image[20];
    static {
        for (int i = 0; i <= 7; i++) {
            images[i] = ImageMap.getImage("mob_left"+i);
        }
    }
    public int x;
    public int y;
    private int height;
    private int width;
    public boolean live = true;
    private MainClient mc;
    private BloodBar bb;
    private int speed = 3;
    public Mob(int x,int y,MainClient mc){
        this.mc = mc;
        this.x = x;
        this.y = 520;
        this.width = images[0].getWidth(null);
        this.height = images[0].getHeight(null);
        this.bb = new BloodBar(x,y - 10,width,5);
    }
    /*怪物移动*/
    public void move(){
        x -= speed;
    }
//    int flyEnteredIndex = 0;
//    public void enterAction(){
//        flyEnteredIndex++;
//        if(flyEnteredIndex % 40 == 0){
//        }
//    }
    int count = 0;
    public void draw(Graphics g){
        if (!live){
            mc.mobs.remove(this);
        }
        if (count > 7){
            count = 0;
        }
        g.drawImage(images[count++],x,y,null);
        bb.draw(g);
        move();
//        enterAction();
    }


    public Rectangle getRectangle() {
        return new Rectangle(this.x,this.y,width,height);
    }
    class BloodBar{

        private int x;
        private int y;
        private int width;
        private int height;
        /*设置血条位置 */
        public BloodBar(int x,int y,int width,int height){
            this.x = x;
            this.y = y + 165;
            this.width = width;
            this.height = height;
        }
        public void mov(){
            x -= speed;
        }
        public void draw(Graphics g){
            mov();
            g.setColor(Color.red);
            g.drawRect(x,y,width,5);
            g.setColor(Color.red);
            g.fillRect(x,y,width,5);
        }
    }

}

package com.itdr.pojo;

import com.itdr.util.ImageMap;

import java.awt.*;

public class MobDie {
    private static Image[] images = new Image[100];
    static {
        for (int i = 0; i < 14; i++) {
            images[i] = ImageMap.getImage("mob_die" + i);
        }
    }
    private int x;
    private int y;
    private int width;
    private int height;
    public MobDie(int x,int y){
        this.x = x;
        this.y = y;
        this.height = images[0].getHeight(null);
        this.width = images[0].getWidth(null);
    }
    int count = 0;
    public void draw(Graphics g){
        if(count > 13){
            return;
        }
        g.drawImage(images[count++],x,y,null);
    }
}

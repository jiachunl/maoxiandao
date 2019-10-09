package com.itdr.pojo;

import com.itdr.client.MainClient;
import com.itdr.util.ImageMap;

import java.awt.*;

public class Marry {
    private static Image[] images = new Image[20];
    static {
        for (int i = 0; i <= 1; i++) {
            images[i] = ImageMap.getImage("marry_shan"+i);
        }
    }
    private int x;
    private int y;
    private int width;
    private int height;
    private MainClient mc;
    public Marry(int x,int y,MainClient mc){
        this.mc = mc;
        this.x = x;
        this.y = y;
        this.width = images[0].getWidth(null);
        this.height = images[0].getHeight(null);
    }
    int count = 0;
    public void draw(Graphics g){
        if (count > 1){
            count = 0;
        }
        g.drawImage(images[count++],x,y,null);
    }
}

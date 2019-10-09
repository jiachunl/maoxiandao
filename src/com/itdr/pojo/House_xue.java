package com.itdr.pojo;

import com.itdr.client.MainClient;
import com.itdr.util.ImageMap;

import java.awt.*;

public class House_xue {
    private static Image[] images = new Image[100];
    static {
        for (int i = 0; i <= 2; i++) {
            images[i] = ImageMap.getImage("house_xue"+i);
        }
    }
    private int x;
    private int y;
    private int width;
    private int height;
    private MainClient mc;
    public House_xue(int x, int y, MainClient mc){
        this.mc = mc;
        this.x = x;
        this.y = y;
        this.width = images[0].getWidth(null);
        this.height = images[0].getHeight(null);
    }
    int count = 0;
    public void draw(Graphics g){
        if (count > 2){
            count = 0;
        }
        g.drawImage(images[count++],x,y,null);
    }
}

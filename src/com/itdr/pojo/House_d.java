package com.itdr.pojo;

import com.itdr.util.ImgUtils;

import java.awt.*;

public class House_d {
    private Image image;
    private int x;
    private int y;
    private int width;
    private int height;
    public House_d(){
        this.image = ImgUtils.getImg("com/itdr/images/hose_inside/christmas.inside.3.0.png");
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
        this.x = 780;
        this.y = 168;
    }
    public void draw(Graphics g){
        g.drawImage(image,x,y,null);
    }
}

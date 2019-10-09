package com.itdr.pojo;

import com.itdr.util.ImgUtils;

import java.awt.*;

public class House_n {
    private Image image;
    private int x;
    private int y;
    private int width;
    private int height;
    public House_n(){
        this.image = ImgUtils.getImg("com/itdr/images/hose_inside/christmas.inside.1.gif");
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
        this.x = 380;
        this.y = 168;
    }
    public void draw(Graphics g){
        g.drawImage(image,x,y,null);
    }
}

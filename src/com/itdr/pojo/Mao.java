package com.itdr.pojo;

import com.itdr.client.MainClient;
import com.itdr.common.FrameSize;
import com.itdr.util.ImgUtils;

import java.awt.*;

public class Mao {
    private Image image;
    private int x;
    private int y;
    private int width;
    private int height;
//    private MainClient mc;
    public Mao(){
//        this.mc = mc;
        this.image = ImgUtils.getImg("com/itdr/images/maoxiandao.png");
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
        this.x = 370;
        this.y = 45;

    }
    public void draw(Graphics g){
        g.drawImage(image,x,y,null);
    }
}

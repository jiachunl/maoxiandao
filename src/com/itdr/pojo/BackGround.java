package com.itdr.pojo;

import com.itdr.common.FrameSize;
import com.itdr.util.ImgUtils;

import java.awt.*;

public class BackGround {
    private Image image;
    private int x;
    private int y;
    private int width;
    private int height;
    public BackGround(){
        this.image = ImgUtils.getImg("com/itdr/images/bgimg.jpg");
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
        this.x = 0;
        this.y = FrameSize.HEIGHT - this.height;
    }
    public void draw(Graphics g){
        g.drawImage(image,x,y,null);
    }
}

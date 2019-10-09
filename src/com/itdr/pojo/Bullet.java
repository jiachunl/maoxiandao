package com.itdr.pojo;

import com.itdr.client.MainClient;
import com.itdr.common.Direction;
import com.itdr.common.FrameSize;
import com.itdr.util.ImageMap;
import com.itdr.util.MusicUtils;

import java.awt.*;
import java.util.List;

public class Bullet {
    private Image image;
    private int x;
    private int y;
    private int width;
    private int height;
    private Direction dir;
    private int speed;
    private MainClient mc;
    private boolean live = true;
    public Bullet(int x,int y,Direction dir,MainClient mc){
        this.mc = mc;
        this.dir = dir;
        if (dir == Direction.LEFT){
            this.image = ImageMap.getImage("bullet_left");
            this.x = x - 45;
            this.y = y + 28;
        }else if (dir == Direction.RIGHT){
            this.image = ImageMap.getImage("bullet_right");
            this.x = x + 30;
            this.y = y + 28;
        }

        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
        this.speed = 30;
    }
    public void draw(Graphics g){
        if (!live){
            mc.bulletList.remove(this);
        }
        g.drawImage(image,x,y,null);
        move();
    }
    /*人物向左向右移动*/
    public void move(){
        if (dir == Direction.LEFT){
            this.x -= speed;
        }else if (dir == Direction.RIGHT){
            this.x += speed;
        }
    }
    public boolean hit(Mob mob){
        if (this.getRectangle().intersects(mob.getRectangle())){
            /*移除子弹和怪物*/
            this.live = false;
            mob.live = false;
            int a = width - 50;
            if(a <= 0){
                MobDie die = new MobDie(mob.x,mob.y);
                this.mc.mobDies.add(die);
            }
            return true;
        }
        return false;
    }
    public boolean hits(List<Mob> mobs){
        for (int i = 0; i < mobs.size(); i++) {
            if(hit(mobs.get(i))){
                MusicUtils.getMusic("E:\\Ideacode\\maoxiandao\\src\\com\\itdr\\images\\siwang.wav");
                return true;
            }
        }
        return false;
    }

    public Rectangle getRectangle(){
        return new Rectangle(this.x,this.y,width,height);
    }
}

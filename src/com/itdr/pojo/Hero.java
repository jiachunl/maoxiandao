package com.itdr.pojo;

import com.itdr.client.MainClient;
import com.itdr.common.Action;
import com.itdr.common.Direction;
import com.itdr.common.FrameSize;
import com.itdr.util.ImageMap;
import com.itdr.util.ImgUtils;
import com.itdr.util.MusicUtils;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.itdr.common.Direction.LEFT;
import static com.itdr.common.Direction.RIGHT;

public class Hero {
    private static Image[] images = new Image[100];
    static {
        for (int i = 0; i <= 4; i++) {
            images[i] = ImageMap.getImage("hero_walk_left" + i);
        }
        for (int i = 5; i <= 9; i++) {
            images[i] = ImageMap.getImage("hero_walk_right" + (i - 5));
        }
        for (int i = 10; i <= 13; i++) {
            images[i] = ImageMap.getImage("hero_shoot_left" + (i - 10));
        }
        for (int i = 14; i <= 17; i++) {
            images[i] = ImageMap.getImage("hero_shoot_right" + (i - 14));
        }
    }
    private Image image;
    public int x;
    public int y;
    private int height;
    private int width;
    private int speed = 10;
    private Direction direction;
    private Action action;
    private boolean left;
    private boolean right;
    private boolean walk;
    private boolean shoot;
    private boolean up;
    private MainClient mc;

    public Hero(MainClient mc){
        this.mc = mc;
        this.image = ImgUtils.getImg("com/itdr/images/hero/stand_r/stand1_0.png");
        this.height = image.getHeight(null);
        this.x = 100;
        this.y = 535;
        this.direction = RIGHT;
        this.action = Action.STAND;
    }
    int left_count = 0;
    int right_count = 5;
    int shoot_left_count = 10;
    int shoot_right_count = 14;
    public void draw(Graphics g){
        if(left_count > 4){
            left_count = 0;
        }
        if (right_count > 9){
            right_count = 5;
        }
        if (shoot_left_count > 13){
            shoot_left_count = 10;
        }
        if (shoot_right_count > 17){
            shoot_right_count = 14;
        }
        switch (direction){
            case LEFT:
                switch (action){
                    case JUMP:
                        break;
                    case SHOOT:
                        g.drawImage(images[shoot_left_count++],x,y,null);
                        break;
                    case WALK:
                        g.drawImage(images[left_count++],x,y,null);
                        break;
                    case STAND:
                        g.drawImage(ImgUtils.getImg("com/itdr/images/hero/stand_l/stand1_0.png"),x,y,null);
                        break;
                }
                break;
            case RIGHT:
                switch (action){
                    case JUMP:
                        break;
                    case SHOOT:
                        g.drawImage(images[shoot_right_count++],x,y,null);
                        break;
                    case WALK:
                        g.drawImage(images[right_count++],x,y,null);
                        break;
                    case STAND:
                        g.drawImage(image,x,y,null);
                        break;
                }
                break;
        }
        move();
    }
/*人物移动*/
    public void move(){
        if (up){
            y -= 10;
        }
        if(left){
            this.direction = LEFT;
        }else if(right){
            this.direction = RIGHT;
        }
        if(walk){
            if (left){
                this.action = Action.WALK;
                x -= speed;
            }else if (right){
                this.action = Action.WALK;
                x += speed;
            }
        }else if(shoot){
            this.action = Action.SHOOT;
            shoot();
        }else {
            this.action = Action.STAND;
        }
        outBounds();
    }
    public void outBounds(){
        if(x <= 0){
            this.x = 0;
        }
        if(x > FrameSize.WIDTH - width){
            x = FrameSize.WIDTH - width;
        }
    }
/*键盘控制人物移动方向*/
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                left = true;
                walk = true;
                break;
            case KeyEvent.VK_D:
                right = true;
                walk = true;
                break;
            case KeyEvent.VK_W:
//                left = true;
                right = true;
                up = true;
                break;
            case KeyEvent.VK_J:
                shoot = true;
                break;
        }
    }
/*键盘抬起执行的动作*/
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                walk = false;
                left = false;
                break;
            case KeyEvent.VK_D:
                walk = false;
                right = false;
                break;
            case KeyEvent.VK_J:
                shoot = false;
                break;
            case KeyEvent.VK_W:
                up = false;
                x += 30;
                y = 505;
                break;
        }
    }
    /*射击*/
    public void shoot() {
        MusicUtils.getMusic("E:\\Ideacode\\maoxiandao\\src\\com\\itdr\\images\\bullet.wav");
        this.mc.bulletList.add(new Bullet(this.x,this.y,this.direction,mc));
    }
}

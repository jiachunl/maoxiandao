package com.itdr.util;

import java.awt.*;
import java.util.HashMap;

public class ImageMap {
    private static HashMap<String,Image> images = new HashMap<>();
    static {
        images.put("bg",ImgUtils.getImg("com/itdr/images/bgimg.jpg"));
        for (int i = 0; i <= 4 ; i++) {
            images.put("hero_walk_left" + i,ImgUtils.getImg("com/itdr/images/hero/walk_l/walk1_"+i+".png"));
        }
        for (int i = 0; i <= 4; i++) {
            images.put("hero_walk_right" + i,ImgUtils.getImg("com/itdr/images/hero/walk_r/walk1_"+i+".png"));
        }
        for (int i = 0; i <= 3; i++) {
            images.put("hero_shoot_left" + i,ImgUtils.getImg("com/itdr/images/hero/shoot_l/shoot1_"+i+".png"));
        }
        for (int i = 0; i <= 3; i++) {
            images.put("hero_shoot_right" + i,ImgUtils.getImg("com/itdr/images/hero/shoot_r/shoot1_"+i+".png"));
        }
        images.put("bullet_left",ImgUtils.getImg("com/itdr/images/left_img.png"));
        images.put("bullet_right",ImgUtils.getImg("com/itdr/images/right_img.png"));
        for (int i = 0; i <= 7; i++) {
            images.put("mob_left"+i,ImgUtils.getImg("com/itdr/images/mob/mob_left/0"+i+".png"));
        }
        for (int i = 0; i <= 13; i++) {
            images.put("mob_die" + i,ImgUtils.getImg("com/itdr/images/mob/die/"+i+".png"));
        }
        images.put("mob_q",ImgUtils.getImg("com/itdr/images/mob/mob_l/1.gif"));
        images.put("mob_w",ImgUtils.getImg("com/itdr/images/mob/mob_l/2.gif"));
        images.put("mob_e",ImgUtils.getImg("com/itdr/images/mob/mob_l/3.gif"));
        images.put("mob_r",ImgUtils.getImg("com/itdr/images/mob/mob_l/4.gif"));
        images.put("mob_t",ImgUtils.getImg("com/itdr/images/mob/mob_l/5.gif"));
        for (int i = 0; i <= 1; i++) {
            images.put("marry_shan" + i,ImgUtils.getImg("com/itdr/images/marry/"+i+".png"));
        }
        for (int i = 0; i <= 33; i++) {
            images.put("house_6_s" + i,ImgUtils.getImg("com/itdr/images/house_6/"+i*30+".png"));
        }
        for (int i = 0; i <= 33; i++) {
            images.put("house_7_h" + i,ImgUtils.getImg("com/itdr/images/house_7/"+i*30+".png"));
        }
        for (int i = 0; i <= 7; i++) {
            images.put("tree" + i,ImgUtils.getImg("com/itdr/images/tree/"+i*150+".png"));
        }
        images.put("house_b",ImgUtils.getImg("com/itdr/images/hose_inside/b.gif"));
        images.put("house_c",ImgUtils.getImg("com/itdr/images/hose_inside/c.gif"));
        for (int i = 0; i <= 11; i++) {
            images.put("fire" + i,ImgUtils.getImg("com/itdr/images/fire/"+i*150+".png"));
        }
        for (int i = 0; i <= 8; i++) {
            images.put("house_tree" + i,ImgUtils.getImg("com/itdr/images/house_tree/"+i*150+".png"));
        }
        for (int i = 0; i <= 7; i++) {
            images.put("house_xing" + i,ImgUtils.getImg("com/itdr/images/house_xing/"+i*210+".png"));
        }
        for (int i = 0; i <= 2; i++) {
            images.put("house_xue" + i,ImgUtils.getImg("com/itdr/images/house_xue/"+i*510+".png"));
        }
        images.put("maoxiandao",ImgUtils.getImg("com/itdr/images/maoxiandao.png"));

    }
    public static Image getImage(String key){
        return images.get(key);
    }
}

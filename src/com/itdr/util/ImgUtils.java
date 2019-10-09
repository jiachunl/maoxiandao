package com.itdr.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImgUtils {
    /*加载图片路径*/
    public static Image getImg(String path){
        BufferedImage image = null;
        URL url = ImgUtils.class.getClassLoader().getResource(path);
        try {
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}

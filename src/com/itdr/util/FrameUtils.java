package com.itdr.util;

import com.itdr.common.FrameSize;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameUtils extends Frame {

    // 解决图片闪烁的问题，用双缓冲方法解决闪烁问题
    Image backImg = null;

    // 重写update()方法，在窗口的里层添加一个虚拟的图片
    @Override
    public void update(Graphics g) {
        if (backImg == null) {
            // 如果虚拟图片不存在，创建一个和窗口一样大小的图片
            backImg = createImage(FrameSize.WIDTH,FrameSize.HEIGHT);
        }
        // 获取到虚拟图片的画笔
        Graphics backg = backImg.getGraphics();
        Color c = backg.getColor();
        backg.setColor(Color.WHITE);
        backg.fillRect(0, 0, FrameSize.WIDTH,FrameSize.HEIGHT);
        backg.setColor(c);
        // 调用虚拟图片的paint()方法，每50ms刷新一次
        paint(backg);
        g.drawImage(backImg, 0, 0, null);
    }

    /*加载窗体，设置窗口大小*/
    public void loadFrame(){
        this.setSize(FrameSize.WIDTH,FrameSize.HEIGHT);
        /*窗体相对于屏幕位置*/
        this.setLocationRelativeTo(null);
        /*窗体可见*/
        this.setVisible(true);
        this.setBackground(Color.white);
        /*窗体标题*/
        this.setTitle("冒险岛");
        /*窗体监听事件，关闭窗体*/
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        new MyThread().start();
    }


    /*线程  反复调用画的方法   内部类*/
    class MyThread extends Thread{
        @Override
        public void run() {
            for(;;){
                repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

package com.itdr.client;

import com.itdr.pojo.*;
import com.itdr.util.FrameUtils;
import com.itdr.util.MusicUtils;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class MainClient extends FrameUtils {
//    BackGround bg = new BackGround();
    Hero hero = new Hero(this);
    public List<Fire> fires = new ArrayList<>();
    public List<Bullet> bulletList = new ArrayList<>();
    public List<Mob> mobs = new ArrayList<>();
    public List<MobDie> mobDies = new ArrayList<>();
//    public List<Marry> marries = new ArrayList<>();
    House_i house_i = new House_i();
    House_n house_n = new House_n();
    House_s house_s = new House_s();
    House_d house_d = new House_d();
    House_e house_e = new House_e();
    House_b house_b = new House_b();
    House_c house_c = new House_c();
    public List<House_6> house_6s = new ArrayList<>();
    public List<House_6_1> house_6_1s = new ArrayList<>();
    public List<House_6_2> house_6_2s = new ArrayList<>();
    public List<House_6_3> house_6_3s = new ArrayList<>();
    public List<House_6_4> house_6_4s = new ArrayList<>();
    public List<House_6_5> house_6_5s = new ArrayList<>();
    public List<House_6_6> house_6_6s = new ArrayList<>();
    public List<House_6_7> house_6_7s = new ArrayList<>();
    public List<House_6_8> house_6_8s = new ArrayList<>();
    public List<House_7> house_7s = new ArrayList<>();
    public List<Tree> trees = new ArrayList<>();
    public List<House_tree> house_trees = new ArrayList<>();
    public List<House_xing> house_xings = new ArrayList<>();
    public List<House_xue> house_xues = new ArrayList<>();
    Mao mao = new Mao();
        @Override
    public void paint(Graphics g) {

        /*用image类型做接收，画背景图*/

            for (int i = 0; i < fires.size(); i++) {
                fires.get(i).draw(g);
            }
        house_i.draw(g);
        house_n.draw(g);
        house_s.draw(g);
        house_d.draw(g);
        house_e.draw(g);
        house_b.draw(g);
        house_c.draw(g);
//        bg.draw(g);
        hero.draw(g);
        for (int i = 0; i < bulletList.size(); i++) {
            Bullet bullet = bulletList.get(i);
            bullet.draw(g);
            bullet.hits(mobs);
        }
        for (int i = 0; i < mobs.size(); i++) {
            mobs.get(i).draw(g);
        }
        for (int i = 0; i < mobDies.size(); i++) {
            mobDies.get(i).draw(g);
        }
//        for (int i = 0; i < marries.size(); i++) {
//            marries.get(i).draw(g);
//        }
            mao.draw(g);
            for (int i = 0; i < house_6s.size(); i++) {
                house_6s.get(i).draw(g);
            }for (int i = 0; i < house_6_1s.size(); i++) {
                house_6_1s.get(i).draw(g);
            }for (int i = 0; i < house_6_2s.size(); i++) {
                house_6_2s.get(i).draw(g);
            }for (int i = 0; i < house_6_3s.size(); i++) {
                house_6_3s.get(i).draw(g);
            }for (int i = 0; i < house_6_4s.size(); i++) {
                house_6_4s.get(i).draw(g);
            }for (int i = 0; i < house_6_5s.size(); i++) {
                house_6_5s.get(i).draw(g);
            }for (int i = 0; i < house_6_6s.size(); i++) {
                house_6_6s.get(i).draw(g);
            }for (int i = 0; i < house_6_7s.size(); i++) {
                house_6_7s.get(i).draw(g);
            }for (int i = 0; i < house_6_8s.size(); i++) {
                house_6_8s.get(i).draw(g);
            }
            for (int i = 0; i < house_7s.size(); i++) {
                house_7s.get(i).draw(g);
            };
            for (int i = 0; i < trees.size(); i++) {
                trees.get(i).draw(g);
            }
//            for (int i = 0; i < house_trees.size(); i++) {
//                house_trees.get(i).draw(g);
//            }
            for (int i = 0; i < house_xings.size(); i++) {
                house_xings.get(i).draw(g);
            }
            for (int i = 0; i < house_xues.size(); i++) {
                house_xues.get(i).draw(g);
            }


    }

    @Override
    public void repaint() {
        super.repaint();
    }

    @Override
    public void loadFrame() {

            //播放背景音乐
        MusicUtils.getMusic("E:\\Ideacode\\maoxiandao\\src\\com\\itdr\\images\\music.wav");
        /*在窗体内加载怪物*/

        for (int i = 0; i < 100; i++) {
            mobs.add(new Mob( 1400+ i*130,330,this));
        }
//        this.mao.add(new Marry(570,50,this));
//        this.mao.add(new Mao());
        this.house_6s.add(new House_6(175,250,this));
        this.house_6_1s.add(new House_6_1(258,210,this));
        this.house_6_2s.add(new House_6_2(350,250,this));
        this.house_6_3s.add(new House_6_3(375,150,this));
        this.house_6_4s.add(new House_6_4(455,200,this));
        this.house_6_5s.add(new House_6_5(580,178,this));
        this.house_6_6s.add(new House_6_6(665,200,this));
        this.house_6_7s.add(new House_6_7(405,395,this));
        this.house_7s.add(new House_7(206,230,this));
        this.trees.add(new Tree(1060,300,this));
        this.fires.add(new Fire(1060,300,this));
//        this.house_trees.add(new House_tree(100,100,this));
        this.house_xings.add(new House_xing(1150,40,this));
        this.house_xues.add(new House_xue(10,40,this));
        super.loadFrame();
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                hero.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                hero.keyReleased(e);
            }
        });

}
    public static void main(String[] args) {
        new MainClient().loadFrame();
    }
}

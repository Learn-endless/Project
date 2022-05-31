package com.donghu.image;

import com.donghu.enamy.Enamy;

import java.awt.*;
import java.util.ArrayList;

public class GameUtils {

    //关卡等级
    public static int level = 0;

    //使用集合在存放所有的敌方鱼类
    public static ArrayList<Enamy> enamyList = new ArrayList<>();

    //引入背景图片资源
    public static Image blackBoard = Toolkit.getDefaultToolkit().createImage("images/sea.jpg");

    //引入小海马往右的图片
    public static Image enamy_1_r = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish1_r.gif");
    //引入小海马往左的图片
    public static Image enamy_1_l = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish1_l.gif");

    //引入条纹鱼往右的图片
    public static Image enamy_2_r = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish2_r.png");
    //引入条纹鱼往左的图片
    public static Image enamy_2_l = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish2_l.png");

    //引入剑鱼往右的图片
    public static Image enamy_3_r = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish3_r.png");
    //引入剑鱼往左的图片
    public static Image enamy_3_l = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish3_l.png");

    //引入boss鱼的图片
    public static Image enamyBoss = Toolkit.getDefaultToolkit().createImage("images/enemyFish/boss.gif");

    //引入我方鱼类图片
    public static  Image myFish_r = Toolkit.getDefaultToolkit().createImage("images/myFish/myfish_right.gif");
    public static  Image myFish_l = Toolkit.getDefaultToolkit().createImage("images/myFish/myfish_left.gif");

    //绘制文字的工具类
    public static  void drawWord(Graphics g, String str, Color color,int size, int x, int y){
        g.setColor(color);
        g.setFont(new Font("仿宋",Font.BOLD,size));
        g.drawString(str,x,y);
    }
}

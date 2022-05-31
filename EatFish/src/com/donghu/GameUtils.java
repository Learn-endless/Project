package com.donghu;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//10.创建一个工具类
public class GameUtils {
    //关卡等级
    static int level=1;
    //分数
    static int count = 0;

    //方向控制
    static boolean UP = false;
    static boolean DOWN = false;
    static boolean LEFT = false;
    static boolean RIGHT = false;
    //9-1 我方鱼集合
    public static List<MyFish> MyListList = new ArrayList<>();
    public static Image bgimg = Toolkit.getDefaultToolkit().createImage("images/sea.jpg");
    //11.回到窗口类中重写paint方法
    //9-1 敌方鱼集合
    public static List<Enamy> EnamyList = new ArrayList<>();
    //在工具类中定义静态的图片资源
    //敌方鱼类-海马-往右
    public static Image enamy1_r_img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish1_r.gif");
    //敌方鱼类-条纹鱼-往右
    public static Image enamy2_r_img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish2_r.png");
    //敌方鱼类-剑鱼-往右
    public static Image enamy3_r_img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish3_r.png");
    //敌方鱼类-海马-往左
    public static Image enamy1_l_img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish1_l.gif");
    //敌方鱼类-条纹鱼-往左
    public static Image enamy2_l_img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish2_l.png");
    //敌方鱼类-剑鱼-往左
    public static Image enamy3_l_img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish3_l.png");

    // 9 - 1我方鱼的图片资源
    //我方鱼类-金鱼-往右
    public static Image myfish_r_img = Toolkit.getDefaultToolkit().createImage("images/myFish/myfish_right.gif");

    //我方鱼类-金鱼-往左
    public static Image myfish_l_img = Toolkit.getDefaultToolkit().createImage("images/myFish/myfish_left.gif");

    //添加boss鱼图片
    public static Image boss_img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/boss.gif");


    //绘制文字工具类
    /**
     * @param g       画笔
     * @param str     字符串内容
     * @param color   字体颜色
     * @param size    字体大小
     * @param x       字体位置(x)
     * @param y       字体位置(y)
     */
    public static void drawWord(Graphics g,String str,Color color,int size,int x, int y){
        g.setColor(color);
        g.setFont(new Font("仿宋",Font.BOLD,size));
        g.drawString(str,x,y);
    }
}

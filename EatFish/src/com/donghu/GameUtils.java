package com.donghu;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//10.创建一个工具类
public class GameUtils {
    //9-1 敌方鱼集合
    public static List<Enamy> EnamyList = new ArrayList<>();

    //在工具类中定义静态的图片资源
    public static Image bgimg = Toolkit.getDefaultToolkit().createImage("images/sea.jpg");
    //11.回到窗口类中重写paint方法

    //7-1 敌方鱼类
    public static Image enamy1_img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish1_r.gif");
}

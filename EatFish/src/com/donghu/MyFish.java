package com.donghu;

import java.awt.*;

//我方鱼类
public class MyFish {
    Image img = GameUtils.myfish_l_img;  //图片
    //坐标
    int x = 700;int y = 500;int width = 50;int height = 50;
    int speed = 20;     //速度
    int level = 1;      //等级
    //绘制自身的方法
    public void paintSelf(Graphics g){
        logic();
        g.drawImage(img,x,y,width+GameUtils.count,height+GameUtils.count,null);
    }
    //碰撞检测方法
    public Rectangle grtRect(){
        return new Rectangle(x,y,width+GameUtils.count,height+GameUtils.count);
    }
    //定义使用键盘控制我方鱼移动的方法
    public void logic(){
        if(GameUtils.UP){ y=y-speed; }     //向上移动
        if(GameUtils.DOWN){ y=y+speed; }   //向下移动
        if(GameUtils.LEFT){ x=x-speed;img = GameUtils.myfish_l_img;}//向左移动,调用向左的图片
        if(GameUtils.RIGHT){x=x+speed;img = GameUtils.myfish_r_img;}//向右移动,调用向右的的图片
    }
}

package com.donghu;

import java.awt.*;

//我方鱼类
public class MyFish {
    //图片
    Image img = GameUtils.myfish_l_img;
    //坐标
    int x = 700;
    int y = 500;
    int width = 50;
    int height = 50;
    //速度
    int speed = 20;
    //等级
    int level = 1;

    //绘制自身的方法
    public void paintSelf(Graphics g){
        logic();
        g.drawImage(img,x,y,width,height,null);
    }

    //碰撞检测方法
    public Rectangle grtRect(){
        return new Rectangle(x,y,width,height);
    }

    //定义使用键盘控制我方鱼移动的方法
    public void logic(){
        if(GameUtils.UP){
            y=y-speed;

        }
        if(GameUtils.DOWN){
            y=y+speed;
        }
        if(GameUtils.LEFT){
            //向左移动
            x=x-speed;
            //调用向左的图片
            img = GameUtils.myfish_l_img;
        }
        if(GameUtils.RIGHT){
            //向右移动
            x=x+speed;
            //调用向右的的图片
            img = GameUtils.myfish_r_img;
        }
    }
}

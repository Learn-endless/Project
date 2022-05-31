package com.donghu.myfish;

import com.donghu.image.GameUtils;

import java.awt.*;

//我方鱼的
public class MyFish {
    //图片的url
    public Image image = GameUtils.myFish_r;
    //位置坐标
    public int x = 585;
    public int y = 425;
    //初始大小
    public int width = 50;
    public int height = 50;
    //速度
    public int speed = 20;
    //我方鱼的等级
    public int level = 1;
    //分数
    public int count = 0;

    //我方鱼移动的方向
    public boolean UP = false;
    public boolean DOWN = false;
    public boolean LEFT = false;
    public boolean RIGHT = false;

    //键盘控制的方法
    private void logic(){
        if(UP){
            y = y - speed;
        }
        if(DOWN){
            y = y + speed;
        }
        if(LEFT){
            x = x - speed;
            //同时设置图片
            image = GameUtils.myFish_l;
        }
        if(RIGHT){
            x = x + speed;
            image = GameUtils.myFish_r;
        }
    }

    //绘制自身的方法
    public void paintSelf(Graphics g){
        logic();
        g.drawImage(image,x,y,width+count,height+count,null);
    }

    //碰撞检测方法
    public Rectangle getRec(){
        return new Rectangle(x,y,width+count,height+count);
    }
}

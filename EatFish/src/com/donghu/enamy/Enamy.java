package com.donghu.enamy;

import java.awt.*;

//敌方鱼的父类
public abstract class Enamy {
    //图片的url
    public Image image;
    //定义图片的坐标
    public int x;
    public int y;
    //图片的大小
    public int width;
    public int height;
    //速度
    public int speed;
    //方向
    public int dir;    //1表示从左往右,-1表示从右往左
    //敌方鱼的等级
    public int type;
    //敌方鱼的积分
    public int count;

    //绘制自身的方法
    public void paintSelf(Graphics g){
        g.drawImage(image,x,y,width,height,null);
    }
    //自身碰撞检测的方法
    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }
}

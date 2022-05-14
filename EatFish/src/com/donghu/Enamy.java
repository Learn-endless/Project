package com.donghu;

import java.awt.*;

//7-2 创建敌方鱼类
public class Enamy {
    //定义图片
    Image img;
    //坐标
    int x;
    int y;
    int width;
    int height;
    //速度
    int speed;
    //类型
    int type;
    //方向
    int dir = 1;
    //积分
    int count;

    public Enamy(Image img, int x, int y, int width, int height, int speed, int type, int dir, int count) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.type = type;
        this.dir = dir;
        this.count = count;
    }

    //绘制自身的方法
    public void paintSelf(Graphics g){
        g.drawImage(img,x,y,width,height,null);
    }
    //碰撞检测方法
    public Rectangle grtRect(){
        return new Rectangle(x,y,width,height);
    }
    //敌方鱼的左类
    static class Enamy_1_L extends Enamy{
        Enamy_1_L(){
            super(GameUtils.enamy1_img,45,(int)(Math.random()*700+100),45,69,5,1,1,0);

        }
    }
}

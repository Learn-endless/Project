package com.donghu;

import java.awt.*;

public class Enamy2Left extends Enamy{
    public Enamy2Left() {
        super(GameUtils.enamy2_l_img,1300,(int)(Math.random()*700+100),45,69,3,2,-1,2);
    }
    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img,x,y,width*2,height*2,null);
    }
    @Override
    //碰撞检测方法
    public Rectangle grtRect(){
        return new Rectangle(x,y,width*2,height*2);
    }
}

class Enamy2Right extends Enamy2Left{
    Enamy2Right(){
        this.img = GameUtils.enamy2_r_img;
        this.dir = 1;
        this.x = 45;
    }
}


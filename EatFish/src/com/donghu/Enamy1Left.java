package com.donghu;

import java.awt.*;

public class Enamy1Left extends Enamy{
    public Enamy1Left() {
        super(GameUtils.enamy1_l_img,1300,(int)(Math.random()*700+100),45,69,2,1,-1,1);
    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img,x,y,width,height,null);
    }
    @Override
    //碰撞检测方法
    public Rectangle grtRect(){
        return new Rectangle(x,y,width,height);
    }
}

class Enamy1Right extends  Enamy1Left{
    public Enamy1Right(){
        this.x = 45;
        this.dir = 1;
        this.img = GameUtils.enamy1_r_img;
    }
}

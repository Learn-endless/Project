package com.donghu;

import java.awt.*;

public class Enamy3Left extends Enamy{
    public Enamy3Left() {
        super(GameUtils.enamy3_l_img,1300,(int)(Math.random()*700+100),45,69,5,3,-1,3);
    }
    public Rectangle getRec(){
        return new Rectangle(x+40,y+30,width-80,height-60);
    }
    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img,x,y,width*5,height*2,null);
    }
    @Override
    //碰撞检测方法
    public Rectangle grtRect(){
        return new Rectangle(x,y,width*5,height*2);
    }
}
class Enamy3Right extends Enamy3Left{
    Enamy3Right(){
        this.x = 45;
        this.img = GameUtils.enamy3_r_img;
        this.dir = 1;
    }
}

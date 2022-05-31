package com.donghu.enamy;

import com.donghu.image.GameUtils;

import java.awt.*;

public class Enamy_3_R extends Enamy{
    public Enamy_3_R(){
        this.x = -300;
        this.y = (int)(Math.random()*600+100);
        this.width = 150;
        this.height = 75;
        this.speed = 10;
        this.count = 3;
        this.type = 3;
        this.dir = 1;
        this.image = GameUtils.enamy_3_r;
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x+40,y+30,width-80,height-60);
    }
}

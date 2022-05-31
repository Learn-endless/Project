package com.donghu.enamy;

import com.donghu.image.GameUtils;

public class Enamy_2_R extends Enamy{
    public Enamy_2_R(){
        this.x = -100;
        this.y = (int)(Math.random()*600+100);
        this.width = 60;
        this.height = 60;
        this.speed = 7;
        this.count = 2;
        this.type = 2;
        this.dir = 1;
        this.image = GameUtils.enamy_2_r;
    }
}

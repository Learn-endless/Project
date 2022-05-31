package com.donghu.enamy;

import com.donghu.image.GameUtils;

public class EnamyBoss extends Enamy{
    public EnamyBoss(){
        this.x = -1000;
        this.y = (int)(Math.random()*600+100);
        this.width = 220;
        this.height = 220;
        this.speed = 100;
        this.count = 0;
        this.type = 10;
        this.dir = 1;
        this.image = GameUtils.enamyBoss;
    }
}

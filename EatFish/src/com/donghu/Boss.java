package com.donghu;

import java.awt.*;

public class Boss extends Enamy{
    public Boss(){
        super(GameUtils.boss_img,-1000,(int)(Math.random()*700+100),45,69,100,10,1,0);
    }
}

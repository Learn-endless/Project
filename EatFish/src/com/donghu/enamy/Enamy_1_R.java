package com.donghu.enamy;

import com.donghu.image.GameUtils;

//第一条敌方鱼实体类,往右移动
public class Enamy_1_R extends Enamy{
    //构造方法,赋初始值
    public Enamy_1_R(){
        this.x = 45;
        this.y = (int)(Math.random()*600+100);
        this.width = 30;
        this.height = 55;
        this.speed = 5;
        this.count = 1;
        this.type = 1;
        this.dir = 1;
        this.image = GameUtils.enamy_1_r;
    }
}

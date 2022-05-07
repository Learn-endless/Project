package com.donghu;

import java.awt.*;

//5.游戏开始时的背景添加
//5-1 创建一个背景图片的实体类
public class Bg {
    //5-2 编写绘制图片的方法
    void paintSelf(Graphics g){
        //5-3 在绘制方法中定义所需要的参数
        g.drawImage(GameUtils.bgimg,0,0,null);
        //在窗口类中获取背景类对象
    }
}

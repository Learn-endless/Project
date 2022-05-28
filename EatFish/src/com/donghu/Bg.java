package com.donghu;

import java.awt.*;

//5.游戏开始时的背景添加
//5-1 创建一个背景图片的实体类
public class Bg {
    //5-2 编写绘制图片的方法
    void paintSelf(Graphics g, int fishLevel){
        //5-3 在绘制方法中定义所需要的参数
        g.drawImage(GameUtils.bgimg,0,0,null);
        switch (GameWin.state){
            case 0:
                GameUtils.drawWord(g,"开始",Color.red,80,700,500);
                break;
            case 1:
//                GameUtils.drawWord(g,"积分"+GameUtils.count,Color.ORANGE,50,200,120);
//                GameUtils.drawWord(g,"难度"+GameUtils.level,Color.ORANGE,50,400,120);
//                GameUtils.drawWord(g,"等级"+fishLevel,Color.ORANGE,50,600,120);
                break;
            case 2:
                break;
            case 3:
//                GameUtils.drawWord(g,"积分"+GameUtils.count,Color.ORANGE,50,200,120);
//                GameUtils.drawWord(g,"难度"+GameUtils.level,Color.ORANGE,50,400,120);
//                GameUtils.drawWord(g,"等级"+fishLevel,Color.ORANGE,50,600,120);
//                GameUtils.drawWord(g,"胜利",Color.red,80,700,500);
                break;
            case 4:
                break;
        }
    }
}

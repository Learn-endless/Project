package com.donghu.controller;

import com.donghu.game.GameWin;
import com.donghu.image.GameUtils;
import com.donghu.myfish.MyFish;

import java.awt.*;

public class BlackBoard {
    //绘制背景图片
    public void paintSelf(Graphics g, MyFish myFish){
        g.drawImage(GameUtils.blackBoard,0,0,null);
        //界面绘制
        switch (GameWin.state){
            case 0:
                GameUtils.drawWord(g,"开始",Color.green,50,585,425);
                break;
            case 1:
                GameUtils.drawWord(g,"积分"+myFish.count,Color.red,50,120,120);
                GameUtils.drawWord(g,"难度"+GameUtils.level,Color.red,50,520,120);
                GameUtils.drawWord(g,"小金鱼等级"+myFish.level,Color.red,50,920,120);
                break;
            case 2:
                GameUtils.drawWord(g,"积分"+myFish.count,Color.red,50,120,120);
                GameUtils.drawWord(g,"难度"+GameUtils.level,Color.red,50,520,120);
                GameUtils.drawWord(g,"小金鱼等级"+myFish.level,Color.red,50,920,120);
                GameUtils.drawWord(g,"通关失败!!!",Color.red,80,470,430);
                break;
            case 3:
                GameUtils.drawWord(g,"积分"+myFish.count,Color.red,50,120,120);
                GameUtils.drawWord(g,"难度"+GameUtils.level,Color.red,50,520,120);
                GameUtils.drawWord(g,"小金鱼等级"+myFish.level,Color.red,50,920,120);
                GameUtils.drawWord(g,"游戏胜利!",Color.red,80,470,430);
                break;
            case 4:
                GameUtils.drawWord(g,"积分"+myFish.count,Color.red,50,120,120);
                GameUtils.drawWord(g,"难度"+GameUtils.level,Color.red,50,520,120);
                GameUtils.drawWord(g,"小金鱼等级"+myFish.level,Color.red,50,920,120);
                GameUtils.drawWord(g,"游戏暂停!",Color.red,80,470,430);
                break;
            case 5:
                break;
        }
    }
}

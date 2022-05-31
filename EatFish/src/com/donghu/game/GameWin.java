package com.donghu.game;

import com.donghu.controller.BlackBoard;
import com.donghu.enamy.*;
import com.donghu.image.GameUtils;
import com.donghu.myfish.MyFish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//创建一个窗口类（通过继承JFrame）
public class GameWin extends JFrame {
    //定义游戏状态：0:未开始 1:游戏中  2:通关失败  3:通关成功 4:暂停  5:重新开始
    public static int state = 0;

    //背景图片的url
    public Image offScreenImage;
    //高和宽
    public int width = 1280;
    public int height = 800;

    //敌方鱼类
    Enamy enamy;
    EnamyBoss boss = new EnamyBoss();

    //我方鱼类
    MyFish myFish = new MyFish();

    //背景图片
    public BlackBoard blackBoard = new BlackBoard();

    //添加一个技术器
    int time;

    //判断boss是否出现
    boolean isboss = false;

    double random;

    //游戏启动的方法
    public void launch(){
        //设置窗口是否可见     在子类中可以调用父类的公开方法
        this.setVisible(true);
        //设置窗口的大小
        this.setSize(width,height);
        //设置窗口是否可变
        this.setResizable(false);
        //设置窗口位置居中
        this.setLocationRelativeTo(null);
        //设置窗口标题
        this.setTitle("东湖学院:大鱼吃小鱼");
        //设置窗口关闭的按钮
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置窗口的点击事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getButton() == 1 && state == 0){
                    state = 1;
                    repaint();
                }
                //在游戏状态为失败/胜利/暂停时点击鼠标左键，游戏重新开始
                if(e.getButton() == 1 && (state == 1 || state == 2 || state == 3 || state == 4 || state == 5)){
                    reGame();
                    state = 1;
                }
            }
        });

        //键盘控制
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                //wasd
                if(e.getKeyCode() == 87){
                    myFish.UP = true;
                }
                if(e.getKeyCode() == 83){
                    myFish.DOWN = true;
                }
                if(e.getKeyCode() == 65){
                    myFish.LEFT = true;
                }
                if(e.getKeyCode() == 68){
                    myFish.RIGHT = true;
                }
                //空格表示游戏暂停
                if(e.getKeyCode() == 32){
                    switch (state){
                        case 1:
                            state = 4;
                            break;
                        case 4:
                            state = 1;
                            break;
                    }
                }
            }
            //键盘抬起
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                //wasd
                if(e.getKeyCode() == 87){
                    myFish.UP = false;
                }
                if(e.getKeyCode() == 83){
                    myFish.DOWN = false;
                }
                if(e.getKeyCode() == 65){
                    myFish.LEFT = false;
                }
                if(e.getKeyCode() == 68){
                    myFish.RIGHT = false;
                }
            }
        });

        //循环调用paint方法
        while(true){
            repaint();
            time++;
            try{
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //重写绘制方法
    @Override
    public void paint(Graphics g) {
        //懒加载模式初始化对象
        offScreenImage = createImage(width,height);
        Graphics gImage = offScreenImage.getGraphics();
        blackBoard.paintSelf(gImage,myFish);
        //5中游戏状态
        switch(state){
            case 0:
                break;
            case 1:
                //游戏正在运行中
                myFish.paintSelf(gImage);
                logic();
                for (Enamy enamy : GameUtils.enamyList){
                    enamy.paintSelf(gImage);
                }
                if(isboss){
                    boss.x = boss.x + boss.dir*boss.speed;
                    boss.paintSelf(gImage);
                    if(boss.x < 0){
                        gImage.setColor(Color.red);
                        gImage.fillRect(boss.x,boss.y,2400, boss.height/30);
                    }
                }
                break;
            case 2:
                for (Enamy enamy : GameUtils.enamyList){
                    enamy.paintSelf(gImage);
                }
                if(isboss){
                    boss.paintSelf(gImage);
                }
                break;
            case 3:
                myFish.paintSelf(gImage);
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                break;
        }
        g.drawImage(offScreenImage,0,0,null);
    }

    private void logic(){
        //关卡难度
        if(myFish.count < 5){
            GameUtils.level = 0;
            myFish.level = 1;
        }else if(myFish.count <= 10){
            GameUtils.level = 1;
        }else if(myFish.count <= 50){
            GameUtils.level = 2;
            myFish.level = 2;
        }else if(myFish.count <= 150){
            GameUtils.level = 3;
            myFish.level = 3;
        }else if(myFish.count <= 300){
            GameUtils.level = 4;
            myFish.level = 3;
        }else{
            state = 3;
        }

        random = Math.random();

        switch (GameUtils.level){
            case 4:
                if(time % 60 == 0){
                    boss = new EnamyBoss();
                    isboss = true;
                }
            case 3:
            case 2:
                if(time % 30 == 0){
                    if(random <= 0.5){
                        enamy = new Enamy_3_L();
                    }else{
                        enamy = new Enamy_3_R();
                    }
                    GameUtils.enamyList.add(enamy);
                }
            case 1:
                if(time % 20 == 0){
                    if(random <= 0.5){
                        enamy = new Enamy_2_L();
                    }else{
                        enamy = new Enamy_2_R();
                    }
                    GameUtils.enamyList.add(enamy);
                }
            case 0:
                if(time % 10 == 0){
                    if(random <= 0.5){
                        enamy = new Enamy_1_L();
                    }else{
                        enamy = new Enamy_1_R();
                    }
                    GameUtils.enamyList.add(enamy);
                }
        }
        //敌方鱼移动
        for(Enamy enamy : GameUtils.enamyList){
            enamy.x = enamy.x + enamy.dir * enamy.speed;
            if(isboss){
                //boss鱼碰见敌方小鱼，小鱼被吃掉
                if(boss.getRec().intersects(enamy.getRec())){
                    enamy.x = -200;
                    enamy.y = -200;
                }
                //我方鱼碰见boss,通关失败
                if(boss.getRec().intersects(myFish.getRec())){
                    state = 2;
                }
            }
            //检测我方鱼与敌方鱼的碰撞
            if(myFish.getRec().intersects(enamy.getRec())){
                if(myFish.level >= enamy.type){
                    enamy.x = -200;
                    enamy.y = -200;
                    myFish.count = myFish.count + enamy.count;
                }else{
                    state = 2;
                }
            }
        }
    }

    private void reGame(){
        //敌方鱼清零
        GameUtils.enamyList.clear();
        //计时器清零
        time = 0;
        //我方鱼等级清零
        myFish.level = 1;
        //积分清零
        myFish.count = 0;
        //我方鱼回归初始化
        myFish.x = 650;
        myFish.y = 465;
        myFish.width = 50;
        myFish.height = 50;
        //boss鱼清空
        boss = null;
        isboss = false;
    }
}

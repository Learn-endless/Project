package com.donghu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/*
窗口的创建
1.使用java创建一个窗口。
2.创建一个普通的java类,然后继承JFrame类成为一个窗口类。
 */
public class GameWin extends JFrame {
    /*
    游戏状态：0 : 未开始 1 : 游戏中 2 : 通关失败 3 : 通关成功 4 : 暂停 5 : 重新开始
     */
    //设置游戏默认状态:
    public static int state = 0;
    //6-1模块
    Image offScreenimg;
    //6-2 背景类对象的创建
    Bg bg = new Bg();

    //敌方鱼类
    Enamy enamy;
    //我方鱼类
    MyFish myFish = new MyFish();

    //boss鱼
    Boss boss;
    double random;

    boolean isboss = false;

    //9-3 计数器
    int time = 0;
    //窗口的宽和高
    int width = 1440;
    int height = 900;
    //3.创建启动方法，来设置窗口属性
    public void launch(){
        //4.设置窗口是否可见
        this.setVisible(true);
        //5.设置窗口的大小
        this.setSize(width,height);
        //6.设置窗口是否可变
        this.setResizable(false);
        //7.设置窗口位置居中
        this.setLocationRelativeTo(null);
        //8.设置窗口标题
        this.setTitle("东湖学院:大鱼吃小鱼");
        //9.设置窗口关闭的按钮
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //4-1启动页面的点击事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //4-2通过流程控制语句if判断实现鼠标左键是否点击，并且进入游戏状态

                //4-3鼠标左键对应的数值为1,中键对应2，右键对应3
                if(e.getButton() == 1 && state == 0) {
                    state = 1;
                    //4-3 repaint方法再次调用paint方法，将窗口绘制出来。
                    repaint();
                }
            }
        });
        //键盘移动
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                //wasd
                //键盘的按压
                if(e.getKeyCode()==87){
                    GameUtils.UP = true;
                }
                if(e.getKeyCode()==83){
                    GameUtils.DOWN = true;
                }
                if(e.getKeyCode()==65){
                    GameUtils.LEFT = true;
                }
                if(e.getKeyCode()==68){
                    GameUtils.RIGHT = true;
                }
            }

            //抬起
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                //wasd
                //键盘的抬起
                if(e.getKeyCode()==87){
                    GameUtils.UP = false;
                }
                if(e.getKeyCode()==83){
                    GameUtils.DOWN = false;
                }
                if(e.getKeyCode()==65){
                    GameUtils.LEFT = false;
                }
                if(e.getKeyCode()==68){
                    GameUtils.RIGHT = false;
                }
                //空格用来暂停
                if(e.getKeyCode() == 32){
                    switch (state){
                        case 1:
                            state = 4;
                            GameUtils.drawWord(getGraphics(),"游戏暂停!",Color.black,50,600,500);
                            break;
                        case 4:
                            state = 1;
                            break;
                    }
                }
            }
        });

        //5-5 定义背景图片的循环使用，需要重复调用paint方法，所以在launch方法中添加一个while循环
        //每隔40毫秒调用一次paint方法
        while(true){
            repaint();
            time++;
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    //12.重写paint方法
    @Override
    public void paint(Graphics g) {   //绘制的方法,
        offScreenimg = createImage(width,height);      //6-3 懒加载模式初始化对象
        Graphics gImage = offScreenimg.getGraphics();
        bg.paintSelf(gImage,myFish.level);
        switch (state){  //14.在paint方法中，用switch语句定义游戏状态
            case 0:
                break;
            case 1:
                myFish.paintSelf(gImage);
                logic();
                for(Enamy e:GameUtils.EnamyList){
                    e.paintSelf(gImage);
                }
                if(isboss){
                    boss.x = boss.x+boss.dir*boss.speed;
                    boss.paintSelf(gImage);
                    if(boss.x < 0){
                        gImage.setColor(Color.red);
                        gImage.fillRect(boss.x,boss.y,2400,boss.height/30);
                    }
                }
                break;
            case 2:
                for(Enamy enamy : GameUtils.EnamyList){
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
        //6-4
        //13.用画笔g来绘制图片
        g.drawImage(offScreenimg,0,0,null);
    }

    //9-2批量添加敌方鱼类
    void logic(){

        //设置关卡难度
        if(GameUtils.count < 5){
            GameUtils.level = 0;
            myFish.level = 1;
        }else if(GameUtils.count < 15){
            GameUtils.level = 1;
        }else if(GameUtils.count < 50){
            GameUtils.level = 2;
            myFish.level = 2;
        }else if(GameUtils.count < 150){
            GameUtils.level = 3;
            myFish.level = 3;
        }else if(GameUtils.count < 300){
            GameUtils.level = 4;
            myFish.level = 4;
        }else {
            //游戏通关
            state = 3;
        }
        random = Math.random()*10;
        switch(GameUtils.level){
            case 4:
                if(time % 100 == 0){
                    enamy = new Boss();
                    isboss = true;
                    GameUtils.EnamyList.add(enamy);
                }
            case 3:
            case 2:
                //每调用60次paint方法，绘制一组条鱼
                if (time % 30 == 0) {
                    //敌方鱼出现的概率
                    if(random <= 5){
                        enamy = new Enamy3Right();
                    }else{
                        enamy = new Enamy3Left();
                    }
                    GameUtils.EnamyList.add(enamy);
                }
            case 1:
                //每调用60次paint方法，绘制一组条鱼
                if (time % 20 == 0) {
                    //敌方鱼出现的概率
                    if(random <= 5){
                        enamy = new Enamy2Right();
                    }else{
                        enamy = new Enamy2Left();
                    }
                    GameUtils.EnamyList.add(enamy);
                }
            case 0:
                //每调用60次paint方法，绘制一组条鱼
                if (time % 10 == 0) {
                    //敌方鱼出现的概率
                    if(random <= 5){
                        enamy = new Enamy1Right();
                    }else{
                        enamy = new Enamy1Left();
                    }
                    GameUtils.EnamyList.add(enamy);
                }
            default:
                break;
        }

        for(Enamy enamy:GameUtils.EnamyList) {
            enamy.x = enamy.x+enamy.dir*enamy.speed;
            if(isboss){
                if(boss.grtRect().intersects(enamy.grtRect())){
                    enamy.x = -200;
                    enamy.y = -200;
                }
                if(boss.grtRect().intersects(myFish.grtRect())){
                    state = 2;
                }
            }
            //碰撞检测
            if(myFish.grtRect().intersects(enamy.grtRect())){
                if(myFish.level >= enamy.type){
                    //移除地方鱼
                    enamy.x = -200;
                    enamy.y = -200;
                    //积分加1
                    GameUtils.count += enamy.count;
                    System.out.println(GameUtils.count);
                }else{
                    state = 2;
                }
            }
        }
    }
    //创建 main 方法来启动窗口
    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}

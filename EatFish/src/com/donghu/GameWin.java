package com.donghu;

import javax.swing.*;
import java.awt.*;
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
    游戏状态：
    0 : 未开始
    1 : 游戏中
    2 : 通关失败
    3 : 通关成功
    4 : 暂停
     */

    //设置游戏默认状态:
    public int state = 0;

    Enamy enamy;

    //6-1模块
    Image offScreenimg;
    //6-2 背景类对象的创建
    Bg bg = new Bg();

    //窗口的宽和高
    int width = 1440;
    int height = 900;

    double random;
    //9-3 计数器
    int time = 0;
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
        this.setTitle("皇家学院:大鱼吃小鱼");
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

        //6-3 懒加载模式初始化对象
        offScreenimg = createImage(width,height);
        Graphics gImage = offScreenimg.getGraphics();
        //14.在paint方法中，用switch语句定义游戏状态
        switch (state){
            case 0:
                //15.在游戏状态为0的时候，设置启动背景图片
                gImage.drawImage(GameUtils.bgimg,0,0,null);
                //16.将画笔颜色改为与背景颜色不同的
                gImage.setColor(Color.pink);
                //17.设置字体样式
                gImage.setFont(new Font("仿宋",Font.BOLD,80));
                //18.为启动页面添加文字
                gImage.drawString("开始",650,500);
                break;
            case 1:
                //6-5
                bg.paintSelf(gImage);
                logic();
                for(Enamy e:GameUtils.EnamyList){
                    e.paintSelf(gImage);
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
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
        //每调用10次paint方法，绘制一条鱼
        if (time % 20 == 0) {
            enamy = new Enamy.Enamy_1_L();
            GameUtils.EnamyList.add(enamy);
        }
        for(Enamy enamy:GameUtils.EnamyList){
            enamy.x = enamy.x+enamy.dir*enamy.speed;
        }
    }

    //创建 main 方法来启动窗口
    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}

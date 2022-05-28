package com.donghu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

    //地方鱼类
    Enamy enamy1_right;
    Enamy enamy2_right;
    Enamy enamy3_right;
    Enamy enamy1_left;
    Enamy enamy2_left;
    Enamy enamy3_left;
    //我方鱼类
    MyFish myFish = new MyFish();

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
//                gImage.drawImage(GameUtils.bgimg,0,0,null); //状态为0时启动背景图片
//                gImage.setColor(Color.pink); //16.将画笔颜色改为与背景颜色不同的
//                gImage.setFont(new Font("仿宋",Font.BOLD,80)); //17.设置字体样式
//                gImage.drawString("开始",650,500); //18.为启动页面添加文字
                break;
            case 1:
                myFish.paintSelf(gImage);
//                gImage.setColor(Color.pink); //将画笔颜色改为与背景颜色不同的
//                gImage.setFont(new Font("仿宋",Font.BOLD,50)); //17.设置字体样式
//                String str = "积分："+GameUtils.count;
//                gImage.drawString(str,635,125); //18.为启动页面添加文字
//                //6-5
//                myFish.paintSelf(gImage);
                logic();
                for(Enamy e:GameUtils.EnamyList){
                    e.paintSelf(gImage);
                }
                break;
            case 2:
                break;
            case 3:
                myFish.paintSelf(gImage);
//                gImage.setColor(Color.black); //16.将画笔颜色改为与背景颜色不同的
//                gImage.setFont(new Font("仿宋",Font.BOLD,80)); //设置字体样式
//                gImage.drawString("积分达到:"+GameUtils.count,450,300);
//                gImage.drawString("游戏通关",450,500);
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

        //每调用60次paint方法，绘制一条鱼
        if (time % 60 == 0) {
            enamy1_right = new Enamy1Right(); GameUtils.EnamyList.add(enamy1_right);
            enamy2_right = new Enamy2Right(); GameUtils.EnamyList.add(enamy2_right);
            enamy3_right = new Enamy3Right(); GameUtils.EnamyList.add(enamy3_right);
            enamy1_left = new Enamy1Left();   GameUtils.EnamyList.add(enamy1_left);
            enamy2_left = new Enamy2Left();   GameUtils.EnamyList.add(enamy2_left);
            enamy3_left = new Enamy3Left();   GameUtils.EnamyList.add(enamy3_left);
        }
        for(Enamy enamy:GameUtils.EnamyList) {
            enamy.x = enamy.x+enamy.dir*enamy.speed;
            //碰撞检测
            if(myFish.grtRect().intersects(enamy.grtRect())){
                //移除地方鱼
//                GameUtils.EnamyList.remove(enamy);
                enamy.x = -200;
                enamy.y = -200;
                //积分加1
                GameUtils.count += enamy.count;
                System.out.println(GameUtils.count);

            }
        }
    }
    //创建 main 方法来启动窗口
    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}

package com.yingliming.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: yingliming
 * @Date: 2022/8/13 0013 - 08 - 13 - 21:04
 * @Description: com.yingliming.com.yingliming.tank
 * @Version: 1.0
 **/
public class TankFrame extends Frame {

    Tank myTank = new Tank(200,400,Dir.DOWN,this);
    List<Bullet> bullets = new ArrayList<>();
    public   List<Tank> tanks = new ArrayList<>();
    static final int GAME_WIDTH=800, GAME_HEIGHT=600;

    public TankFrame(){
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.addKeyListener(new MyKeyAdapter());


    }


    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);  //画笔传递给paint 把坦克和子弹画入内存的图片里
        g.drawImage(offScreenImage, 0, 0, null); //一次性更新到屏幕
    }

    @Override
    public void paint(Graphics g) {
        Color c= g.getColor();//保存现场
        g.setColor(Color.white);//设定白色
        g.drawString("子弹的数量为:" + bullets.size(),10,60); //画
        g.setColor(c); //恢复现场

        myTank.paint(g);
        for (int i=0; i<this.bullets.size();i++) {
            bullets.get(i).paint(g);
        }
        //画出地方坦克
        for (int i=0; i<tanks.size();i++) {
            tanks.get(i).paint(g);
        }

        /*for(Iterator<Bullet> it= bullets.iterator(); it.hasNext();){

            Bullet b= it.next();
            if(!b.live) it.remove();

        }*/
    }

    private class MyKeyAdapter extends KeyAdapter {
        boolean bl=false;
        boolean br=false;
        boolean bu=false;
        boolean bd=false;
        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("key press");
            int key = e.getKeyCode();
            switch (key)
            {
                case KeyEvent.VK_LEFT: bl=true;
                    break;
                case KeyEvent.VK_RIGHT: br=true;
                    break;
                case KeyEvent.VK_UP: bu=true;
                    break;
                case KeyEvent.VK_DOWN: bd=true;
                    break;
                default:
                    break;
            }

            setMainTankDir();



        }



        @Override
        public void keyReleased(KeyEvent e) {
            //System.out.println("key released");
            int key = e.getKeyCode();
            switch (key)
            {
                case KeyEvent.VK_LEFT: bl=false;
                    break;
                case KeyEvent.VK_RIGHT: br=false;
                    break;
                case KeyEvent.VK_UP: bu=false;
                    break;
                case KeyEvent.VK_DOWN: bd=false;
                    break;
                case KeyEvent.VK_CONTROL: myTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();

        }

        private void setMainTankDir() {
            if(!bl && !br && !bu && !bd) myTank.setMoving(false);
            else
            {myTank.setMoving(true);

            if(bl) myTank.setDir(Dir.LEFT);
            if(br) myTank.setDir(Dir.RIGHT);
            if(bu) myTank.setDir(Dir.UP);
            if(bd) myTank.setDir(Dir.DOWN);}
        }
    }
}

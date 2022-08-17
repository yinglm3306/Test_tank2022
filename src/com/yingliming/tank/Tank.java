package com.yingliming.tank;

import java.awt.*;

/**
 * @Auther: yingliming
 * @Date: 2022/8/14 0014 - 08 - 14 - 21:32
 * @Description: com.yingliming.com.yingliming.tank
 * @Version: 1.0
 **/
public class Tank {
    private int x=200,y=200;
    private Dir dir= Dir.DOWN;
    private final int SPEED=5;
    private boolean moving=false;

    private TankFrame tf= null;

    public Tank(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public int getSPEED() {
        return SPEED;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g) {
        Color c= g.getColor(); //保存原来的颜色
        g.setColor(Color.yellow); //把主战坦克设成黄色
        g.fillRect(x,y,50,50);//画出主战坦克
        g.setColor(c); //设置回老的颜色

        move();
    }

    private void move() {
        if(!moving) return;

        switch (dir)
        {
            case LEFT: x-=SPEED;
                break;
            case RIGHT: x+=SPEED;
                break;
            case UP: y-=SPEED;
                break;
            case DOWN: y+=SPEED;
                break;
            default:
                break;
        }
    }

    public void fire() {
        tf.bullets.add(new Bullet(x,y,dir,this.tf));
    }
}

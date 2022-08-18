package com.yingliming.tank;

import javax.swing.plaf.basic.BasicSplitPaneUI;
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
    private boolean living= true;

    public static int tank_WIDTH=ResourceMgr.tankD.getWidth();
    public static int tank_HEIGHT=ResourceMgr.tankD.getHeight();


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
       // Color c= g.getColor(); //保存原来的颜色
       // g.setColor(Color.yellow); //把主战坦克设成黄色
       // g.fillRect(x,y,50,50);//画出主战坦克
       // g.setColor(c); //设置回老的颜色
        if(!living) tf.tanks.remove(this);
        switch (dir)
        {
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
        }

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
        int bx=this.x+Tank.tank_WIDTH/2-Bullet.bullet_WIDTH/2;
        int by=this.y+Tank.tank_HEIGHT/2-Bullet.bullet_HEIGHT/2;
        tf.bullets.add(new Bullet(bx,by,dir,this.tf));
    }

    public void die() {
        this.living= false;
    }
}

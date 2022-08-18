package com.yingliming.tank;

import java.awt.*;

public class Bullet {
    private final static int SPEED=10;
    private static int WIDTH=5, HEIGHT=5;
    private TankFrame tf = null;
    private int x,y;

    public static int bullet_WIDTH=ResourceMgr.bulletD.getWidth();
    public static int bullet_HEIGHT=ResourceMgr.bulletD.getHeight();

    private Dir dir;
    private boolean living = true;

    public Bullet(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tf;
    }

    public void paint(Graphics g) {
        if(!living) {tf.bullets.remove(this);}

        Color c= g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(c);
        move();
    }

    private void move() {
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

        if(x<0 || y<0 || x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT) living =false;
    }

    public void collideWith(Tank tank) {
        Rectangle rect1= new Rectangle(x,y,WIDTH,HEIGHT);
        Rectangle rect2= new Rectangle(tank.getX(),tank.getY(),Tank.tank_WIDTH,Tank.tank_HEIGHT);
        if(rect1.intersects(rect2)){
           tank.die();
           this.die();
        }
    }

    private void die() {
        this.living=false;
    }
}

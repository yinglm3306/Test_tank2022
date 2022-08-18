package com.yingliming;


import com.yingliming.tank.Dir;
import com.yingliming.tank.Tank;
import com.yingliming.tank.TankFrame;

/**
 * @Auther: yingliming
 * @Date: 2022/8/13 0013 - 08 - 13 - 20:06
 * @Description: com.yingliming
 * @Version: 1.0
 **/
public class T {
    public static void main(String[] args) {
        TankFrame tf = new TankFrame();
        //初始化敌方坦克
        for(int i=0;i<5;i++){
            tf.tanks.add(new Tank(50 + i*80,200, Dir.DOWN,tf ));
        }
        while (true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tf.repaint();
        }

    }
}

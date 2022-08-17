package com.yingliming;


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

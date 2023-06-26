package org.emil.volatilestudy;

/**
 * @Author: emil
 * @Date: 2023/6/21 11:49
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class VolatileDemo {
    private volatile int a;

    public void update() {
        a = 1;
    }

    public static void main(String[] args) {
        VolatileDemo test = new VolatileDemo();
        test.update();
    }
}

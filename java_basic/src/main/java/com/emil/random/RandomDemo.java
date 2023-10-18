package main.java.com.emil.random;

import java.util.Random;

public class RandomDemo {

    public static void main(String[] args) {
        Random random = new Random();
        // 生成[0,1.0]区间的小数
        System.out.println(random.nextDouble());
        // 生成[0,8.0]区间的小数
        System.out.println(random.nextDouble()*7);
        // 生产[0,10]区间的整数
        System.out.println(random.nextInt(10));


        Random random1 = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println("随机数"+random1.nextInt(10));
        }
    }
}

package main.java.com.emil.random;


import java.util.Random;

public class SameSeed {
    public static void main(String[] args)  {
        new Thread(()->{
            for (int i = 0; i < 2; i++) {
                Random random = new Random(1024);
                for (int j = 0; j < 3; j++) {
                    int number = random.nextInt();
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    try {
                        Thread.sleep(200);
                    }
                    catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("----------");
            }
        }).start();
    }
}


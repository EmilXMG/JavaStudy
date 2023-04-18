package com.emil.multithreading.basicuse;

import java.util.concurrent.TimeUnit;

public class ThreadStopWithInterrupt {


    private static class MyTask implements Runnable {

        private volatile long count = 0L;

        public static void main(String[] args) throws InterruptedException {
            MyTask task = new MyTask();
            Thread thread = new Thread(task, "MyTask");
            thread.start();
            TimeUnit.MILLISECONDS.sleep(50);
            thread.interrupt();
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 线程启动");
            // 通过 Thread.interrupted 和 interrupt 配合来控制线程终止
            while (!Thread.interrupted()) {
                System.out.println(count++);
            }
            System.out.println(Thread.currentThread().getName() + " 线程终止");
        }
    }
}

package org.emil.basicuse;

public class ThreadYield {

    public static void main(String[] args) {
        ThreadYieldDemo threadYieldDemo = new ThreadYieldDemo();
        new Thread(threadYieldDemo, "线程A").start();
        new Thread(threadYieldDemo, "线程B").start();
    }

    static class ThreadYieldDemo implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "运行，i = " + i);
                if (i == 2) {
                    System.out.println("线程礼让：");
                    Thread.yield();
                }
            }
        }
    }
}

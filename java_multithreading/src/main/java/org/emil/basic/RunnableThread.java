package org.emil.basic;


/**
 * @author emil
 */
public class RunnableThread {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable(), "Runnable 线程-A");
        Thread thread1 = new Thread(new MyRunnable(), "Runnable 线程-B");
        thread.start();
        thread1.start();

    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "输出数据" + i);
            }
        }
    }
}

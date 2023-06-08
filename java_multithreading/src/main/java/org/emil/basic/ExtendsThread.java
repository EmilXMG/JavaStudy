package org.emil.basic;

/**
 * @author emil
 */
public class ExtendsThread {


    public static void main(String[] args) {
        MyThread myThread = new MyThread("线程A");
        MyThread myThread1 = new MyThread("线程B");
        myThread.start();
        myThread1.start();
    }


    static class MyThread extends Thread {

        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "输出数据" + i);
            }
        }
    }

}

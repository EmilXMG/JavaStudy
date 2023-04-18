package com.emil.multithreading.basicuse;

public class ThreadInterruptDemo {

    public static void main(String[] args) {
        // 实例化Runnable子类对象
        MyThreadInterrupt mt = new MyThreadInterrupt();
        // 实例化Thread对象
        Thread t = new Thread(mt, "线程");
        // 启动线程
        t.start();
        try {
            // 线程休眠2秒
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("3、main线程休眠被终止");
        }
        // 中断线程执行
        t.interrupt();
    }


    static class MyThreadInterrupt implements Runnable{

        @Override
        public void run() {
            System.out.println("1、进入run()方法");
            try {
                Thread.sleep(3000); // 线程休眠10秒
                System.out.println("2、已经完成了休眠");
            } catch (InterruptedException e) {
                System.out.println("3、MyThread线程休眠被终止");
                return; // 返回调用处
            }
            System.out.println("4、run()方法正常结束");
        }
    }
}

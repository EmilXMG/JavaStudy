package org.emil.basicuse;

public class ThreadSleep {
    public static void main(String[] args) {
        new Thread(new ThreadSleepDemo("线程A", 500)).start();
        new Thread(new ThreadSleepDemo("线程A", 1000)).start();
        new Thread(new ThreadSleepDemo("线程A", 1500)).start();
    }

    static class ThreadSleepDemo implements Runnable {
        // 线程名称
        private String name;

        // 休眠时间
        private int time;

        private ThreadSleepDemo(String name, int time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(this.time);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.name + "休眠" + this.time + "毫秒。");
        }
    }
}
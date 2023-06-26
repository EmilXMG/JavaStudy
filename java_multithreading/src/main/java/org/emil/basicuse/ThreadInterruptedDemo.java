package org.emil.basicuse;

public class ThreadInterruptedDemo implements Runnable {

    @Override
    public void run() {
        // 计数
        int count = 0;
        // 检查中断标识位
        while (Thread.currentThread().isInterrupted()) {
            // 累加
            count++;
            // 输出
            System.out.println("正在执行第" + count + "次任务！");
            try {
                // 线程休眠 1 秒钟
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                System.out.println("线程被中断，即将退出...");
                // 重新设置中断标志
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        // 创建线程对象
        Thread thread = new Thread(new ThreadInterruptedDemo());
        // 启动线程
        thread.start();
        try {
            // 主线程休眠3秒钟
            Thread.sleep(3000);
            // 中断子线程
            thread.interrupt();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

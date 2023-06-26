package org.emil.cas.atomicdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author: emil
 * @Date: 2023/6/25 0:50
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class AtomicStampedReferenceDemo {
    private final static String INIT_REF = "pool-1-thread-3";

    private final static AtomicStampedReference<String> asr = new AtomicStampedReference<>(INIT_REF, 0);

    public static void main(String[] args) throws InterruptedException {

        System.out.println("初始对象为：" + asr.getReference());

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.execute(new MyThread());
        }

        executorService.shutdown();
        executorService.awaitTermination(3, TimeUnit.SECONDS);
    }

    static class MyThread implements Runnable {

        @Override
        public void run() {
            try {
                // 线程随机休眠一段时间。
                Thread.sleep(Math.abs((int) (Math.random() * 100)));
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 使用 getStamp() 方法获取当前 asr 的标记值，即版本号。
            final int stamp = asr.getStamp();
            // 使用 compareAndSet() 方法尝试将 asr 的引用对象从 INIT_REF 修改为当前线程的名称，并同时将标记值加1。compareAndSet() 方法会比较当前引用对象和标记值与期望值是否相等，如果相等则进行修改，否则不作任何操作。
            // 如果 compareAndSet() 返回 true，说明修改成功，打印线程名称和新的对象。
            if (asr.compareAndSet(INIT_REF, Thread.currentThread().getName(), stamp, stamp + 1)) {
                System.out.println(Thread.currentThread().getName() + " 修改了对象！");
                System.out.println("新的对象为：" + asr.getReference());
            }
        }
    }
}

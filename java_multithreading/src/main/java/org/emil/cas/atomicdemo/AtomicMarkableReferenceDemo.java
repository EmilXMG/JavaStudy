package org.emil.cas.atomicdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * @Author: emil
 * @Date: 2023/6/25 0:40
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class AtomicMarkableReferenceDemo {
    private final static String INIT_TEXT = "abc";

    public static void main(String[] args) throws InterruptedException {
        final AtomicMarkableReference<String> atomicMarkableReference = new AtomicMarkableReference<>(INIT_TEXT, false);
        System.out.println("初始对象为：" + atomicMarkableReference.getReference());
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                try {
                    // 线程随机休眠一段时间。
                    Thread.sleep(Math.abs((int) (Math.random() * 100)));
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 获取当前线程的名称。
                String name = Thread.currentThread().getName();
                // 使用 compareAndSet() 方法尝试将 amr 的引用对象从 INIT_TEXT 修改为当前线程的名称，并同时将标记位反转。
                // compareAndSet() 方法会比较当前引用对象和标记位与期望值是否相等，如果相等则进行修改，否则不作任何操作。
                // 如果 compareAndSet() 返回 true，说明修改成功，打印线程名称和新的对象。
                if (atomicMarkableReference.compareAndSet(INIT_TEXT, name, atomicMarkableReference.isMarked(), !atomicMarkableReference.isMarked())) {
                    System.out.println(Thread.currentThread().getName() + " 修改了对象！");
                    System.out.println("新的对象为：" + atomicMarkableReference.getReference());
                }
            });
        }
        // 关闭线程池，并等待线程池中的任务执行完成。
        executorService.shutdown();
        executorService.awaitTermination(3, TimeUnit.SECONDS);
    }
}

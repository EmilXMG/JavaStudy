package org.emil.cas.atomicdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: emil
 * @Date: 2023/6/25 0:31
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class AtomicIntegerDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        AtomicInteger count = new AtomicInteger();
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " count=" + count.get());
                count.incrementAndGet();
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(30, TimeUnit.SECONDS);
        System.out.println("Final Count is : " + count.get());
    }
}

package org.emil.cas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: emil
 * @Date: 2023/6/24 17:32
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class AtomicIntegerDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //final AtomicInteger count = new AtomicInteger(0);
        AtomicInteger count = new AtomicInteger();
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                count.incrementAndGet();
                count.getAndIncrement();
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        //System.out.println("Final Count is :" + count.get());
        System.out.println("Final Count is :" + count.get());
    }
}

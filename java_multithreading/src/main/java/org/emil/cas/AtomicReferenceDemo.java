package org.emil.cas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: emil
 * @Date: 2023/6/24 18:08
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class AtomicReferenceDemo {

    private static int ticket = 10;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            executorService.execute(AtomicReferenceDemo::sellTickets);
        }
        executorService.shutdown();
    }

    private static synchronized void sellTickets() {
        while (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了第" + ticket + "张票");
            ticket--;
        }
    }
}

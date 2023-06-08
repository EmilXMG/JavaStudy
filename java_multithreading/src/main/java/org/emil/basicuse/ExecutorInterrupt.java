package org.emil.basicuse;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorInterrupt {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread Run");
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.shutdownNow();
        System.out.println("Main Run");
    }
}

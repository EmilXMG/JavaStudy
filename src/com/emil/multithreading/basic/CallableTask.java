package com.emil.multithreading.basic;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author emil
 */
public class CallableTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 123;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTask callableTask = new CallableTask();
        FutureTask<Integer> future = new FutureTask<>(callableTask);
        Thread thread = new Thread(future);
        thread.start();
        System.out.println(future.get());
    }
}

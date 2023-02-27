package com.emil.multithreading.basic;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author emil
 */
public class CallableTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt();
    }

    ExecutorService service = Executors.newFixedThreadPool(10);
    Future<Integer> future = service.submit(new CallableTask());
}

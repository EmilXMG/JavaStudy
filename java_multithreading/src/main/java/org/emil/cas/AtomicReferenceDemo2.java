package org.emil.cas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: emil
 * @Date: 2023/6/24 18:19
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class AtomicReferenceDemo2 {

    private static int ticket = 10;

    public static void main(String[] args) {
        // 最后，在主函数中调用 threadSafeDemo() 方法来启动线程并进行并发处理。
        // 由于使用了自旋锁来保证线程安全，每个线程都将自旋等待获得锁，确保只有一个线程可以修改剩余票数。
        threadSafeDemo();
    }

    private static void threadSafeDemo() {
        SpinLock lock = new SpinLock();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyThread(lock));
        }
        executorService.shutdown();
    }

    /**
     * 基于 {@link AtomicReference} 实现的简单自旋锁
     * SpinLock 类有一个 AtomicReference<Thread> 类型的属性 atomicReference，用于记录获得锁的线程。
     */
    static class SpinLock {

        private AtomicReference<Thread> atomicReference = new AtomicReference<>();

        // AtomicReference 实现。自旋锁是一种基于循环等待的锁机制，它通过不断自旋等待可以获得锁的线程释放锁。
        public void lock() {
            Thread current = Thread.currentThread();
            // lock() 方法用于上锁。首先获取当前线程，然后在一个循环中，
            // 通过 compareAndSet() 方法将 atomicReference 的值从 null 设置为当前线程，如果设置成功，则获得了锁，跳出循环；否则，继续自旋等待。
            while (!atomicReference.compareAndSet(null, current)) {
            }
        }

        public void unlock() {
            Thread current = Thread.currentThread();
            // unlock() 方法用于释放锁。首先获取当前线程，然后通过 compareAndSet() 方法将 atomicReference 的值从当前线程设置为 null，表示释放了锁。
            atomicReference.compareAndSet(current, null);
        }

    }

    /**
     * 利用自旋锁 {@link SpinLock} 并发处理数据
     * MyThread 类实现了 Runnable 接口，代表一个线程，通过 SpinLock 来保证线程安全。
     * 在 run() 方法中，使用 while 循环来不断处理剩余票数，首先调用 lock() 方法上锁，然后判断剩余票数是否大于 0，如果是，则打印卖出的票数并将剩余票数减一，然后调用 unlock() 方法释放锁。
     */
    static class MyThread implements Runnable {

        private SpinLock lock;

        public MyThread(SpinLock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            while (ticket > 0) {
                lock.lock();
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " 卖出了第 " + ticket + " 张票");
                    ticket--;
                }
                lock.unlock();
            }
        }

    }
}

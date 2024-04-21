package org.emil.javalock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 示例
 *
 * @Auther: emil
 * @Date: 2024/4/1 00:32
 * @Description:
 */
public class ReentrantLockExample {

    private ReentrantLock lock = new ReentrantLock();

    private int count = 0;


    public void add() {
        lock.lock();
        try {
            count++;
            System.out.println(count);
        }
        finally {
            // 获取锁操作 lock() 必须在 try catch 块中进行，并且将释放锁操作 unlock() 放在 finally 块中进行，以保证锁一定被被释放，防止死锁的发生。
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();
        new Thread(reentrantLockExample::add).start();
        new Thread(reentrantLockExample::add).start();
    }
}

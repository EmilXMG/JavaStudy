package org.emil.synchronizedstudy;

/**
 * @Author: emil
 * @Date: 2023/6/20 18:18
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class SynchronizeDemo {
    public void foo(Object lock) {
        synchronized (lock) {
            lock.hashCode();
        }
    }
}

package com.emil.multithreading.basic;

/**
 * @author emil
 */
public class ExtendsThread extends Thread {
    @Override
    public void run() {
        System.out.println("用Thread类实现线程");
    }
}

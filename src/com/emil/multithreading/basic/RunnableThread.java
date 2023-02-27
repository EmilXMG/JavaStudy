package com.emil.multithreading.basic;


/**
 * @author emil
 */
public class RunnableThread  implements Runnable{
    @Override
    public void run() {
        System.out.println("用实现Runnable接口实现线程");
    }
}

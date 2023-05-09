package com.emil.multithreading.synchronizedstudy;

public class SynchronizedTest {
    public void method(){
        synchronized (this){
            System.out.println("test enter method 001 start");
        }
    }
}
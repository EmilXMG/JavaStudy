package com.emil.multithreading.basicuse;

public class ThreadInterruptedDemo {

    static class InterruptedDemo extends Thread{

        @Override
        public void run() {
            while (!interrupted()) {

            }
            System.out.println("Thread End");
        }

        public static void main(String[] args) {
            InterruptedDemo interruptedDemo = new InterruptedDemo();
            interruptedDemo.start();
            interruptedDemo.interrupt();
        }
    }
}

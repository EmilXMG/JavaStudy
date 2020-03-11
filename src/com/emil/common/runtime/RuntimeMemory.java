package com.emil.common.runtime;

/**
 * @author emil
 */
public class RuntimeMemory {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("【MaxMemory】:" + runtime.maxMemory());
        System.out.println("【TotalMemory】:" + runtime.totalMemory());
        System.out.println("【freeMemory】:" + runtime.freeMemory());
        /**
         * 产生垃圾前的数据
         * 【MaxMemory】:4733272064  (8G内存，默认物理内存的四分之一)
         * 【TotalMemory】:319815680  (16G,默认物理内存大的十六分之一)
         * 【freeMemory】:313104712
         */

        String message = "hello";
        for (int i = 0; i < 20; i++) {
            message += message + i;
        }
        System.out.println("【MaxMemory】:" + runtime.maxMemory());
        System.out.println("【TotalMemory】:" + runtime.totalMemory());
        System.out.println("【freeMemory】:" + runtime.freeMemory());

        /**
         * 产生垃圾后的数据
         * 【MaxMemory】:4733272064
         * 【TotalMemory】:319815680
         * 【freeMemory】:251752800
         */
        runtime.gc();
        System.out.println("【MaxMemory】:" + runtime.maxMemory());
        System.out.println("【TotalMemory】:" + runtime.totalMemory());
        System.out.println("【freeMemory】:" + runtime.freeMemory());

        /**
         * 垃圾回收后的数据
         *【MaxMemory】:4733272064
         * 【TotalMemory】:319815680
         * 【freeMemory】:304961792
         */
    }
}

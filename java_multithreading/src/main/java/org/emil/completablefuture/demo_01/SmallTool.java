package org.emil.completablefuture.demo_01;

import java.util.StringJoiner;

/**
 * @Author: emil
 * @Date: 2023/6/8 0:54
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class SmallTool {

    public static void sleepMillis(long millis) {
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printTimeAndThread(String tag) {
        String result = new StringJoiner("\t|\t").add(String.valueOf(System.currentTimeMillis()))
                .add(String.valueOf(Thread.currentThread().getId()))
                .add(Thread.currentThread().getName()).add(tag).toString();
        System.out.println(result);
    }
}

package org.emil.completablefuture.demo_01.completablefuture_start;


import org.emil.completablefuture.demo_01.SmallTool;

import java.util.concurrent.CompletableFuture;

/**
 * @Author: emil
 * @Date: 2023/6/8 1:00
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class SupplyAsync {

    public static void main(String[] args) {
        SmallTool.printTimeAndThread("小白进入餐厅");
        SmallTool.printTimeAndThread("小白点了 番茄炒蛋+一碗米饭");

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("厨师炒菜");
            SmallTool.sleepMillis(200);
            SmallTool.printTimeAndThread("厨师打饭");
            SmallTool.sleepMillis(100);
            return "番茄炒蛋+米饭做好了";

        });
        SmallTool.printTimeAndThread("小白在打王者");
        // join() 方法会等待任务执行结束，然后返回任务的结果。
        SmallTool.printTimeAndThread(String.format("%s,小白开吃", completableFuture.join()));

    }
}

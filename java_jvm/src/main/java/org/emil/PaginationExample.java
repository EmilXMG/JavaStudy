package org.emil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PaginationExample {

    public static void main(String[] args) {
        int pageSize = 10;
        int totalRecords = 100;
        int totalPages = (int) Math.ceil((double) totalRecords / pageSize);

        //List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 1; i <= totalPages; i++) {
            int page = i;
            CompletableFuture.supplyAsync(() -> getPageData(page, pageSize))
                    .thenApplyAsync(data -> insertData(data));
            //futures.add(future);
        }

        //CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).join();

        System.out.println("All data has been inserted.");
    }

    private static List<String> getPageData(int page, int pageSize) {
        List<String> data = new ArrayList<>();
        for (int i = (page - 1) * pageSize + 1; i <= page * pageSize; i++) {
            data.add("Data " + i);
        }
        try {
            Thread.sleep(1000); // 模拟查询数据的耗时
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return data;
    }

    private static Void insertData(List<String> data) {
        try {
            Thread.sleep(1000); // 模拟插入数据的耗时
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Inserting data: " + data);
        return null;
    }
}

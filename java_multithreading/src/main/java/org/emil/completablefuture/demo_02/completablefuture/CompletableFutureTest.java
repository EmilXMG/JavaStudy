package org.emil.completablefuture.demo_02.completablefuture;

import org.emil.completablefuture.demo_02.service.MedalService;
import org.emil.completablefuture.demo_02.service.UserInfoService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: emil
 * @Date: 2023/6/8 14:48
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class CompletableFutureTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        UserInfoService userInfoService = new UserInfoService();
        MedalService medalService = new MedalService();
        long userId = 666L;
        long startTime = System.currentTimeMillis();
        //CompletableFuture<UserInfo> completableUserInfoFuture = CompletableFuture.supplyAsync(() -> userInfoService.getUserInfo(userId));

    }

}

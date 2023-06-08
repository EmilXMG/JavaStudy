package org.emil.completablefuture.demo_02.future;

import org.emil.completablefuture.demo_02.entity.MedalInfo;
import org.emil.completablefuture.demo_02.entity.UserInfo;
import org.emil.completablefuture.demo_02.service.MedalService;
import org.emil.completablefuture.demo_02.service.UserInfoService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @Author: emil
 * @Date: 2023/6/8 14:21
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class FutureTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        UserInfoService userInfoService = new UserInfoService();
        MedalService medalService = new MedalService();

        long userId = 666L;
        long startTime = System.currentTimeMillis();

        //调用用户服务获取用户基本信息
        FutureTask<UserInfo> userInfoFutureTask = new FutureTask<>(() -> userInfoService.getUserInfo(userId));

        executorService.submit(userInfoFutureTask);
        // 模拟其他线程耗时
        Thread.sleep(300);

        FutureTask<MedalInfo> medalInfoFutureTask = new FutureTask<>(() -> medalService.getMedalInfo(userId));

        executorService.submit(medalInfoFutureTask);


        //获取个人信息结果
        UserInfo userInfo = userInfoFutureTask.get();
        //获取勋章信息结果
        MedalInfo medalInfo = medalInfoFutureTask.get();


        System.out.println("共用时：" + (System.currentTimeMillis() - startTime) + "ms");

    }
}

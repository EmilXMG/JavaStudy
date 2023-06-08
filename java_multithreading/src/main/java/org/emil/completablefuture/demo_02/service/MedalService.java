package org.emil.completablefuture.demo_02.service;

import org.emil.completablefuture.demo_02.entity.MedalInfo;

/**
 * @Author: emil
 * @Date: 2023/6/8 14:15
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class MedalService {
    public MedalInfo getMedalInfo(long userId) throws InterruptedException {
        //模拟调用耗时
        Thread.sleep(500);
        return new MedalInfo("666", "守护勋章");
    }
}

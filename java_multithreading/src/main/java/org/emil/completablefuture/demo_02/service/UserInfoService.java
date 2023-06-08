package org.emil.completablefuture.demo_02.service;

import org.emil.completablefuture.demo_02.entity.UserInfo;

/**
 * @Author: emil
 * @Date: 2023/6/8 14:15
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class UserInfoService {
    public UserInfo getUserInfo(Long userId) throws InterruptedException {
        //模拟调用耗时
        Thread.sleep(300);
        //一般是查数据库，或者远程调用返回的
        return new UserInfo("666", "捡田螺的小男孩", 27);
    }
}

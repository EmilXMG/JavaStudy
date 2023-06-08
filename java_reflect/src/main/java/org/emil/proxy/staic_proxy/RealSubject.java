package org.emil.proxy.staic_proxy;

/**
 * @Author: emil
 * @Date: 2023/5/31 0:40
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class RealSubject extends Subject {
    @Override
    public void request() {
        System.out.println("真实请求体");
    }
}

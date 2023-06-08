package org.emil.proxy.staic_proxy;

/**
 * @Author: emil
 * @Date: 2023/5/31 0:41
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class Proxy extends Subject {
    private RealSubject realSubject;


    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        realSubject.request();
    }
}

package org.emil.proxy.dynamic_proxy;

/**
 * @Author: emil
 * @Date: 2023/5/31 11:31
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class RealSubject implements Subject {
    @Override
    public void hello(String str) {
        System.out.println("Hello  " + str);
    }

    @Override
    public String bye() {
        System.out.println("Goodbye");
        return "Over";
    }
}

package com.emil.basic.java_reflect.method_invoke;

import java.lang.reflect.Method;

/**
 * 通过抛出异常方式 打印 Method.invoke 调用轨迹
 *
 * @Author: emil
 * @Date: 2023/5/15 9:58
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class MethodInvokeDemo {
    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.emil.basic.java_reflect.method_invoke.MethodInvokeDemo");
        Method method = clazz.getMethod("target", int.class);
        method.invoke(null, 0);
    }
}

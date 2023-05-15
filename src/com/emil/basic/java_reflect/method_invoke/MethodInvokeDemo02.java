package com.emil.basic.java_reflect.method_invoke;

import java.lang.reflect.Method;

/**
 * @Author: emil
 * @Date: 2023/5/15 10:28
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class MethodInvokeDemo02 {
    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.emil.basic.java_reflect.method_invoke.MethodInvokeDemo");
        Method method = clazz.getMethod("target", int.class);
        for (int i = 0; i < 20; i++) {
            method.invoke(null, i);
        }
    }
}

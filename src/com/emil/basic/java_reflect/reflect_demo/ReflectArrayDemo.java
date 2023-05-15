package com.emil.basic.java_reflect.reflect_demo;

import java.lang.reflect.Array;

/**
 * @Author: emil
 * @Date: 2023/5/15 12:23
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class ReflectArrayDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");
        Object array = Array.newInstance(clazz, 25);
        //往数组里添加内容
        Array.set(array, 0, "Scala");
        Array.set(array, 1, "Java");
        Array.set(array, 2, "Groovy");
        Array.set(array, 3, "Scala");
        Array.set(array, 4, "Clojure");
        //获取某一项的内容
        System.out.println(Array.get(array, 3));
    }
}

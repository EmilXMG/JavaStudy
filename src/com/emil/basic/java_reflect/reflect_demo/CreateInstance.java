package com.emil.basic.java_reflect.reflect_demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 创建实例
 *
 * @Author: emil
 * @Date: 2023/5/15 11:33
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class CreateInstance {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 创建StringBuilder对象
        Class<?> c1 = StringBuilder.class;
        StringBuilder sb = (StringBuilder) c1.newInstance();
        sb.append("emil");
        System.out.println(sb);

        // 获取String所对应的class对象
        Class<?> c2 = String.class;
        // 获取String类带一个String参数的构造器
        Constructor constructor = c2.getConstructor(String.class);
        // 根据构造器创建实例
        String string = (String) constructor.newInstance("Hello");
        System.out.println(string);
    }

}

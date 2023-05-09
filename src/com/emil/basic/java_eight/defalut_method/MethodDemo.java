package com.emil.basic.java_eight.defalut_method;

/**
 * @Author: 13419
 * @Date: 2023/5/9 15:09
 * @Version: v1.0.0
 * @Description: TODO
 **/
public interface MethodDemo {

    default void def() {
        System.out.println("MethodDemo 默认方法");
    }
}

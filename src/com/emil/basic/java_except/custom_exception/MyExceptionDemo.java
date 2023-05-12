package com.emil.basic.java_except.custom_exception;

/**
 * @Author: emil
 * @Date: 2023/5/11 19:06
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class MyExceptionDemo {
    public static void main(String[] args) {
        throw new MyException("自定义异常！");
    }
}

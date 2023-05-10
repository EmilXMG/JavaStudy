package com.emil.basic.java_generic.singlegeneraticclass;

/**
 * 单类型参数的泛型类
 *
 * @Author: emil
 * @Date: 2023/4/25 0:23
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class SingleGenericsClassDemo {
    public static void main(String[] args) {
        Data<String> data = new Data<>();
        data.setValue("123");
        System.out.println(data.toString());

        Data<Integer> data1 = new Data<>();
        data1.setValue(132);
        System.out.println(data1);
    }
}

package com.emil.basic.java_generic.genericslimit;

/**
 * 泛型上界
 *
 * @Author: 13419
 * @Date: 2023/4/25 10:13
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class EmilDemo<T extends Number> {  // 此处泛型只能是数字类型
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "EmilDemo{" +
                "value=" + value +
                '}';
    }
}

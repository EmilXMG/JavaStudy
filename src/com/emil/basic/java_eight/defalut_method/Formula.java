package com.emil.basic.java_eight.defalut_method;

import java.math.BigDecimal;

/**
 * 默认方法实例
 *
 * @Author: emil
 * @Date: 2023/5/8 16:51
 * @Version: v1.0.0
 * @Description: TODO
 **/
public interface Formula {
    // 非默认方法
    double calculate(int a);

    // 默认方法
    default double sqrt(int value) {
        return Math.sqrt(value);
    }

    default void def() {
        System.out.println("Formula 默认方法");
    }

    static double add(int a, int b) {
        return new BigDecimal(String.valueOf(a)).add(new BigDecimal(String.valueOf(b))).doubleValue();
    }

    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return a * 100;
            }
        };

        System.out.println(formula.calculate(10));
    }
}

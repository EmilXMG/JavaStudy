package com.emil.basic.java_eight.defalut_method;

/**
 * 实现 Formula和MethodDemo
 *
 * @Author: emil
 * @Date: 2023/5/9 15:16
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class InterfaceNewImpl implements Formula, MethodDemo {

    public static void main(String[] args) {
        InterfaceNewImpl interfaceNew = new InterfaceNewImpl();
        interfaceNew.def();
        System.out.println(Formula.add(1, 2));
    }

    @Override
    public double calculate(int a) {
        return 0;
    }

    @Override
    public void def() {
        Formula.super.def();
    }
}

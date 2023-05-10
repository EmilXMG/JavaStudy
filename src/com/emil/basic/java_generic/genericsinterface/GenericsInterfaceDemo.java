package com.emil.basic.java_generic.genericsinterface;

/**
 * @Author: 13419
 * @Date: 2023/4/25 0:43
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class GenericsInterfaceDemo implements Content<Integer> {

    private int text;

    public GenericsInterfaceDemo(int text) {
        this.text = text;
    }

    @Override
    public Integer text() {
        return text;
    }

    public static void main(String[] args) {
        GenericsInterfaceDemo genericsInterfaceDemo = new GenericsInterfaceDemo(10);
        System.out.println(genericsInterfaceDemo.text());
    }
}

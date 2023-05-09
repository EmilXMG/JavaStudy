package com.emil.basic.genericstudy.genericswildcard;

import java.util.Arrays;
import java.util.List;

/**
 * 上界通配符
 *
 * @Author: 13419
 * @Date: 2023/4/25 10:44
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class GenericsUpperWildcard {
    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number number : list) {
            s += number.doubleValue();
        }
        return s;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        System.out.println(sumOfList(list));
    }
}

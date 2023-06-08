package org.emil.genericswildcard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 下界通配符
 *
 * @Author: 13419
 * @Date: 2023/4/25 21:56
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class GenericsDownWildcard {
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        addNumbers(list);
        System.out.println(Arrays.deepToString(list.toArray()));
    }
}

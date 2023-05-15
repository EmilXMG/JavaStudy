package com.emil.basic.java_reflect.reflect_demo;

import java.util.ArrayList;
import java.util.List;

/**
 * instanceof 关键字
 *
 * @Author: emil
 * @Date: 2023/5/15 11:16
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class InstanceOfDemo {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        if (arrayList instanceof List) {
            System.out.println("ArrayList is List");
        }
        if (List.class.isInstance(arrayList)) {
            System.out.println("ArrayList is List");
        }
    }
}

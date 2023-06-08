package org.emil.reflect_demo;

import java.util.HashSet;
import java.util.Set;

/**
 * Object 的 getClass 方法
 *
 * @Author: emil
 * @Date: 2023/5/15 11:13
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class GetClassByObject {
    enum E {A, B}

    public static void main(String[] args) {
        Class c = "foo".getClass();
        System.out.println(c.getCanonicalName());

        Class c2 = GetClassByObject.E.A.getClass();
        System.out.println(c2.getCanonicalName());

        byte[] bytes = new byte[1024];
        Class c3 = bytes.getClass();
        System.out.println(c3.getCanonicalName());

        Set<String> set = new HashSet<>();
        Class c4 = set.getClass();
        System.out.println(c4.getCanonicalName());
    }
}

package org.emil.reflect_demo;

/**
 * 类名 + .class
 *
 * @Author: emil
 * @Date: 2023/5/15 11:08
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class GetClassByClassName {
    public static void main(String[] args) {
        boolean b;
        //Class c = b.getName(); // 编译错误
        Class c1 = boolean.class;
        System.out.println(c1.getName());

        Class c2 = java.io.PrintStream.class;
        System.out.println(c2.getCanonicalName());

        Class c3 = int[][][].class;
        System.out.println(c3.getCanonicalName());
    }
}

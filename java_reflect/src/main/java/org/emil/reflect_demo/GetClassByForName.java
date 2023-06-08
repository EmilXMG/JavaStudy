package org.emil.reflect_demo;

/**
 * Class.forName 测试
 *
 * @Author: emil
 * @Date: 2023/5/15 10:47
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class GetClassByForName {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("org.emil.reflect_demo.GetClassByForName");
        System.out.println(clazz.getName());
        System.out.println(clazz.getCanonicalName());
        Class clazz2 = Class.forName("[D");
        System.out.println(clazz2.getCanonicalName());
        Class clazz3 = Class.forName("[[Ljava.lang.String;");
        System.out.println(clazz3.getCanonicalName());
    }
}

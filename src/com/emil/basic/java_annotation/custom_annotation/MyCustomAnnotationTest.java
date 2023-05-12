package com.emil.basic.java_annotation.custom_annotation;

import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 个性化注解测试
 *
 * @Author: emil
 * @Date: 2023/5/12 9:39
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class MyCustomAnnotationTest {

    @Override
    @MyCustomAnnotation(title = "toString方法", description = "覆盖父类toString方法")

    public String toString() {
        return "覆盖父类toString方法";
    }

    @Deprecated
    @MyCustomAnnotation(title = "废弃的deprecate方法", description = "测试废弃的方法")
    public static void deprecatedMethod() {
        System.out.println("废弃的方法");
    }


    @SuppressWarnings({"unchecked", "deprecation"})
    @MyCustomAnnotation(title = "test method", description = "suppress warning static method")
    public static void genericsTest() throws FileNotFoundException {
        List l = new ArrayList();
        l.add("abc");
        deprecatedMethod();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 获取所有method
        Method[] methods = MyCustomAnnotationTest.class.getClassLoader().loadClass("com.emil.basic.java_annotation.custom_annotation.MyCustomAnnotationTest").getMethods();
        // 遍历
        for (Method method : methods) {
            // 判断方法上是否有MyCustomAnnotation注解
            if (method.isAnnotationPresent(MyCustomAnnotation.class)) {
                // 遍历并获取方法上的所有注解
                for (Annotation declaredAnnotation : method.getDeclaredAnnotations()) {
                    System.out.println("注解在方法中'" + method + "' : " + declaredAnnotation);
                }
                // 获取MyCustomAnnotation对象
                MyCustomAnnotation annotation = method.getAnnotation(MyCustomAnnotation.class);
                // 获取属性值
                System.out.println(annotation.description());
            }
        }
    }
}

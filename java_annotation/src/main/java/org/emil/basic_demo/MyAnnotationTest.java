package org.emil.basic_demo;

/**
 * @Author: emil
 * @Date: 2023/5/11 11:02
 * @Version: v1.0.0
 * @Description: TODO
 **/
@MyAnnotation("hello")
public class MyAnnotationTest {
    public static void main(String[] args) {
        MyAnnotation myAnnotation = MyAnnotationTest.class.getDeclaredAnnotation(MyAnnotation.class);
        MyAnnotationTest.class.getDeclaredAnnotations();
        System.out.println(myAnnotation.value());
    }
}

package org.emil.reflect_demo;

import org.emil.pojo.Circle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: emil
 * @Date: 2023/5/15 14:58
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class ReflectMethodDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class clazz = Class.forName("org.emil.pojo.Circle");
        //根据参数获取public的Method,包含继承自父类的方法
        Method method = clazz.getMethod("draw", int.class, String.class);
        System.out.println("method：" + method);

        Method[] methods = clazz.getMethods();
        for (Method method1 : methods) {
            System.out.println("method1：" + method1);
        }
        System.out.println("=========================================");
        // 获取当前类的方法包含private,该方法无法获取继承自父类的method
        Method declaredMethod = clazz.getDeclaredMethod("drawCircle");
        System.out.println("declaredMethod：" + declaredMethod);
        //获取当前类的所有方法包含private,该方法无法获取继承自父类的method
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod1 : declaredMethods) {
            System.out.println("declaredMethod1：" + declaredMethod1);
        }
        //创建对象
        Circle circle = (Circle) clazz.newInstance();
        //获取指定参数的方法对象Method
        Method method1 = clazz.getMethod("draw", int.class, String.class);
        //通过Method对象的invoke(Object obj,Object... args)方法调用
        method1.invoke(circle, 15, "圈圈");
        Method method2 = clazz.getDeclaredMethod("drawCircle");
        // 修改私有方法的访问标识
        method2.setAccessible(true);
        method2.invoke(circle);
        //对有返回值得方法操作
        Method method3 = clazz.getDeclaredMethod("getAllCount");
        Integer count = (Integer) method3.invoke(circle);
        System.out.println("count：" + count);
    }
}

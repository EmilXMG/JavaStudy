package org.emil.reflect_demo;

import org.emil.pojo.Student;

import java.lang.reflect.Field;

/**
 * @Author: emil
 * @Date: 2023/5/15 14:07
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class ReflectFieldDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("org.emil.pojo.Student");
        // 获取指定字段名称的Field类,注意字段修饰符必须为public而且存在该字段,
        // 否则抛NoSuchFieldException
        Field field = clazz.getField("age");
        System.out.println("field：" + field);
        // 获取所有修饰符为public的字段,包含父类字段,注意修饰符为public才会获取
        Field[] fields = clazz.getFields();
        for (Field field1 : fields) {
            System.out.println("field1：" + field1);
        }
        System.out.println("================getDeclaredFields====================");
        // 获取当前类所字段(包含private字段),注意不包含父类的字段
        Field[] field2s = clazz.getDeclaredFields();
        for (Field field2 : field2s) {
            System.out.println("field2：" + field2);
        }
        //获取指定字段名称的Field类,可以是任意修饰符的自动,注意不包含父类的字段
        Field field3 = clazz.getDeclaredField("desc");
        System.out.println("field3：" + field3);

        // 下面将通过Field类本身的方法对指定类属性赋值
        Student student = (Student) clazz.newInstance();
        // 获取父类public字段并赋值
        Field ageField = clazz.getField("age");
        ageField.set(student, 30);
        Field nameField = clazz.getField("name");
        nameField.set(student, "Lily");
        //只获取当前类的字段,不获取父类的字段
        Field descField = clazz.getDeclaredField("desc");
        descField.set(student, "I am student");
        Field scoreField = clazz.getDeclaredField("score");

        //设置可访问，score是private的
        scoreField.setAccessible(true);
        scoreField.set(student, 99);
        System.out.println(student.toString());
        // 输出结果：Student{desc='I am student', score=99, age=30, name='Lily'}
        // 获取字段值
        System.out.println(student.getScore());
        // 输出：99

    }
}
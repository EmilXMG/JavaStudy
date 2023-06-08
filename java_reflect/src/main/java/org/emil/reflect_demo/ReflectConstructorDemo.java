package org.emil.reflect_demo;

import org.emil.pojo.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

/**
 * @Author: emil
 * @Date: 2023/5/15 15:33
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class ReflectConstructorDemo {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = null;
        clazz = Class.forName("org.emil.pojo.User");
        // 第一种方法，实例化默认构造方法，User必须无参构造函数,否则将抛异常
        User user = (User) clazz.newInstance();
        user.setAge(10);
        user.setName("emil");
        System.out.println("user：" + user);
        System.out.println("--------------------------------------------");
        // 获取带String参数的public构造函数
        Constructor constructor = clazz.getConstructor(String.class);
        User user1 = (User) constructor.newInstance("emilXmg");
        user1.setAge(20);
        System.out.println("user1：" + user1);

        System.out.println("--------------------------------------------");

        //取得指定带int和String参数构造函数,该方法是私有构造private
        Constructor constructor1 = clazz.getDeclaredConstructor(int.class, String.class);
        //由于是private必须设置可访问
        constructor1.setAccessible(true);
        User user2 = (User) constructor1.newInstance(30, "hello world");
        System.out.println("user2：" + user2);
        System.out.println("--------------------------------------------");

        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (int i = 0; i < declaredConstructors.length; i++) {
            //获取构造函数参数类型
            Class<?> clazzs[] = declaredConstructors[i].getParameterTypes();
            System.out.println("构造函数[" + i + "]:" + declaredConstructors[i].toString());
            System.out.print("参数类型[" + i + "]:(");
            for (int j = 0; j < clazzs.length; j++) {
                if (j == clazzs.length - 1)
                    System.out.print(clazzs[j].getName());
                else
                    System.out.print(clazzs[j].getName() + ",");
            }
            System.out.println(")");
        }

        System.out.println("--------------------------------------------");
        Constructor constructor2 = clazz.getDeclaredConstructor(int.class, String.class);
        System.out.println("-----getDeclaringClass-----");
        Class ucClass = constructor2.getDeclaringClass();
        // Constructor对象表示的构造方法的类
        System.out.println(ucClass.getName());
        System.out.println("-----getGenericParameterTypes-----");
        //对象表示此 Constructor 对象所表示的方法的形参类型
        Type[] genericParameterTypes = constructor2.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("参数名称：" + genericParameterType.getTypeName());
        }
        System.out.println("-----getParameterTypes-----");
        Class<?>[] parameterTypes = constructor2.getParameterTypes();
        for (Class parameterType : parameterTypes) {
            System.out.println("参数名称：" + parameterType.getName());
        }
        System.out.println("-----getName-----");
        //以字符串形式返回此构造方法的名称
        System.out.println("getName：" + constructor2.getName());
        System.out.println("-----getoGenericString-----");
        //返回描述此 Constructor 的字符串，其中包括类型参数。
        System.out.println("getoGenericString():" + constructor2.toGenericString());
    }
}

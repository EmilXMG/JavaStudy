package org.emil.threadlocal;

import java.util.Random;

/**
 * 在线程内部创建ThreadLocal
 *
 * @Author: emil
 * @Date: 2023/6/26 0:52
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class ThreadLocalTest implements Runnable {

    ThreadLocal<Student> studentThreadLocal = new ThreadLocal<>();

    @Override
    public void run() {
        // 当前线程名称
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName + " is running...");
        Random random = new Random();
        int age = random.nextInt();
        System.out.println(currentThreadName + " is set age: " + age);
        Student student = getStudent();
        student.setAge(age);
        System.out.println(currentThreadName + " is first get age: " + student.getAge());
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(currentThreadName + " is second get age: " + student.getAge());
    }

    private Student getStudent() {
        Student student = studentThreadLocal.get();
        if (student == null) {
            student = new Student();
            studentThreadLocal.set(student);
        }
        studentThreadLocal.remove();
        return student;
    }

    public static void main(String[] args) {
        ThreadLocalTest t = new ThreadLocalTest();
        Thread t1 = new Thread(t, "Thread A");
        Thread t2 = new Thread(t, "Thread B");
        t1.start();
        t2.start();
    }
}


class Student {
    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

package org.emil.cas.atomicdemo;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: emil
 * @Date: 2023/6/25 0:52
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        // 创建两个Person对象，它们的id分别是101和102。
        Person p1 = new Person(101);
        Person p2 = new Person(102);
        // 新建AtomicReference对象，初始化它的值为p1对象
        AtomicReference atomicReference = new AtomicReference(p1);
        // 通过CAS设置ar。如果ar的值为p1的话，则将其设置为p2。
        atomicReference.compareAndSet(p1, p2);
        Person p3 = (Person) atomicReference.get();
        System.out.println("p3 is " + p3);
        System.out.println("p3.equals(p1)=" + p3.equals(p1));
    }
}

class Person {
    // volatile 关键字用于保证对象属性的可见性，即在多线程环境下，一个线程修改了对象属性的值之后，其他线程能够立即看到最新的值。在这个例子中，volatile 修饰的 id 字段保证了 ar.get() 方法能够获取到最新的 id 值。
    volatile long id;

    public Person(long id) {
        this.id = id;
    }

    public String toString() {
        return "id:" + id;
    }
}

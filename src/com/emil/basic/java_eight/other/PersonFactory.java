package com.emil.basic.java_eight.other;

/**
 * @Author: 13419
 * @Date: 2023/5/9 7:58
 * @Version: v1.0.0
 * @Description: TODO
 **/
public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);


    public static void main(String[] args) {
        PersonFactory<Person> personPersonFactory = Person::new;
        Person person = personPersonFactory.create("hello", "test");
        System.out.println(person);
    }
}

package org.emil.manygenericsclass;

/**
 * @Author: 13419
 * @Date: 2023/4/25 0:36
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class ManyGenericsClassDemo {
    public static void main(String[] args) {
        EmilMap<Integer, String> emilMap = new EmilMap<>(1, "123");
        System.out.println(emilMap);
    }
}

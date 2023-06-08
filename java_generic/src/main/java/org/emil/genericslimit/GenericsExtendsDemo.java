package org.emil.genericslimit;

/**
 * @Author: 13419
 * @Date: 2023/4/25 10:22
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class GenericsExtendsDemo {
    static <T extends Comparable<T>> T max(T x, T y, T z) {
        T max = x; // 假设x是初始最大值
        if (y.compareTo(max) > 0) {
            max = y; //y 更大
        }
        if (z.compareTo(max) > 0) {
            max = z; // 现在 z 更大
        }
        return max; // 返回最大对象
    }

    public static void main(String[] args) {
        System.out.println(max(1, 3, 4));
    }
}

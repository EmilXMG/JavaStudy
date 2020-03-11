package com.emil.objectoriented;

/**
 * @author emil
 */
public class ThisInConstructor {
    public int index;

    public ThisInConstructor() {
        int index = 0;
        // 使用 this 代表该构造器正在初始化的对象
        // 下面的代码将会把该构造器正在初始化的对象的foo成员变量设为9
        this.index = 9;
    }

    public static void main(String[] args) {
        System.out.println(new ThisInConstructor().index);
    }
}

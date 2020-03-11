package com.emil.objectoriented;

/**
 * @author emil
 */
public class ReturnThis {
    public int age;

    public ReturnThis grows() {
        age++;
        // 返回调用该方法的对象。
        return this;
    }

    public static void main(String[] args) {
        ReturnThis returnThis = new ReturnThis();
        // 可以连续调用同一个方法
        returnThis.grows().grows().grows();
        System.out.println(returnThis.age);
    }
}

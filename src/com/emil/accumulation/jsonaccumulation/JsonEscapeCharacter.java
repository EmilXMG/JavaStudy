package com.emil.accumulation.jsonaccumulation;

/**
 * Json串中带有转义字符时候的解析方式示例
 *
 * @Author: emil
 * @Date: 2023/4/26 10:12
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class JsonEscapeCharacter {
    public static void main(String[] args) {
        Double d = 10D;
        Integer i = 10;

        byte a = 127;
        byte b = 127;
        b = (byte) (a + b); // error : cannot convert from int to byte
        b += a; // ok
        b -= a; // ok
    }
}

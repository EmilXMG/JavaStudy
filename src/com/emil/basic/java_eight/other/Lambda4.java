package com.emil.basic.java_eight.other;

/**
 * @Author: 13419
 * @Date: 2023/5/9 10:24
 * @Version: v1.0.0
 * @Description: TODO
 **/
class Lambda4 {
    static int outerStaticNum;
    int outerNum;

    void testScopes() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };

        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
    }
}
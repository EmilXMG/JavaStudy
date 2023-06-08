package org.emil.other;

import org.emil.m_c_reference.Something;

/**
 * @Author: 13419
 * @Date: 2023/5/8 17:35
 * @Version: v1.0.0
 * @Description: TODO
 **/
//@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);

    default int a() {
        return 0;
    }

    static int b() {
        return 0;
    }

    public static void main(String[] args) {
        //Converter<String, Integer> converter1 = new Converter<String, Integer>() {
        //    @Override
        //    public Integer convert(String from) {
        //        return Integer.valueOf(from);
        //    }
        //};
        Converter<String, Integer> converter = from -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);

        Something something = new Something();
        Converter<String, String> converter2 = something::startsStrings;
        String converted2 = converter2.convert("HELLO");
        System.out.println(converted2);


        int a = 10;
        Converter<Integer, String> converter3 = from -> String.valueOf(from + a);
        //a = 9;
        System.out.println(converter3.convert(3));


    }
}

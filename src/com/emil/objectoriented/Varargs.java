package com.emil.objectoriented;

/**
 * @author emil
 */
public class Varargs {
    public static void test(String param,String ...books){
        for (String book : books) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        test("参数可变函数","JAVA","PYTHON","MYSQL");
    }
}

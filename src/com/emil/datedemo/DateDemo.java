package com.emil.datedemo;

import java.util.Date;

/**
 * @author emil
 */
public class DateDemo {
    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(new Date(21312323));
        System.out.println(System.currentTimeMillis());


        //综合案例
        long dateTime = System.currentTimeMillis() - 10000;
        Date date1 = new Date(dateTime);
        Date date2 = new Date();
        System.out.println("date2和date1相差:" + (date2.getTime() - date1.getTime()));
        System.out.println("date2在date1之后:" + date2.after(date1));
        System.out.println("date2在date1之前:" + date2.before(date1));
        System.out.println("data2和date1比较:" + date1.compareTo(date2));
        System.out.println(new Date().compareTo(new Date()));
        System.out.println(date1.equals(date2));
        Date date3 = null;
        try {
            System.out.println(date2.after(date3));
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }
}

package com.emil.datedemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author emil
 */
public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {
        // 日期到字符串(Date->String)
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String dateString1 = dateFormat.format(date);
        System.out.println(dateString1);
        // 2020-03-10 23:10:22:351

        // 日期到字符串(String->Date)
        String dateString2 = "2020-03-10 23:10:22:351";
        Date parseDate = dateFormat.parse(dateString2);
        System.out.println(parseDate);
        // Tue Mar 10 23:10:22 CST 2020
    }
}

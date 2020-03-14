package com.emil.datedemo.simpledateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author emil
 */
public class SimpleDateFormatMultiThreadingToDate {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println("【" + Thread.currentThread().getName() + "】" + sdf.parse("1998-02-17 21:15:32"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }, "SDF转换线程-" + i).start();
        }
    }
}
/**
 * java.lang.NumberFormatException: For input string: "E.2221E1"
 * at sun.misc.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2043)
 * at sun.misc.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
 * 【SDF转换线程-8】Tue Feb 17 21:15:32 CST 1998
 * 【SDF转换线程-9】Tue Feb 17 21:15:32 CST 1998
 * 【SDF转换线程-6】Mon May 27 16:33:06 CST 289854777
 */

package com.emil.datedemo.localdate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author emil
 */
public class LocalDateTimeMultiThreading {
    public static void main(String[] args) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 获取当前时区ID
        ZoneId zoneId = ZoneId.systemDefault();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                LocalDateTime dateTime = LocalDateTime.parse("1998-02-17 21:15:32", dateFormat);
                //获取当前时区的实例
                Instant instant = dateTime.atZone(zoneId).toInstant();
                Date date = Date.from(instant);
                System.out.println("【" + Thread.currentThread().getName() + "】" + date);
            }, "SDF转换线程-" + i).start();
        }
    }
    /**
     *【SDF转换线程-3】Tue Feb 17 21:15:32 CST 1998
     * 【SDF转换线程-7】Tue Feb 17 21:15:32 CST 1998
     * 【SDF转换线程-2】Tue Feb 17 21:15:32 CST 1998
     * 【SDF转换线程-1】Tue Feb 17 21:15:32 CST 1998
     * 【SDF转换线程-4】Tue Feb 17 21:15:32 CST 1998
     * 【SDF转换线程-5】Tue Feb 17 21:15:32 CST 1998
     * 【SDF转换线程-0】Tue Feb 17 21:15:32 CST 1998
     * 【SDF转换线程-6】Tue Feb 17 21:15:32 CST 1998
     * 【SDF转换线程-9】Tue Feb 17 21:15:32 CST 1998
     * 【SDF转换线程-8】Tue Feb 17 21:15:32 CST 1998
     */
}
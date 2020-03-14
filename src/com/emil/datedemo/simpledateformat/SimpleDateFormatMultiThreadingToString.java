package com.emil.datedemo.simpledateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatMultiThreadingToString {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println("【" + Thread.currentThread().getName() + "】" + sdf.format(new Date()));
            }, "SDF转换线程-" + i).start();
        }
    }
    /**
     * 【SDF转换线程-0】2020-03-13
     * 【SDF转换线程-2】2020-03-13
     * 【SDF转换线程-3】2020-03-13
     * 【SDF转换线程-1】2020-03-13
     * 【SDF转换线程-4】2020-03-13
     * 【SDF转换线程-5】2020-03-13
     * 【SDF转换线程-8】2020-03-13
     * 【SDF转换线程-6】2020-03-13
     * 【SDF转换线程-9】2020-03-13
     * 【SDF转换线程-7】2020-03-13
     */
}

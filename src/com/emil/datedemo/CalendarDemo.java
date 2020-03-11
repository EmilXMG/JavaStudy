package com.emil.datedemo;

import java.util.Calendar;

/**
 * @author emil
 */
public class CalendarDemo {
    public static void main(String[] args) {
        // 获取实例对象
        Calendar calendar = Calendar.getInstance();
        // 计算30年后的日期
        calendar.add(Calendar.YEAR, 30);
        // 减两年
        calendar.add(Calendar.YEAR, -2);
        // 通过9月计算8月的最后一天
        calendar.set(calendar.get(Calendar.YEAR), 8, 1);
        // 9月的第一天减一
        calendar.add(Calendar.DATE, -1);
        String dateString = String.format("当前日期格式:%s-%s-%s %s:%s:%s",
                calendar.get(Calendar.YEAR),
                //月是从0开始，所以要加1
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND));
        System.out.println(dateString);
    }
}

package com.emil.datedemo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * @author emil
 */
public class LocalDateCalculation {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.parse("1988-09-15");
        System.out.println("所在月的第一天：" + localDate.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("所在月的第二天：" + localDate.withDayOfMonth(2));
        System.out.println("所在月的最后一天：" + localDate.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("300年后的日期：" + localDate.plusYears(300));
        System.out.println("300个月的日期：" + localDate.plusMonths(300));
        System.out.println("日期所处月的第一个周一的日期：" + localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
        System.out.println("所处年的第一个周一所在日期：" + LocalDate.parse("1998-01-02").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
    }
    /**
     * 所在月的第一天：1988-09-01
     * 所在月的第二天：1988-09-02
     * 所在月的最后一天：1988-09-30
     * 300年后的日期：2288-09-15
     * 300个月的日期：2013-09-15
     * 日期所处月的第一个周一的日期：1988-09-05
     * 所处年的第一个周一所在日期：1998-01-05
     */
}

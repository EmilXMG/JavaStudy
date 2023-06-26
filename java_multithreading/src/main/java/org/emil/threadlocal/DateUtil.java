package org.emil.threadlocal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * java 开发手册中推荐的 ThreadLocal
 *
 * @Author: emil
 * @Date: 2023/6/26 0:45
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class DateUtil {
    public static final ThreadLocal<DateFormat> df = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
}

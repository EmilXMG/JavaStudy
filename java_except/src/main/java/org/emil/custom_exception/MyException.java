package org.emil.custom_exception;

/**
 * 自定义异常
 *
 * @Author: emil
 * @Date: 2023/5/11 19:04
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class MyException extends RuntimeException {

    public MyException(String message) {
        super(message);
    }

}

package org.emil.defalut_method;

/**
 * @Author: emil
 * @Date: 2023/5/9 15:09
 * @Version: v1.0.0
 * @Description: TODO
 **/
public interface MethodDemo {

    default void def() {
        System.out.println("MethodDemo 默认方法");
    }
}

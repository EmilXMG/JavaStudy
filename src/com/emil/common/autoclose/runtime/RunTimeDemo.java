package com.emil.common.autoclose.runtime;

import java.io.IOException;

/**
 * Runtime类中的构造方法已经被私有化，Runtime属于单例设计模式
 *
 * @author emil
 */
public class RunTimeDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        //获取Runtime类的实例
        Runtime runtime = Runtime.getRuntime();
        // 每当通过RunTime启动一个进程之后实际上会返回一个进程对象，（执行Windows中的命令）。
        Process process = runtime.exec("notepad.exe");
        // 运行两秒的进程
        Thread.sleep(2000);
        //销毁进程
        process.destroy();
    }
}

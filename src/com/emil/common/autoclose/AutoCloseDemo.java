package com.emil.common.autoclose;

/**
 * 继承自动关闭接口
 */
interface IMessage extends AutoCloseable {
    /**
     * 发送消息
     *
     * @param msg
     */
    void send(String msg);
}

class Message implements IMessage {

    /**
     * 初始化的时候连接服务器
     */
    public Message() {
        System.out.println("【连接】连接远程服务器，创建消息连接通道....");
    }

    /**
     * 发送消息
     *
     * @param msg
     */
    @Override
    public void send(String msg) {
        if (msg.contains("emil")) {
            throw new RuntimeException("你好EMIL");
        }
        System.out.println("【发送】" + msg);
    }

    /**
     * 关闭资源
     */
    @Override
    public void close() {
        System.out.println("【关闭】消息发送完毕，服务器关闭...");
    }
}

/**
 * @author emil
 */
public class AutoCloseDemo {
    public static void main(String[] args) {
        try (Message message = new Message()) {
            message.send("马远林，emil");
        } catch (Exception e) {

        }
    }
}

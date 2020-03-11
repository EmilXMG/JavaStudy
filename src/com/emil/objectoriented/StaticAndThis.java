package com.emil.objectoriented;

/**
 * @author emil
 */
public class StaticAndThis {
    public void run() {
        System.out.println("run");
    }

    public void jump() {
        this.run();
        System.out.println("jump");
    }

    public static void look(){
        //run();
        //静态成员不能直接接访问非静态成员
        System.out.println("look");
    }

    public static void main(String[] args) {
        StaticAndThis staticAndThis  = new StaticAndThis();
        staticAndThis.jump();
        StaticAndThis.look();
    }
}

package com.emil.basic.java_reflect.pojo;

public class Student extends Person {
    public String desc;
    private int score;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "desc='" + desc + '\'' +
                ", score=" + score +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

package org.emil.singlegeneraticclass;

/**
 * @Author: 13419
 * @Date: 2023/4/25 0:24
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class Data<T> {

    private T value;

    public Data() {
    }

    public Data(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Info{" + "value=" + value + '}';
    }
}

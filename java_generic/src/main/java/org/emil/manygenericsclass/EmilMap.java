package org.emil.manygenericsclass;

/**
 * @Author: 13419
 * @Date: 2023/4/25 0:34
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class EmilMap<K, V> {
    private K key;
    private V value;

    public EmilMap(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyMap{" + "key=" + key + ", value=" + value + '}';
    }
}

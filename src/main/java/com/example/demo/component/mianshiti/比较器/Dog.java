package com.example.demo.component.mianshiti.比较器;

import lombok.Data;

/**
 * @author luoYong
 * @version 1.0
 * @date 2022/12/7 14:39
 */
@Data
public class Dog implements Comparable<Dog> {

    private String type;
    private double price;

    public Dog() {
    }

    public Dog(String name, int price) {
        this.type = name;
        this.price = price;
    }

    public String toString() {
        return "狗品种为：" + type + "，价格为：" + price;
    }

    //重写比较方法进行升序排序
    @Override
    public int compareTo(Dog o) {
        if (this.price > o.price) {
            return 1;
        } else if (this.price < o.price) {
            return -1;
        }
        return 0;
    }
}

package com.example.demo.component.mianshiti.比较器;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author luoYong
 * @version 1.0
 * @date 2022/12/7 9:47
 */
public class ComparableTest {

    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog("泰迪", 10),
                new Dog("柯基", 78),
                new Dog("柴犬", 55),
                new Dog("藏獒", 42),
                new Dog("斗牛犬", 15)
        };
        //升序
        Arrays.sort(dogs);
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
    }
}

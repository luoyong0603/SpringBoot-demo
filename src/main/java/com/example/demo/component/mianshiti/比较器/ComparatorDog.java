package com.example.demo.component.mianshiti.比较器;

import java.util.Comparator;

/**
 * @author luoYong
 * @version 1.0
 * @date 2022/12/7 14:50
 */
public class ComparatorDog implements Comparator<Dog> {


    @Override
    public int compare(Dog o1, Dog o2) {
        //升序
        if (o1.getPrice() > o2.getPrice()) {
            return 1;
        } else if (o1.getPrice() < o2.getPrice()) {
            return -1;
        }
        return 0;
    }
}

package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CompareTest {


    //提取List对象中的id到新List中；
    @Test
    void test1() {
//        String [] str = new String[5];
        String[] str = {"1", "5", "2", "0", "3"};
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);//倒序。
                //或者
//                return Integer.valueOf(o2) - Integer.valueOf(o1);//顺序
            }
        });
        for (String s : str) {
            System.out.print(s);
        }
    }

    @Test
    void test2() {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
//        arr.sort();
        Collections.sort(arr);

    }


}




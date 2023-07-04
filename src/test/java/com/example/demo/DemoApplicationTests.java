package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {


    //提取List对象中的id到新List中；
    @Test
    void test1() {
        String s = "   fly me   to   the moon ";
        s = s.trim();
        int a = s.length() - s.lastIndexOf(" ") - 1;
        System.out.println(a);

        int[] digits = {9, 9, 9, 9};
//        int[] ints = plusOne(digits);


//        addBinary("100", "110010");

    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            //为9说明要进位
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                //不为9直接+1后返回即可
                digits[i] += 1;
                return digits;
            }
        }
        //扩增1
        int[] ans = new int[3];
        //第1为设置1即可
        ans[0] = 1;
        return ans;
    }

}




package com.example.demo.javaTest;


import org.apache.lucene.util.ArrayUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CopyArrTest {



    @Test
    public void test() {
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = new int[5];

        // for循环
        for (int i = 0; i < src.length; i++) {
            dest[i] = src[i];
        }
        assertArrayEquals(src, dest);

        // System.arraycopy()
        System.arraycopy(src, 0, dest, 0, 5);
        assertArrayEquals(src, dest);

        // Arrays.copyOf()
        dest = Arrays.copyOf(src, 5);
        assertArrayEquals(src, dest);

        // Arrays.copyOfRange()
        dest = Arrays.copyOfRange(src, 2, 4);
        int[] expected = {3, 4};
        assertArrayEquals(expected, dest);

        // clone()方法
        dest = src.clone();
        assertArrayEquals(src, dest);
    }
}

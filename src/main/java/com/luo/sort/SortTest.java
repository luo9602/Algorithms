package com.luo.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

/**
 * @author : Administrator
 * @date : 2020/5/26
 * @description :
 */
public class SortTest {

    @Test
    public void test1() {
        int length = 100000;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * length);
        }
        long begin = System.currentTimeMillis();
        BubbleSorting.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

}

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

    int length = 100000;
    int[] arr = new int[length];

    {
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * length);
        }
    }

    /**
     * 冒泡排序
     */
    @Test
    public void test1() {
        long begin = System.currentTimeMillis();
        BubbleSorting.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    /**
     * 选择排序
     */
    @Test
    public void test2() {
        long begin = System.currentTimeMillis();
        SelectSorting.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    /**
     * 插入排序
     */
    @Test
    public void test3() {
        long begin = System.currentTimeMillis();
        InsertionSorting.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

}

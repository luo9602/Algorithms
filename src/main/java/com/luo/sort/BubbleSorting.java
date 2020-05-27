package com.luo.sort;

import java.util.Arrays;

/**
 * @author : Administrator
 * @date : 2020/5/26
 * @description : 冒泡排序 O(n^2)
 */
public class BubbleSorting {

    public static int[] sort(int[] arr) {
        // 是否进行过交换
        boolean flag = false;
        int length = arr.length;
        int temp;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    // 进行交换
                    flag = true;
                }
            }
            // 没有发生过交换
            if (!flag) {
                break;
            } else {
                // 重置
                flag = false;
            }
        }
        return arr;
    }

}

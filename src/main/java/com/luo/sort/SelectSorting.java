package com.luo.sort;

/**
 * @author : Administrator
 * @date : 2020/5/27
 * @description : 选择排序
 */
public class SelectSorting {

    public static void sort(int[] arr) {
        int length = arr.length;
        int min, minIndex;
        for (int i = 0; i < length - 1; i++) {
            min = arr[i];
            minIndex = i;
            // 遍历
            for (int j = i + 1; j < length; j++) {
                // 说明 min 不是真的最小值
                if (min > arr[j]) {
                    // 重置 min
                    min = arr[j];
                    // 重置 minIndex
                    minIndex = j;
                }
            }
            // 判断是否需要交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

}

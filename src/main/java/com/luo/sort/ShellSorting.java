package com.luo.sort;

/**
 * @author : Administrator
 * @date : 2020/5/28
 * @description : 希尔排序
 */
public class ShellSorting {

    /**
     * 希尔排序 交换法
     */
    public static void sortByExchanging(int[] arr) {
        int temp;
        int length = arr.length;
        // 除以 2 分 gap 组, 每组中两相邻元素间隔 gap
        for (int gap = length / 2; gap > 0; gap /= 2) {
            // 从 gap 开始遍历
            for (int i = gap; i < length; i++) {
                // 与同组其他元素对比
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果前面的元素大于后面, 则交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    /**
     * 希尔排序 移位法
     */
    public static void sortByMoving(int[] arr) {
        int j, temp;
        int length = arr.length;
        // 除以 2 分 gap 组, 每组中两相邻元素间隔 gap
        for (int gap = length / 2; gap > 0; gap /= 2) {
            // 从 gap 开始遍历, 对 gap 所在组的所有元素进行插入排序
            for (int i = gap; i < length; i++) {
                j = i;
                temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        // 移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出 while 循环后, 就找到了 temp 插入的位置
                    arr[j] = temp;
                }
            }
        }
    }

}

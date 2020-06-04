package com.luo.sort;

/**
 * @author : Administrator
 * @date : 2020/6/4
 * @description : 归并排序
 */
public class MergeSorting {

    public static void sort(int[] arr) {
        divide(arr, 0, arr.length - 1, new int[arr.length]);
    }

    /**
     * 分 + 治
     *
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param right 右边有序序列的初始索引
     * @param temp  做中转的数组
     */
    private static void divide(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            // 中间索引
            int mid = (left + right) / 2;
            // 向左递归进行分解
            divide(arr, left, mid, temp);
            // 向右递归进行分解
            divide(arr, mid + 1, right, temp);
            // 合并
            conquer(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并的方法(治)
     *
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边有序序列的初始索引
     * @param temp  做中转的数组
     */
    private static void conquer(int[] arr, int left, int mid, int right, int[] temp) {
        // 初始化 i, 左边有序序列的初始索引
        int i = left;
        // 初始化 j, 右边有序序列的初始索引
        int j = mid + 1;
        // 指向 temp 数组的当前索引
        int t = 0;
        // 一、先把左右两边有序序列的数据按照规则填充到 temp 数组, 直到左右两边的有序序列, 有一边处理完毕为止
        while (i <= mid && j <= right) {
            // 如果左边的有序序列的当前元素小于等于右边有序序列的当前元素, 将左边的当前元素, 填充到 temp数组, 然后 t 、i 后移
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            }
            // 反之, 将右边有序序列的当前元素, 填充到 temp 数组, 然后 t 、j 后移
            else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        // 二、把有剩余数据的一边的数据依次全部填充到 temp
        // 左边
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        // 右边
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }
        // 三、将 temp 数组的元素拷贝到 arr, 需要注意并不是每次都拷贝所有
        // 第一次合并 tempLeft = 0 , right = 1
        //  tempLeft = 2  right = 3
        // tempLeft = 0 right = 3
        // 最后一次 tempLeft = 0  right = 7
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }

}

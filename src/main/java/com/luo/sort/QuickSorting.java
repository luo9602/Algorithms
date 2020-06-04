package com.luo.sort;

/**
 * @author : Administrator
 * @date : 2020/5/29
 * @description : 快速排序
 */
public class QuickSorting {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        // pivot 数组中间数的值
        int pivot = arr[(left + right) / 2];
        int temp;
        // while循环的目的是让比 pivot 值小放到左边, 比 pivot 值大放到右边
        while (l < r) {
            // 在 pivot 的左边一直找, 找到大于等于 pivot 值, 退出
            while (arr[l] < pivot) {
                l++;
            }
            // 在 pivot 的右边一直找, 找到小于等于 pivot 值, 退出
            while (arr[r] > pivot) {
                r--;
            }
            // 如果l >= r说明 pivot 的左右两的值, 已经按照左边全部是小于等于 pivot 值, 右边全部是大于等于 pivot 值的规则排好
            if (l >= r) {
                break;
            }
            // 交换左右两边的值
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // 两个 if 防止因多个与 pivot 相等的值而出现死循环
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        // 如果 l == r, 必须 l++, r--, 将 l 和 r 错开, 否则将会栈溢出
        if (l == r) {
            l++;
            r--;
        }
        // 向左递归
        if (left < r) {
            sort(arr, left, r);
        }
        // 向右递归
        if (right > l) {
            sort(arr, l, right);
        }
    }


}

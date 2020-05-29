package com.luo.sort;

/**
 * @author : Administrator
 * @date : 2020/5/28
 * @description : 插入排序
 */
public class InsertionSorting {

    public static void sort(int[] arr) {
        int insertVal, insertIndex;
        // 第一个元素为有序表, 从第二个元素开始其余元素为无序表
        for (int i = 1; i < arr.length; i++) {
            // 待插入的元素
            insertVal = arr[i];
            // 有序表最后一个元素的下标
            insertIndex = i - 1;
            // 由后向前与有序表所有元素对比
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                // 所有元素后移一位
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }
    }

}

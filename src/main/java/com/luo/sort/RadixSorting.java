package com.luo.sort;

/**
 * @author : Administrator
 * @date : 2020/6/12
 * @description : 基数排序(桶排序)
 */
public class RadixSorting {

    public static void sort(int[] arr) {
        // 获取数组中最大的数
        int max = arr[0];
        for (int value : arr) {
            if (max < value) {
                max = value;
            }
        }

        // 最大数的位数
        int maxLength = sizeOfInt(max);

        // 定义一个二维数组表示 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 共10个桶, 每个桶就是一个一维数组
        // (1) 二维数组包含10个一维数组
        // (2) 为了防止将数据放入一维数组时发生数据溢出, 则将每一个一维数组(桶)的大小初始化为 arr.length, 即基数排序是用空间换时间的算法
        int[][] bucket = new int[10][arr.length];

        // 定义一个一维数组存放每个桶中存放数据的个数
        // 比如 bucketElementCounts[0] , 记录的就是 bucket[0] (0号桶) 的放入数据个数
        int[] bucketElementCounts = new int[10];

        // 循环 maxLength 次
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // 将数组中的每一个元素放入桶中, 第一次(n = 1)循环按个位, 第二次(n = 10)十位，第三次(n = 100)百位..
            for (int value : arr) {
                // 每个元素相应位的值
                int digitOfElement = value / n % 10;
                // 放入对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = value;
                // 对应桶计数数组++
                bucketElementCounts[digitOfElement]++;
            }
            // 数组中元素按(个/十/百/..位)放入桶中后, 按顺序取出放回原数组中, 利用一维数组(bucketElementCounts计数数组)取出数据并放回
            // index记录放入原数组的下标
            int index = 0;
            // 遍历一维数组(计数数组)
            for (int j = 0; j < bucketElementCounts.length; j++) {
                // 如果bucketElementCounts中数据不为0, 表示对应的桶中有数据
                if (bucketElementCounts[j] != 0) {
                    for (int k = 0; k < bucketElementCounts[j]; k++) {
                        arr[index++] = bucket[j][k];
                    }
                }
                // 桶中数据取出后, 将计数清零
                bucketElementCounts[j] = 0;
            }
        }
    }

    final static int[] SIZE_TABLE = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};

    static int sizeOfInt(int x) {
        for (int i = 0; ; i++) {
            if (x <= SIZE_TABLE[i]) {
                return i + 1;
            }
        }
    }

}

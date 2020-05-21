package com.luo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Administrator
 * @date : 2020/5/21
 * @description : 八皇后(回溯算法)
 */
public class EightQueens {

    /**
     * 共有8个皇后
     */
    private int max = 8;

    /**
     * 放置的位置, 比如: array = {0, 4, 7, 5, 2, 6, 1, 3}
     */
    private int[] array = new int[max];

    /**
     * 存放所有解法
     */
    private List<List<Integer>> result = new ArrayList<>();

    /**
     * 得出结果
     */
    public List<List<Integer>> getResult() {
        moveChess(0);
        return result;
    }

    /**
     * 放置第 n 个皇后
     *
     * @param n 第 n 个皇后
     */
    private void moveChess(int n) {
        // 已经得出一种解法
        if (n == max) {
            result.add(Arrays.stream(array).boxed().collect(Collectors.toList()));
            return;
        }
        // 依次放入皇后, 并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后 n , 放到该行的第1列
            array[n] = i;
            // 判断当放置第 n 个皇后到 i 列时, 是否冲突
            // 不冲突
            if (isEligible(n)) {
                //接着放 n+1 个皇后, 即开始递归
                moveChess(n + 1);
            }
            // 如果冲突, 就继续执行循环
            // 即将第 n 个皇后放置在本行的后移的一个位置
        }
    }

    /**
     * 查看放置的第 n 个皇后, 该皇后是否和前面已经摆放的皇后冲突
     *
     * @param n 第n个皇后
     * @return 是否冲突
     */
    private boolean isEligible(int n) {
        for (int i = 0; i < n; i++) {
            // array[i] == array[n] 与前面已经摆放的皇后在同一列
            // Math.abs(n - i) == Math.abs(array[n] - array[i]) 与前面已经摆放的皇后在同一斜线
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

}
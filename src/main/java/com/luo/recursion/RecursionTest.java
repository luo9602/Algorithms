package com.luo.recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Administrator
 * @date : 2020/5/21
 * @description :
 */
public class RecursionTest {

    @Test
    public void test1() {
        test(4);
    }

    @Test
    public void test2() {
        System.out.println(factorial(4));
    }

    /**
     * 迷宫回溯
     */
    @Test
    public void test3() {
        // 先创建一个二维数组, 模拟迷宫
        int[][] labyrinth = new int[8][7];
        // 上下全部置为 1  墙体
        for (int i = 0; i < 7; i++) {
            labyrinth[0][i] = 1;
            labyrinth[7][i] = 1;
        }
        // 左右全部置为 1  墙体
        for (int i = 0; i < 8; i++) {
            labyrinth[i][0] = 1;
            labyrinth[i][6] = 1;
        }
        // 设置障碍
        labyrinth[3][1] = 1;
        labyrinth[3][2] = 1;
//        labyrinth[1][2] = 1;
//        labyrinth[2][2] = 1;
        print2dArray(labyrinth);
        System.out.println("___________________________________________________________________________________________________");
        if (LabyrinthBacktracking.findPath2(labyrinth, 1, 1)) {
            System.out.println("find path :");
        } else {
            System.out.println("no path !");
        }
        print2dArray(labyrinth);
    }

    /**
     * 八皇后问题
     */
    @Test
    public void test4() {
        EightQueens eightQueens = new EightQueens();
        List<List<Integer>> result = eightQueens.getResult();
        System.out.println(result.size());
        result.forEach(System.out::println);
    }

    /**
     * 二维数组打印
     */
    private void print2dArray(int[][] array) {
        for (int[] row : array) {
            for (int i : row) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
    }

    /**
     * 阶乘
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println(n);
    }

}

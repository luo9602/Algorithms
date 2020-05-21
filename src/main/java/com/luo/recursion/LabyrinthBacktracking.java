package com.luo.recursion;

/**
 * @author : Administrator
 * @date : 2020/5/21
 * @description : 迷宫回溯问题解决, 用二维数组表示迷宫
 */
public class LabyrinthBacktracking {

    /**
     * 0表示没有经过; 1表示墙体/障碍; 2表示路径; 3表示该点已经过但走不通
     */
    private static int notYet = 0, wall = 1, path = 2, fail = 3;

    /**
     * 终点为 labyrinth[row-2][col-2]
     * labyrinth[i][j]: 0表示没有经过; 1表示墙体/障碍; 2表示路径; 3表示该点已经过但走不通
     * 寻路方式 下 -> 右 -> 上 -> 左
     *
     * @param labyrinth 迷宫
     * @param x         起始位置
     * @param y         起始位置
     * @return 是否找到出路
     */
    public static boolean findPath(int[][] labyrinth, int x, int y) {
        int xRes = labyrinth.length - 2;
        int yRes = labyrinth[0].length - 2;
        if (labyrinth[xRes][yRes] == path) {
            return true;
        } else {
            // 没有经过
            if (labyrinth[x][y] == notYet) {
                // 假设可以走通
                labyrinth[x][y] = path;
                // 下
                if (findPath(labyrinth, x + 1, y)) {
                    return true;
                }
                // 右
                else if (findPath(labyrinth, x, y + 1)) {
                    return true;
                }
                // 上
                else if (findPath(labyrinth, x - 1, y)) {
                    return true;
                }
                // 左
                else if (findPath(labyrinth, x, y - 1)) {
                    return true;
                } else {
                    labyrinth[x][y] = fail;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    /**
     * 寻路方式 下 -> 右 -> 上 -> 左
     */
    public static boolean findPath2(int[][] labyrinth, int x, int y) {
        int xRes = labyrinth.length - 2;
        int yRes = labyrinth[0].length - 2;
        if (labyrinth[xRes][yRes] == path) {
            return true;
        } else {
            // 没有经过
            if (labyrinth[x][y] == notYet) {
                // 假设可以走通
                labyrinth[x][y] = path;
                // 上
                if (findPath2(labyrinth, x - 1, y)) {
                    return true;
                }
                // 右
                else if (findPath2(labyrinth, x, y + 1)) {
                    return true;
                }
                // 下
                else if (findPath2(labyrinth, x + 1, y)) {
                    return true;
                }
                // 左
                else if (findPath2(labyrinth, x, y - 1)) {
                    return true;
                } else {
                    labyrinth[x][y] = fail;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

}

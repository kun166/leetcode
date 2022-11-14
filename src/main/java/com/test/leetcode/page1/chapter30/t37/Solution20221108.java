package com.test.leetcode.page1.chapter30.t37;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: Solution20221108
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/8 09:05
 * @Version: 1.0
 */
public class Solution20221108 {

    public void solveSudoku(char[][] board) {
        boolean[][] a1 = new boolean[9][9];
        boolean[][] a2 = new boolean[9][9];
        boolean[][][] a3 = new boolean[3][3][9];
        Deque<int[]> deque = new LinkedList<>();
        boolean success = false;
        // 第一次遍历，填充boolean数组
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    deque.push(new int[]{i, j});
                    continue;
                }
                int number = board[i][j] - '1';
                a1[i][number] = true;
                a2[number][j] = true;
                a3[i / 3][j / 3][number] = true;
            }
        }

        while (!success) {
            int[] pos = deque.pop();
            for (int i = 1; i <= 9; i++) {
                if (!a1[pos[0]][i] && !a2[i][pos[1]] && !a3[pos[0]][pos[1]][i]) {
                    board[pos[0]][pos[1]] = (char) ('0' + i);
                }
            }
        }

    }
}

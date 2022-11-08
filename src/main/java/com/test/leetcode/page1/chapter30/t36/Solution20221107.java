package com.test.leetcode.page1.chapter30.t36;

/**
 * @ClassName: Solution20221107
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/7 20:16
 * @Version: 1.0
 */
public class Solution20221107 {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] a1 = new boolean[9][9];
        boolean[][] a2 = new boolean[9][9];
        boolean[][][] a3 = new boolean[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '1';
                if (a1[i][num] || a2[num][j] || a3[i / 3][j / 3][num]) {
                    return false;
                }
                a1[i][num] = true;
                a2[num][j] = true;
                a3[i / 3][j / 3][num] = true;
            }
        }
        return true;
    }
}

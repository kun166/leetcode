package com.test.leetcode.page1.chapter30.t36;

import java.util.Arrays;

/**
 * @ClassName: Solution20250221
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/21 14:36
 * @Version: 1.0
 */
public class Solution20250221 {

    public boolean isValidSudoku(char[][] board) {
        boolean[] array = new boolean[9];
        // 1,先按行遍历
        for (int i = 0; i < 9; i++) {
            Arrays.fill(array, false);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '1';
                    if (array[index]) {
                        return false;
                    } else {
                        array[index] = true;
                    }
                }
            }
        }
        // 2,按列遍历
        for (int j = 0; j < 9; j++) {
            Arrays.fill(array, false);
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '1';
                    if (array[index]) {
                        return false;
                    } else {
                        array[index] = true;
                    }
                }
            }
        }
        // 3,按方格遍历
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                Arrays.fill(array, false);
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (board[i + m][j + n] != '.') {
                            int index = board[i + m][j + n] - '1';
                            if (array[index]) {
                                return false;
                            } else {
                                array[index] = true;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

}

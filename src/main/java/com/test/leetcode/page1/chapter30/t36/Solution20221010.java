package com.test.leetcode.page1.chapter30.t36;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Solution20221010
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/10 15:49
 * @Version: 1.0
 */
public class Solution20221010 {
    public boolean isValidSudoku(char[][] board) {
        // 先判断行
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        // 再判断列
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.' && set.contains(board[j][i])) {
                    return false;
                }
                set.add(board[j][i]);
            }
        }
        // 再判断小方格
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                set.clear();
                for (int l = 3 * i; l < 3 * i + 3; l++) {
                    for (int m = 3 * j; m < 3 * j + 3; m++) {
                        if (board[l][m] != '.' && set.contains(board[l][m])) {
                            return false;
                        }
                        set.add(board[l][m]);
                    }
                }
            }
        }
        return true;
    }
}

package com.test.leetcode.page1.chapter30.t36;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Solution20220311
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/3/11 10:05
 * @Version: 1.0
 */
public class Solution20220311 {

    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        int m = board.length, n = board[0].length;
        // 先判断每一行是否符合要求
        for (int i = 0; i < m; i++) {
            set.clear();
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        // 再判断每一列是否符合要求
        for (int i = 0; i < n; i++) {
            set.clear();
            for (int j = 0; j < m; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (set.contains(board[j][i])) {
                    return false;
                }
                set.add(board[j][i]);
            }
        }
        // 判断小方格
        for (int i = 0; i < m / 3; i++) {
            for (int j = 0; j < n / 3; j++) {
                set.clear();
                for (int o = 3 * i; o < 3 * i + 3; o++) {
                    for (int p = 3 * j; p < 3 * j + 3; p++) {
                        if (board[o][p] == '.') {
                            continue;
                        }
                        if (set.contains(board[o][p])) {
                            return false;
                        }
                        set.add(board[o][p]);
                    }
                }
            }
        }
        return true;
    }
}

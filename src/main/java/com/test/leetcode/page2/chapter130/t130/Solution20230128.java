package com.test.leetcode.page2.chapter130.t130;

/**
 * @ClassName: Solution20230128
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/28 16:12
 * @Version: 1.0
 */
public class Solution20230128 {

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        // 1,把所有的O变成M
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'M';
                }
            }
        }
        // 1.1,四条边的M变成O
        for (int i = 0; i < m; i++) {
            // 左边
            if (board[i][0] == 'M') {
                board[i][0] = 'O';
            }
            // 右边
            if (board[i][n - 1] == 'M') {
                board[i][n - 1] = 'O';
            }
        }
        for (int i = 0; i < n; i++) {
            // 上边
            if (board[0][i] == 'M') {
                board[0][i] = 'O';
            }
            //下边
            if (board[m - 1][i] == 'M') {
                board[m - 1][i] = 'O';
            }
        }
        // 2,转圈
        int rowMin = 0, rowMax = m - 1, colMin = 0, colMax = n - 1, cycle = 0;
        while (rowMin <= rowMax && colMin <= colMax) {
            if (cycle % 4 == 0) {
                // 从左到右
                for (int i = colMin; i <= colMax; i++) {
                    if (board[rowMin][i] == 'O') {
                        // 向右的下一个变成O
                        if (i < colMax && board[rowMin][i + 1] == 'M') {
                            board[rowMin][i + 1] = 'O';
                        }
                        // 向下的下一个变成O
                        if (rowMin < rowMax && board[rowMin + 1][i] == 'M') {
                            board[rowMin + 1][i] = 'O';
                        }
                    }
                }
                rowMin++;
                cycle++;
            }
            if (cycle % 4 == 1) {
                // 从上向下
                for (int i = rowMin; i <= rowMax; i++) {
                    if (board[i][colMax] == 'O') {
                        // 向下的变成O
                        if (i < rowMax && board[i + 1][colMax] == 'M') {
                            board[i + 1][colMax] = 'O';
                        }
                        // 向左的变成O
                        if (colMin < colMax && board[i][colMax - 1] == 'M') {
                            board[i][colMax - 1] = 'O';
                        }
                    }
                }
                colMax--;
                cycle++;
            }
            if (rowMin <= rowMax && colMin <= colMax) {
                if (cycle % 4 == 2) {
                    // 从右向左
                    for (int i = colMax; i >= colMin; i--) {
                        if (board[rowMax][i] == 'O') {
                            // 向左的下一个变成O
                            if (i > colMin && board[rowMax][i - 1] == 'M') {
                                board[rowMax][i - 1] = 'O';
                            }
                            // 向上的下一个变成O
                            if (rowMin < rowMax && board[rowMax - 1][i] == 'M') {
                                board[rowMax - 1][i] = 'O';
                            }
                        }
                    }
                    rowMax--;
                    cycle++;
                }

                if (cycle % 4 == 3) {
                    // 从下向上
                    for (int i = rowMax; i >= rowMin; i--) {
                        if (board[i][colMin] == 'O') {
                            // 向上的变成O
                            if (i > rowMin && board[i - 1][colMin] == 'M') {
                                board[i - 1][colMin] = 'O';
                            }
                            // 向右的变成O
                            if (colMin < colMax && board[i][colMin + 1] == 'M') {
                                board[i][colMin + 1] = 'O';
                            }
                        }
                    }
                    colMin++;
                    cycle++;
                }
            }
        }

        // 3,把所有的M变成X
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'M') {
                    board[i][j] = 'X';
                }
            }
        }
    }

}

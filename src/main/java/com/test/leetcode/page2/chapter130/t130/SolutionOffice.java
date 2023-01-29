package com.test.leetcode.page2.chapter130.t130;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-16 11:03
 */
public class SolutionOffice {

    int n, m;

    public void solve(char[][] board) {
        // 行
        n = board.length;
        if (n == 0) {
            return;
        }
        // 列
        m = board[0].length;
        // 递归左右两个外边
        for (int i = 0; i < n; i++) {
            // 二维数组的左右两边
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }
        // 递归上下两个边
        for (int i = 1; i < m - 1; i++) {
            // 二维数组的上下两边
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }

        // 遍历二维数组。将联通的'A'改为'O',将非联通的'O'改为'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * 将该边缘为'O'的修改为'A'。然后递归该坐标的前后左右
     *
     * @param board 二维数组
     * @param x     行
     * @param y     列
     */
    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
            // 如果是超界了，或者该坐标不是'O'，则返回
            //1,超界
            //2,该坐标不是'O'
            // 满足一个即可
            return;
        }
        // 将坐标是'O'且能联通的定为'A'
        board[x][y] = 'A';
        // 前后左右的'O'也定位'A'。且会递归下去
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }
}

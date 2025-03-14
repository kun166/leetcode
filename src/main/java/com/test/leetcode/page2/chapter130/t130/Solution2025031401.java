package com.test.leetcode.page2.chapter130.t130;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: Solution2025031401
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/14 11:23
 * @Version: 1.0
 */
public class Solution2025031401 {

    @Test
    public void test() {
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        System.out.println(JSON.toJSONString(board));
        solve(board);
        System.out.println(JSON.toJSONString(board));
    }

    /**
     * 呃，除了这种方式还有别的么
     *
     * @param board
     */
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        // 1,遍历左右两边,将联通的O变成U
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                search(board, i, 0);
            if (board[i][n - 1] == 'O')
                search(board, i, n - 1);
        }

        // 2,遍历上下两边,将联通的O变成U
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O')
                search(board, 0, i);
            if (board[m - 1][i] == 'O')
                search(board, m - 1, i);
        }

        // 3,将U变成O,将O变成X
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == 'U')
                    board[i][j] = 'O';
            }
        }
    }

    /**
     * 递归将O变成U
     *
     * @param board
     * @param row
     * @param column
     */
    public void search(char[][] board, int row, int column) {
        // 如果越界,就退出
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length)
            return;
        if (board[row][column] == 'X' || board[row][column] == 'U')
            return;
        board[row][column] = 'U';
        search(board, row + 1, column);
        search(board, row - 1, column);
        search(board, row, column + 1);
        search(board, row, column - 1);
    }
}

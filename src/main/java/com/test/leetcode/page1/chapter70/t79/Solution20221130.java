package com.test.leetcode.page1.chapter70.t79;

import org.junit.Test;

/**
 * @ClassName: Solution20221130
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/30 21:32
 * @Version: 1.0
 */
public class Solution20221130 {

    @Test
    public void test() {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCCED"));
    }

    boolean find = false;
    boolean[][] use;

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        if (m * n < word.length()) {
            return false;
        }

        use = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    use[i][j] = true;
                    exist(board, word, i, j, 1);
                    if (find) {
                        return true;
                    }
                    use[i][j] = false;
                }
            }
        }
        return false;
    }

    public void exist(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) {
            find = true;
        }
        // 前后左右方向寻找
        // 向上
        int nextRow = row - 1;
        if (!find && nextRow >= 0 && !use[nextRow][col] && board[nextRow][col] == word.charAt(index)) {
            use[nextRow][col] = true;
            exist(board, word, nextRow, col, index + 1);
            use[nextRow][col] = false;
        }
        // 向下
        nextRow = row + 1;
        if (!find && nextRow < board.length && !use[nextRow][col] && board[nextRow][col] == word.charAt(index)) {
            use[nextRow][col] = true;
            exist(board, word, nextRow, col, index + 1);
            use[nextRow][col] = false;
        }
        // 向左
        int nextCol = col - 1;
        if (!find && nextCol >= 0 && !use[row][nextCol] && board[row][nextCol] == word.charAt(index)) {
            use[row][nextCol] = true;
            exist(board, word, row, nextCol, index + 1);
            use[row][nextCol] = false;
        }
        // 向右
        nextCol = col + 1;
        if (!find && nextCol < board[0].length && !use[row][nextCol] && board[row][nextCol] == word.charAt(index)) {
            use[row][nextCol] = true;
            exist(board, word, row, nextCol, index + 1);
            use[row][nextCol] = false;
        }
    }

}
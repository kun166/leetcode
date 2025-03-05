package com.test.leetcode.page1.chapter70.t79;

/**
 * @ClassName: Solution2025030501
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/5 08:47
 * @Version: 1.0
 */
public class Solution2025030501 {

    boolean find = false;

    /**
     * 这题虽然是个中等题，但是感觉更像困难题啊……
     * <p>
     * 146ms 击败59.25%
     * 40.70MB 击败80.90%
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length, l = word.length();
        if (m * n < l)
            return false;
        boolean[][] use = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (find)
                    return true;
                if (board[i][j] == word.charAt(0))
                    backtrack(board, word, use, 0, i, j);

            }
        }
        return find;
    }

    public void backtrack(char[][] board, String word, boolean[][] use, int index, int row, int column) {
        if (index == word.length()) {
            find = true;
            return;
        }

        if (!find && row >= 0
                && row < board.length
                && column >= 0
                && column < board[0].length
                && !use[row][column]
                && board[row][column] == word.charAt(index)) {
            use[row][column] = true;
            // 向左
            backtrack(board, word, use, index + 1, row, column - 1);
            // 向右
            backtrack(board, word, use, index + 1, row, column + 1);
            // 向上
            backtrack(board, word, use, index + 1, row - 1, column);
            // 向下
            backtrack(board, word, use, index + 1, row + 1, column);
            use[row][column] = false;
        }

    }
}

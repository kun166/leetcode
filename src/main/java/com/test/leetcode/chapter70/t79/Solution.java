package com.test.leetcode.chapter70.t79;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-13 10:26
 */
public class Solution {

    @Test
    public void test() {
        char[][] board = new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCB"));
    }

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return true;
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        int m = board.length, n = board[0].length;
        boolean[][] f = new boolean[m][n];
        // 先寻找第一个字符
        int[] searchResult = new int[]{0, -1};
        while (true) {
            searchResult = search(board, word.charAt(0), searchResult[0], searchResult[1] + 1, m, n);
            if (searchResult[0] == -1)
                return false;

            boolean result = exist(board, word, searchResult[0], searchResult[1], f, 1);
            if (result)
                return true;
        }

    }

    public int[] search(char[][] board, char c, int row, int column, int m, int n) {
        for (int i = row; i < m; i++) {
            for (int j = (i == row ? column : 0); j < n; j++) {
                if (board[i][j] == c)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    public boolean exist(char[][] board, String word, int row, int column, boolean[][] f, int index) {
        if (index == word.length())
            return true;
        f[row][column] = true;
        // 探测上下左右
        // 向上
        boolean result = false;
        if (row > 0 && board[row - 1][column] == word.charAt(index) && f[row - 1][column] == false)
            result = result || exist(board, word, row - 1, column, f, index + 1);
        // 向下
        if (row < board.length - 1 && board[row + 1][column] == word.charAt(index) && f[row + 1][column] == false)
            result = result || exist(board, word, row + 1, column, f, index + 1);
        // 向左
        if (column > 0 && board[row][column - 1] == word.charAt(index) && f[row][column - 1] == false)
            result = result || exist(board, word, row, column - 1, f, index + 1);
        // 向右
        if (column < board[0].length - 1 && board[row][column + 1] == word.charAt(index) && f[row][column + 1] == false)
            result = result || exist(board, word, row, column + 1, f, index + 1);
        f[row][column] = false;
        return result;
    }
}

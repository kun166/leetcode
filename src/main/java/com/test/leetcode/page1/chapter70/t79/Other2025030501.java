package com.test.leetcode.page1.chapter70.t79;

/**
 * @ClassName: Other2025030501
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/5 09:21
 * @Version: 1.0
 */
public class Other2025030501 {

    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    /**
     * 0ms 击败100.00%
     * 40.98MB 击败27.75%
     * <p>
     * 这个只能说有点邪恶，居然0ms
     * 大神真的是大神啊
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        // 为了方便，直接用数组代替哈希表
        /**
         * 这个需要学习下,
         * 'A'的int值65
         * 'z'的int值122
         */
        int[] cnt = new int[128];
        for (char[] row : board) {
            for (char c : row) {
                /**
                 * 记录board中所有字符出现次数
                 */
                cnt[c]++;
            }
        }

        // 优化一
        char[] w = word.toCharArray();
        int[] wordCnt = new int[128];
        for (char c : w) {
            if (++wordCnt[c] > cnt[c]) {
                /**
                 * 记录字符串word中所有字符的出现次数
                 */
                return false;
            }
        }

        // 优化二
        if (cnt[w[w.length - 1]] < cnt[w[0]]) {
            /**
             * 这个if判断的是
             * 二位数组board中,word的尾字符出现的次数比首字符少
             *
             * 执行之后,word的首字符出现次数比尾字符少
             */
            w = new StringBuilder(word).reverse().toString().toCharArray();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(i, j, 0, board, w)) {
                    return true; // 搜到了！
                }
            }
        }
        return false; // 没搜到
    }

    private boolean dfs(int i, int j, int k, char[][] board, char[] word) {
        if (board[i][j] != word[k]) { // 匹配失败
            return false;
        }
        if (k == word.length - 1) { // 匹配成功！
            return true;
        }
        /**
         * 通过board做是否访问过记录，不比再重新申请数组
         */
        board[i][j] = 0; // 标记访问过
        for (int[] d : DIRS) {
            int x = i + d[0];
            int y = j + d[1]; // 相邻格子
            if (0 <= x && x < board.length && 0 <= y && y < board[x].length && dfs(x, y, k + 1, board, word)) {
                return true; // 搜到了！
            }
        }
        board[i][j] = word[k]; // 恢复现场
        return false; // 没搜到
    }
}

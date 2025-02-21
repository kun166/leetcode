package com.test.leetcode.page5.chapter410.t419;

/**
 * @ClassName: Solution20230530
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/30 16:07
 * @Version: 1.0
 */
public class Solution20230530 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：42.8 MB, 在所有 Java 提交中击败了8.06%的用户
     * 通过测试用例：27 / 27
     *
     * @param board
     * @return
     */
    public int countBattleships(char[][] board) {
        // 只需要判断上部和左部是否是X即可
        int ans = 0, m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    // 判断上部和左部是否有X
                    if ((i == 0 || board[i - 1][j] != 'X') && (j == 0 || board[i][j - 1] != 'X')) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}

package com.test.leetcode.page2.chapter170.t174;

/**
 * @ClassName: Solution20230214
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/14 09:18
 * @Version: 1.0
 */
public class Solution20230214 {

    /**
     * 看官方题解之后，自己的思路
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        // m是行,n是列
        int m = dungeon.length, n = dungeon[0].length;
        // dp[i][j]标识点(i,j)到点(m-1,n-1)需要的最小生命值
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] > 0 ? 1 : 1 - dungeon[m - 1][n - 1];
        // 对于i=m-1的行，只能有(m-1,j+1)来求
        for (int i = n - 2; i >= 0; i--) {
            // 当前需要的生命值加上下一个点需要的生命值
            int need = dp[m - 1][i + 1] - dungeon[m - 1][i];
            // 如果是负值，说明dungeon[m - 1][i]值是一个比较大的正值。
            dp[m - 1][i] = need > 0 ? need : 1;
        }
        // 对于j=n-1的列，只能有(i+1,n-1)来求
        for (int i = m - 2; i >= 0; i--) {
            int need = dp[i + 1][n - 1] - dungeon[i][n - 1];
            dp[i][n - 1] = need > 0 ? need : 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                // 其它的 由(i,j+1)和(i+1,j)最小的那个来求
                int need = Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j];
                dp[i][j] = need > 0 ? need : 1;
            }
        }
        return dp[0][0];
    }
}

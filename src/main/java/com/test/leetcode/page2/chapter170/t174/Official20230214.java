package com.test.leetcode.page2.chapter170.t174;

import java.util.Arrays;

/**
 * @ClassName: Official20230214
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/14 09:04
 * @Version: 1.0
 */
public class Official20230214 {

    /**
     * 我们考虑从右下往左上进行动态规划。令dp[i][j] 表示从坐标(i,j) 到终点所需的最小初始值。
     * 换句话说，当我们到达坐标(i,j) 时，如果此时我们的路径和不小于dp[i][j]，我们就能到达终点。
     * <p>
     * 这样一来，我们就无需担心路径和的问题，只需要关注最小初始值。对于dp[i][j]，
     * 我们只要关心dp[i][j+1] 和 dp[i+1][j] 的最小值minn。
     * 记当前格子的值为dungeon(i,j)，那么在坐标 (i,j) 的初始值只要达到 minn−dungeon(i,j) 即可。
     * 同时，初始值还必须大于等于 1。这样我们就可以得到状态转移方程：
     * dp[i][j]=max(min(dp[i+1][j],dp[i][j+1])−dungeon(i,j),1)
     * 最终答案即为 dp[0][0]。
     * 边界条件为，当i=n−1 或者j=m−1 时，dp[i][j] 转移需要用到的dp[i][j+1] 和
     * dp[i+1][j] 中有无效值，因此代码实现中给无效值赋值为极大值。
     * 特别地，dp[n−1][m−1] 转移需要用到的dp[n−1][m] 和dp[n][m−1] 均为无效值，
     * 因此我们给这两个值赋值为1。
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n][m - 1] = dp[n - 1][m] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}

package com.test.leetcode.page5.chapter400.t403;

/**
 * @ClassName: OfficialSecond20230525
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/25 08:57
 * @Version: 1.0
 */
public class OfficialSecond20230525 {

    /**
     * 方法二：动态规划
     *
     * @param stones
     * @return
     */
    public boolean canCross(int[] stones) {
        int n = stones.length;
        // dp[i][k]表示当前处于下标为i的石头，上一次跳跃距离为k，能否跳到下一块石头
        boolean[][] dp = new boolean[n][n];
        // 跳到下标为0的石头上，用了0步。这样可以保证青蛙的第一次跳跃距离为1
        dp[0][0] = true;
        // 这个算是快速失败
        for (int i = 1; i < n; ++i) {
            //  当青蛙位于第0个石子上时，青蛙的上一次跳跃距离限定为0，之后每次跳跃，青蛙所在的石子编号至少增加1，而每次跳跃距离至多增加1。
            //  跳跃m次后，青蛙「现在所处的石子编号」i≥m，「上一次跳跃距离」k≤m，因此 k≤i。
            //  当前下标为i,则跳到当前坐标i的时候，跳跃步数肯定小于i-1,跳到下一个石子的距离不超过i
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                // 这个也是一个快速失败，原理同上
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }
}

package com.test.leetcode.page5.chapter480.t486;

/**
 * @ClassName: OfficialSecond20230703
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/3 16:56
 * @Version: 1.0
 */
public class OfficialSecond20230703 {

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        // 定义二维数组dp，其行数和列数都等于数组的长度，dp[i][j] 表示当数组剩下的部分为下标 i 到下标 j 时，
        // 即在下标范围 [i,j] 中，当前玩家与另一个玩家的分数之差的最大值，注意当前玩家不一定是先手。
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            // 只有一个数的时候，只有一个选择
            dp[i][i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] >= 0;
    }
}

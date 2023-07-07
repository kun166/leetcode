package com.test.leetcode.page5.chapter410.t416;

import org.junit.Test;

/**
 * @ClassName: SolutionThird20230706
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/6 15:56
 * @Version: 1.0
 */
public class SolutionFourth20230706 {

    @Test
    public void test() {
        System.out.println(canPartition(new int[]{1, 2, 5}));
    }

    /**
     * 执行用时：32 ms, 在所有 Java 提交中击败了43.09%的用户
     * 内存消耗：39.8 MB, 在所有 Java 提交中击败了94.24%的用户
     * 通过测试用例：141 / 141
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;
        //dp[j] 是否存在和为j的组合
        boolean[] dp = new boolean[half + 1];
        for (int i = 1; i <= n; i++) {
            // 这个地方最好是从half到1,不过当前题不影响
            for (int j = half; j >= 1; j--) {
                if (j == nums[i - 1]) {
                    dp[j] = true;
                } else if (j - nums[i - 1] > 0) {
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                }
            }
        }
        return dp[half];
    }
}

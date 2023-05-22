package com.test.leetcode.page4.chapter320.t325;

/**
 * @ClassName: Solution20230424
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/24 08:51
 * @Version: 1.0
 */
public class SolutionFirst20230424 {

    /**
     * 超出时间限制
     *
     * @param nums
     * @param k
     * @return
     */
    public int maxSubArrayLen(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int number = k;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == number) {
                    ans = Math.max(ans, j - i + 1);
                }
                number -= nums[j];
            }
        }
        return ans;
    }
}

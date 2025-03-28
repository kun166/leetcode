package com.test.leetcode.page3.chapter200.t209;

/**
 * @ClassName: Solution2025032801
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/28 09:15
 * @Version: 1.0
 */
public class Solution2025032801 {

    /**
     * 呃,看了2023年的解法,这题不需要sum啊……
     * <p>
     * 1ms	击败99.79%
     * 56.87MB	击败45.46%
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, sum = 0, left = -1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= target) {
                while (left < i && sum >= target) {
                    /**
                     * 这个地方用++left,绝妙……
                     */
                    sum -= nums[++left];
                }
                ans = Math.min(ans, i - left + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

package com.test.leetcode.page3.chapter200.t209;

/**
 * @ClassName: Solution20230223
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/23 08:04
 * @Version: 1.0
 */
public class Solution20230223 {

    public int minSubArrayLen(int target, int[] nums) {
        int count = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            target -= nums[right];
            if (target <= 0) {
                while (target + nums[left] <= 0) {
                    target += nums[left];
                    left++;
                }
                count = count == 0 ? right - left + 1 : count;
                count = Math.min(count, right - left + 1);
                if (count == 1) {
                    return 1;
                }
            }
            right++;
        }
        return count;
    }
}

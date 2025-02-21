package com.test.leetcode.page1.chapter10.t16;

import java.util.Arrays;

/**
 * @ClassName: Solution20250211
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/11 17:30
 * @Version: 1.0
 */
public class Solution20250211 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length, ans = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            int left = i + 1, right = length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                }
                ans = Math.abs(ans - target) > Math.abs(sum - target) ? sum : ans;
                if (sum < target)
                    left++;
                else
                    right--;
            }
        }
        return ans;
    }

}

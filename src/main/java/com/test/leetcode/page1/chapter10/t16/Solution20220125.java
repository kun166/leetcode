package com.test.leetcode.page1.chapter10.t16;

import java.util.Arrays;

/**
 * @ClassName: Solution20220125
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/1/25 15:59
 * @Version: 1.0
 */
public class Solution20220125 {

    public int threeSumClosest(int[] nums, int target) {
        int result = 100000;
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            int start = i + 1, end = length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end] - target;
                if (sum == 0) {
                    return target;
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
                //result = Math.min(result, Math.abs(sum + target));
                if (Math.abs(result - target) > Math.abs(sum)) {
                    result = sum + target;
                }
            }
        }
        return result;
    }
}

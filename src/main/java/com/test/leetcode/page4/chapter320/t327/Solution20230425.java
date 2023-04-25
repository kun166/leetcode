package com.test.leetcode.page4.chapter320.t327;

/**
 * @ClassName: Solution20230425
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/25 08:27
 * @Version: 1.0
 */
public class Solution20230425 {

    /**
     * 这题感觉是325的加强题啊
     * 超出时间限制……
     *
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        int ans = 0;
        long[] array = new long[nums.length];
        array[0] += nums[0];
        if (nums[0] >= lower && nums[0] <= upper) {
            ans++;
        }
        for (int i = 1; i < nums.length; i++) {
            array[i] = array[i - 1] + nums[i];
            if (array[i] >= lower && array[i] <= upper) {
                ans++;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                long number = array[j] - array[i - 1];
                if (number >= lower && number <= upper) {
                    ans++;
                }
            }
        }
        return ans;
    }
}

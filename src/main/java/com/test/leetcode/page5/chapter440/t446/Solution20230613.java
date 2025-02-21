package com.test.leetcode.page5.chapter440.t446;

import org.junit.Test;

/**
 * @ClassName: Solution20230613
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/13 07:39
 * @Version: 1.0
 */
public class Solution20230613 {

    private int ans = 0;

    @Test
    public void test() {
        System.out.println(numberOfArithmeticSlices(new int[]{0, 2000000000, -294967296}));
    }

    /**
     * 超出时间限制
     *
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                numberOfArithmeticSlices(nums, (long) nums[j] - nums[i], j, 2);
            }
        }
        return ans;
    }

    public void numberOfArithmeticSlices(int[] nums, long dif, int index, int count) {
        if (count >= 3) {
            ans++;
        }
        for (int i = index + 1; i < nums.length; i++) {
            if ((long) nums[i] - nums[index] == dif) {

                numberOfArithmeticSlices(nums, dif, i, count + 1);
            }
        }
    }
}

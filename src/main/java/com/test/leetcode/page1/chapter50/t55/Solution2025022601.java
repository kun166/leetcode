package com.test.leetcode.page1.chapter50.t55;

import org.junit.Test;

/**
 * @ClassName: Solution2025022601
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/26 11:19
 * @Version: 1.0
 */
public class Solution2025022601 {

    @Test
    public void test() {
        System.out.println(canJump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));
    }

    /**
     * 找最大的那个跳跃点，如果不为0,就能跳过
     * 唉，这次没写出来，不写了……
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length, maxStep = 0;
        for (int i = 0; i < n; ) {
            if (i + nums[i] >= n - 1) {
                return true;
            }
            if (nums[i] == 0) {
                return false;
            }
            for (int j = 1; j <= nums[i]; j++) {
                maxStep = Math.max(maxStep, i + j + nums[i + j]);
            }
            i = maxStep;
        }
        return true;
    }
}

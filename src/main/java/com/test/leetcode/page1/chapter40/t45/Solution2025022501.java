package com.test.leetcode.page1.chapter40.t45;

/**
 * @ClassName: Solution2025022501
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/25 09:10
 * @Version: 1.0
 */
public class Solution2025022501 {

    /**
     * 先来个贪心算法吧
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int ans = 0, step;
        for (int i = 0; i < nums.length - 1; ) {
            ans++;
            if (i + nums[i] >= nums.length - 1) {
                return ans;
            }
            step = 0;
            for (int j = 1; j <= nums[i]; j++) {
                if (j + nums[i + j] > step + nums[i + step]) {
                    step = j;
                }
            }
            i += step;
            if (i >= nums.length - 1) {
                return ans;
            }
        }
        return ans;
    }
}

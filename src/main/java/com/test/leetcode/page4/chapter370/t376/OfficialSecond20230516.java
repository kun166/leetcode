package com.test.leetcode.page4.chapter370.t376;

/**
 * @ClassName: OfficialSecond20230516
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/16 07:22
 * @Version: 1.0
 */
public class OfficialSecond20230516 {

    /**
     * 方法二：优化的动态规划
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1, down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = Math.max(up, down + 1);
            } else if (nums[i] < nums[i - 1]) {
                down = Math.max(up + 1, down);
            }
        }
        return Math.max(up, down);
    }

}

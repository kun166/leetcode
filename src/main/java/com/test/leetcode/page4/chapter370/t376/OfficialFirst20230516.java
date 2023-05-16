package com.test.leetcode.page4.chapter370.t376;

/**
 * @ClassName: OfficialFirst20230516
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/16 07:17
 * @Version: 1.0
 */
public class OfficialFirst20230516 {

    /**
     * 方法一：动态规划
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        // 上升摆动序列
        int[] up = new int[n];
        // 下降摆动序列
        int[] down = new int[n];
        up[0] = down[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }
}

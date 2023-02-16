package com.test.leetcode.page2.chapter180.t189;

/**
 * @ClassName: SolutionSecond20230215
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/15 15:20
 * @Version: 1.0
 */
public class SolutionSecond20230215 {

    /**
     * 使用额外数组
     * 呃，用时又少，占用内存又少？搞笑的吧
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) {
            return;
        }
        int[] ans = new int[n];
        System.arraycopy(nums, 0, ans, k, n - k);
        System.arraycopy(nums, n - k, ans, 0, k);
        System.arraycopy(ans, 0, nums, 0, n);
    }
}

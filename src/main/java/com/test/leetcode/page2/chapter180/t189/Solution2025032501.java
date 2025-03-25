package com.test.leetcode.page2.chapter180.t189;

/**
 * @ClassName: Solution2025032501
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/25 16:22
 * @Version: 1.0
 */
public class Solution2025032501 {

    /**
     * 感觉这最简单的方式都顶上困难题了……
     * 1ms	击败55.57%
     * 56.11MB	击败79.12%
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0)
            return;
        // 1,申请k个数组吧
        int[] array = new int[k];
        // 2,初始化array
        for (int i = 0; i < k; i++) {
            array[i] = nums[i];
        }
        /**
         * 数组长度为5,k为3
         * 嗯,这么写是可以的
         */
        // 3,循环遍历,替换
        int i = 0, j = 0;
        for (i = k; i < n; i = i + k) {
            for (j = 0; j < k && i + j < n; j++) {
                int index = (i + j) % n;
                int temp = nums[index];
                nums[index] = array[j];
                array[j] = temp;
            }
        }
        // 4,把剩余的array再替换到nums里
        for (int l = j; l < k; l++) {
            nums[(i + l - k) % n] = array[l];
        }
        for (int l = 0; l < j; l++) {
            nums[(i + l) % n] = array[l];
        }
    }
}

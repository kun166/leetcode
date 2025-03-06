package com.test.leetcode.page1.chapter80.t88;

/**
 * @ClassName: Solution2025030601
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/6 16:01
 * @Version: 1.0
 */
public class Solution2025030601 {

    /**
     * 呃，这题一开始感觉是个中等题,因为从前面向后排序，真的不像简单题
     * 但是但是……这题可以从后向前排啊……
     * 我真是小天才
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            return;
        int length = m + n - 1;
        m--;
        n--;
        while (n >= 0 && m >= 0) {
            nums1[length--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        /**
         * 呃，两个while确实可以合成一个
         */
        while (n >= 0) {
            nums1[length--] = nums2[n--];
        }
    }
}

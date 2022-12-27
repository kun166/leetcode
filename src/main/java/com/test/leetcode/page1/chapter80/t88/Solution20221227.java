package com.test.leetcode.page1.chapter80.t88;

/**
 * @ClassName: Solution20221227
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/27 09:13
 * @Version: 1.0
 */
public class Solution20221227 {

    /**
     * 感觉应该从后往前排
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 存放的位置
        int index = m + n - 1;
        while (n > 0) {
            if (m > 0 && nums1[m - 1] >= nums2[n - 1]) {
                nums1[index] = nums1[m - 1];
                m--;
                index--;
            } else {
                nums1[index] = nums2[n - 1];
                n--;
                index--;
            }
        }
    }
}

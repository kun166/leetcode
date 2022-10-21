package com.test.leetcode.page1.chapter0.t4;

import org.junit.Test;

/**
 * @ClassName: Solution20221020
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/20 19:12
 * @Version: 1.0
 */
public class Solution20221020 {

    @Test
    public void test() {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int tL = nums1.length + nums2.length;
        if ((tL & 1) == 0) {
            // 偶数
            return (findMedianSortedArrays(nums1, nums2, tL / 2 + 1) + findMedianSortedArrays(nums1, nums2, tL / 2)) / 2;
        }
        return findMedianSortedArrays(nums1, nums2, tL / 2 + 1);
    }

    /**
     * 这种算法，好理解，但是速度上肯定不如官方的快
     *
     * @param nums1
     * @param nums2
     * @param index
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2, int index) {
        int n1 = nums1.length, n2 = nums2.length, l1 = 0, l2 = 0;
        while (l1 < n1 && l2 < n2) {
            if (index == 1) {
                return Math.min(nums1[l1], nums2[l2]);
            }
            int step = Math.min(n1 - l1, n2 - l2);
            // 这个地方不论index是奇数还是偶数，都不影响
            step = Math.min(step, index / 2);
            //为什么下标是step - 1 + l1？因为这个下标到l1的下标长度是step。两个下标i1,i2的距离是他们的差值+1,因为它们都包含在内
            if (nums1[step - 1 + l1] > nums2[step - 1 + l2]) {
                // 舍弃nums2部分
                l2 += step;
            } else {
                l1 += step;
            }
            index -= step;
        }
        return l1 == n1 ? nums2[l2 + index - 1] : nums1[l1 + index - 1];
    }
}

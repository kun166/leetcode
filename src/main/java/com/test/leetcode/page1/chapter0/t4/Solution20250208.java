package com.test.leetcode.page1.chapter0.t4;

/**
 * @ClassName: Solution20250208
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/8 10:11
 * @Version: 1.0
 */
public class Solution20250208 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if ((length & 1) == 0) {
            // 偶数
            return (double) (findMedianSortedArrays(nums1, nums2, -1, -1, length / 2)
                    + findMedianSortedArrays(nums1, nums2, -1, -1, length / 2 + 1)) / 2d;
        } else {
            // 奇数
            return findMedianSortedArrays(nums1, nums2, -1, -1, length / 2 + 1);
        }
    }

    public int findMedianSortedArrays(int[] nums1, int[] nums2, int n1s, int n2s, int index) {
        if (n1s >= nums1.length - 1) {
            return nums2[n2s + index];
        }

        if (n2s >= nums2.length - 1) {
            return nums1[n1s + index];
        }
        if (index == 1) {
            // 处理边界问题
            return Math.min(nums1[n1s + 1], nums2[n2s + 1]);
        }
        // 取index折半
        int length = index / 2;
        length = Math.min(length, nums1.length - n1s);
        length = Math.min(length, nums2.length - n2s);

        if (nums1[n1s + length] > nums2[n2s + length]) {
            return findMedianSortedArrays(nums1, nums2, n1s, n2s + length, index - length);
        }
        return findMedianSortedArrays(nums1, nums2, n1s + length, n2s, index - length);
    }
}

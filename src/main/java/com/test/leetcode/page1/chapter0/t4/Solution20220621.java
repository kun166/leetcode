package com.test.leetcode.page1.chapter0.t4;

import org.junit.Test;

/**
 * @ClassName: Solution20220621
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/6/21 19:32
 * @Version: 1.0
 */
public class Solution20220621 {

    @Test
    public void test() {
        System.out.println(findNumber(new int[]{1, 2}, new int[]{3, 4}, 3, 0, 0));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sumL = nums1.length + nums2.length;
        if (sumL % 2 == 1) {
            // 说明是总长度是奇数，直接返回中位数即可
            return findNumber(nums1, nums2, sumL / 2 + 1, 0, 0);
        }
        // 求sumL/2和sumL/2+1两个数的平均数
        return (double) (findNumber(nums1, nums2, sumL / 2, 0, 0) + findNumber(nums1, nums2, sumL / 2 + 1, 0, 0)) / 2d;
    }

    /**
     * 查找数组1和数组2合并后的第length个下标的数字
     *
     * @param nums1   数组1
     * @param nums2   数组2
     * @param length  数组1和数组2合并后的数组中第几个数字
     * @param n1Index 数组1的开始位置
     * @param n2Index 数组2的开始位置
     * @return
     */
    public int findNumber(int[] nums1, int[] nums2, int length, int n1Index, int n2Index) {
        if (n1Index >= nums1.length) {
            // 说明nums1已经到头了，直接从nums2中查找即可
            return nums2[n2Index + length - 1];
        }
        if (n2Index >= nums2.length) {
            return nums1[n1Index + length - 1];
        }
        if (length == 1) {
            return nums1[n1Index] > nums2[n2Index] ? nums2[n2Index] : nums1[n1Index];
        }
//        if (length == 2) {
//            return nums1[n1Index] > nums2[n2Index] ? nums1[n1Index] : nums2[n2Index];
//        }
        int midLength = (length / 2 - 1) == 0 ? 1 : (length / 2 - 1);
        midLength = Math.min(midLength, nums1.length - n1Index);
        midLength = Math.min(midLength, nums2.length - n2Index);
        if (nums1[n1Index + midLength - 1] > nums2[n2Index + midLength - 1]) {
            return findNumber(nums1, nums2, length - midLength, n1Index, n2Index + midLength);
        }
        return findNumber(nums1, nums2, length - midLength, n1Index + midLength, n2Index);
    }
}

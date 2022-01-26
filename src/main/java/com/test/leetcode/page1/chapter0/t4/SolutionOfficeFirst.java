package com.test.leetcode.page1.chapter0.t4;

/**
 * @ClassName: SolutionOfficeFirst
 * @Description:
 * @Author: qinfajia
 * @Date: 2021/12/11 10:12
 * @Version: 1.0
 */
public class SolutionOfficeFirst {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if(totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median =
                    (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    /**
     * 寻找两个已排好序的数组的第K大的数
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */
        // nums1的长度
        int length1 = nums1.length;
        // nums2的长度
        int length2 = nums2.length;
        // nums1的起始位置
        int index1 = 0;
        // nums2的起始位置
        int index2 = 0;

        while(true) {
            // 边界情况。注意length1有可能为0。所以放前面了
            if(index1 == length1) {
                // 说明nums1已经结束了
                return nums2[index2 + k - 1];
            }
            if(index2 == length2) {
                // 说明nums2已经结束了。注意length1有可能为0，所以放前面了
                return nums1[index1 + k - 1];
            }
            if(k == 1) {
                // 特殊情况，k==1
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况,取k的一半
            int half = k / 2;
            // 在其实位置上加k/2，与lenght1比较，取小，注意这个-1很巧妙
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if(pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                // 这里又把1加回来了
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}

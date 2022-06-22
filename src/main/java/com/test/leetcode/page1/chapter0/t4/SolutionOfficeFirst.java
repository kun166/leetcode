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
        if (totalLength % 2 == 1) {
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
         *
         *
         *
         *
         * 上面是官网的解法说明，不太好理解，下面重新说明一下
         * 数组1和数组2均取k/2的位置，注意这个是从头开始数第k/2个数，不是下标。(因为数字其实位置是0，所以这个地方的下标是k/2-1)，计为
         * pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1]。
         * 则排在pivot1和pivot2之前的数组中的数字个数均为k/2-1个。
         * 假若pivot1小于pivot2(反之亦然)，则两个数组合并之后，pivot1的位置最多处在k-1的位置(这种情况就是pivot2的前一个位置的数值也小于等于pivot1，
         * 否则pivot1在合并后的数组中排位还要靠前)。所以就可以把pivot1及它所在的数组之前的数字全部排除掉。
         * 以此类推迭代，最终找到中位数。
         *
         */
        // nums1的长度
        int length1 = nums1.length;
        // nums2的长度
        int length2 = nums2.length;
        // nums1的起始位置
        int index1 = 0;
        // nums2的起始位置
        int index2 = 0;

        while (true) {
            // 边界情况。注意length1有可能为0。所以放前面了
            if (index1 == length1) {
                // 说明nums1已经结束了
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                // 说明nums2已经结束了。注意length1有可能为0，所以放前面了
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                // 特殊情况，k==1。这是为了避免下面的的half为0，死循环
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况,取k的一半
            int half = k / 2;
            /**
             * 下面的公式可以分解成几步
             * 1、数组下标与长度的隐形转换。下标+1=长度。以下标index1为起始位置数长度为half个数，则长度为多少？
             *    下标index1在数组的长度是index1+1，因为该下标所在的位置算half的第一个数，所以长度为index1+1-1+half,即index1+half
             * 2、index1+half，这个长度可能超过数组的长度，所以还要和数字的长度取小的那个,即Math.min(index1 + half, length1)
             * 3、长度转成下标，需要-1，则新的下标位置为Math.min(index1 + half, length1) - 1
             */
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                // 这里又涉及到距离的计算，从下标index1到下标newIndex1一共几个数？因为index1算一个数，newIndex1也算一个数，则长度为newIndex1-index1+1
                // 比如从下标4到下标5一共几个数？明显是5-4+1嘛。细节很重要
                // 这一步的意义就是排除掉了newIndex1 - index1 + 1个数之后，k也需要减去这么长的长度
                k -= (newIndex1 - index1 + 1);
                // 这里又是一个细节，因为index1的下标这个数，属于要排除的那些数中的一个，则在新的一轮迭代中，数组1的第一个数字应该是下标为newIndex1 + 1的那个数字
                index1 = newIndex1 + 1;
            } else {
                // 同理，不解释了
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}

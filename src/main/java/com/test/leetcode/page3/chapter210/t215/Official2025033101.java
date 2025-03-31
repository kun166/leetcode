package com.test.leetcode.page3.chapter210.t215;

/**
 * @ClassName: Official2025033101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/31 11:37
 * @Version: 1.0
 */
public class Official2025033101 {

    int quickselect(int[] nums, int l, int r, int k) {
        if (l == r)
            return nums[k];
        /**
         * 拿nums[l]作为基准,小于这个数的分在左边,大于这个数的分在右边
         */
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++;
                /**
                 * 跳出循环的时候nums[i] >= x
                 * 即找出第一个不小于nums[l]的数
                 */
            } while (nums[i] < x);
            do {
                j--;
                /**
                 * 跳出循环的时候,nums[j] <= x
                 * 即找出第一个不大于nums[l]的数
                 */
            } while (nums[j] > x);
            if (i < j) {
                /**
                 * 互换位置
                 */
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        /**
         * 跳出循环的时候,i==j
         */
        if (k <= j)
            return quickselect(nums, l, j, k);
        else
            return quickselect(nums, j + 1, r, k);
    }

    public int findKthLargest(int[] _nums, int k) {
        int n = _nums.length;
        /**
         * 注意,它这个是大数在后,小数在前
         */
        return quickselect(_nums, 0, n - 1, n - k);
    }

}

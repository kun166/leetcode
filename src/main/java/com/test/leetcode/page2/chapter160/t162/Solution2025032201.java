package com.test.leetcode.page2.chapter160.t162;

import org.junit.Test;

public class Solution2025032201 {

    @Test
    public void test() {
        System.out.println(findPeakElement(new int[]{1, 2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 8}));
    }


    /**
     * 双指针？递归？
     * 1,峰值是严格高于左右两边的,题目中给出每个数都不一样,因此不需要考虑波峰两个数相等的情况
     * 2,二分取mid下标,如果该数是峰值,返回
     * 3,该数处于升序中,感觉和左侧起始位置关系不大？和最右侧数有关？
     * 3.1,升序中,且比右侧起始数大,则一定有峰值……
     * 3.2,升序中,且比右侧起始数小？
     * 4,降序,和左侧起始数有关系？
     * 4.1,降序比左侧起始数大,肯定有峰值
     * <p>
     * <p>
     * 换一种思路？
     * 左侧起始点处于升序中,右侧起始点处于降序中,就一定有峰值
     * <p>
     * 0ms	击败100.00%
     * 41.54MB	击败55.09%
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1 || nums[0] > nums[1])
            return 0;
        if (nums[n - 1] > nums[n - 2])
            return n - 1;
        return findPeakElement(nums, 1, n - 2);
    }

    public int findPeakElement(int[] nums, int pl, int pr) {
        if (nums[pl] > nums[pl + 1] && nums[pl] > nums[pl - 1]) {
            return pl;
        }
        if (nums[pr] > nums[pr + 1] && nums[pr] > nums[pr - 1]) {
            return pr;
        }
        if (pl == pr) {
            return -1;
        }
        int mid = pl + ((pr - pl) >> 1);
        if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
            return mid;
        }
        if (nums[mid] < nums[mid + 1] && (nums[mid] > nums[pr] || nums[pr] < nums[pr - 1])) {
            return findPeakElement(nums, mid + 1, pr);
        }
        if (nums[mid] > nums[mid + 1] && (nums[mid] > nums[pl] || nums[pl] < nums[pl + 1])) {
            return findPeakElement(nums, pl, mid - 1);
        }
        int index = findPeakElement(nums, pl, mid);
        if (index != -1)
            return index;
        return findPeakElement(nums, mid + 1, pr);
    }
}

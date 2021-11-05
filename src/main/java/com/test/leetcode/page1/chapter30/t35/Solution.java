package com.test.leetcode.page1.chapter30.t35;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-27 17:55
 */
public class Solution {

    @Test
    public void test() {
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(nums, 0));
    }

    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length == 0 || nums[0] > target) {
            return 0;
        }
        if (nums[length - 1] < target) {
            return length;
        }
        // 2分查找法吧
        int start = 0, end = length - 1, m;
        while (start <= end) {
            if (nums[start] >= target)
                return start;
            m = start + (end - start) / 2;
            if (nums[m] == target) return m;
            else if (nums[m] < target) start = m + 1;
            else end = m;
        }
        return -1;
    }

}

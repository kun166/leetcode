package com.test.leetcode.page1.chapter30.t33;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-23 19:27
 */
public class Solution {


    @Test
    public void test() {
        int[] nums = {1, 1, 1, 1, 0, 1, 1, 1};
        System.out.println(search(nums, 0));
    }

    /**
     * 感觉只能二分法了
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int m;
        while (start <= end) {
            if (nums[start] == target)
                return start;
            if (nums[end] == target)
                return end;
            m = start + (end - start) / 2;
            if (nums[m] == target)
                return m;

            // 说明从start到m是正序，转折点不在这里面
            if (nums[m] > nums[start]) {
                if (nums[start] < target && nums[m] > target)
                    return search(nums, target, start, m);
                if (nums[m] < target) {
                    start = m + 1;
                    continue;
                }
            }

            // 说明从start到m是正序，转折点不在这里面
            if (nums[m] < nums[end]) {
                if (nums[m] < target && nums[end] > target)
                    return search(nums, target, m, end);
                if (nums[m] > target) {
                    end = m - 1;
                    continue;
                }
            }
            // 说明拐点在这里面
            if (nums[start] < target) end = m - 1;
            else start = m + 1;
        }
        return -1;
    }

    /**
     * 这个是已经排好序的二半查找法
     *
     * @param nums
     * @param target
     * @param start
     * @param end
     * @return
     */
    public int search(int[] nums, int target, int start, int end) {
        int m;
        while (start <= end) {
            m = start + (end - start) / 2;
            if (nums[m] == target) return m;
            if (nums[m] > target) end = m - 1;
            else start = m + 1;
        }
        return -1;
    }
}

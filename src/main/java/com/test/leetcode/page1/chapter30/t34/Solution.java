package com.test.leetcode.page1.chapter30.t34;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-24 18:54
 */
public class Solution {

    @Test
    public void test() {
        int[] nums = {5, 7, 7, 8, 8, 8, 10};
        System.out.println(findRight(nums, 8, 3, 6));
        //int[] result = searchRange(nums, 8);
        //System.out.println(result[0] + "," + result[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        if (length == 0 || nums[0] > target || nums[length - 1] < target) {
            return new int[]{-1, -1};
        }
        // 先找到这个target
        int start = 0, end = length - 1, index = -1;
        while (start <= end) {
            if (nums[start] == target) {
                index = start;
                break;
            }
            if (nums[end] == target) {
                index = end;
                break;
            }
            int m = start + (end - start) / 2;
            if (nums[m] == target) {
                index = m;
                break;
            } else if (nums[m] > target) end = m - 1;
            else start = m + 1;
        }
        if (index != -1) {
            // 说明找到了。找左边值
            return new int[]{findLeft(nums, target, start, index), findRight(nums, target, index, end)};
        }
        return new int[]{-1, -1};
    }

    /**
     * 找左边
     *
     * @param nums
     * @param target
     * @param start
     * @param end
     * @return
     */
    public int findLeft(int[] nums, int target, int start, int end) {
        while (start <= end) {
            if (nums[start] == target)
                return start;
            int m = start + (end - start) / 2;
            if (nums[m] == target) end = m;
            else if (nums[m] < target) start = m + 1;
        }
        return -1;
    }

    public int findRight(int[] nums, int target, int start, int end) {
        while (start <= end) {
            if (nums[end] == target)
                return end;
            int m = end - (end - start) / 2;
            if (nums[m] == target) {
                start = m;
            } else if (nums[m] > target) end = m - 1;
        }
        return -1;
    }


}

package com.test.leetcode.page1.chapter80.t81;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-13 16:18
 */
public class Solution {

    @Test
    public void test() {
        int[] nums = new int[]{3, 1};
        System.out.println(search(nums, 1));
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int length = nums.length;
        if (target > nums[length - 1] && target < nums[0])
            return false;

        int start = 0, end = length - 1;
        //第一次的时候，可能start和end一样，如果是这样，就先去重。
        if (nums[start] == nums[end]) {
            if (nums[start] == target)
                return true;
            // 去重
            int num = nums[start];
            while (++start < end && nums[start] == num) ;
            while (--end > start && nums[end] == num) ;
        }
        while (start <= end) {
            if (target > nums[end] && target < nums[start])
                return false;
            //二分法
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return true;
//            if (nums[mid] > target) {
//                // 中位数大于目标值
//                if (nums[mid] >= nums[start]) {
//                    // 前半部分是顺序的
//                    if (nums[start] <= target)
//                        return sortSearch(nums, target, start, mid);
//                    start = mid + 1;
//                } else {
//                    // 前半部分不是顺序的
//                    end = mid - 1;
//                }
//            } else {
//                // 中位数小于目标值
//                if (nums[mid] <= nums[end]) {
//                    if (nums[end] >= target)
//                        return sortSearch(nums, target, mid, end);
//                    end = mid - 1;
//                } else {
//                    start = mid + 1;
//                }
//            }
            if (nums[mid] >= nums[start]) {
                //前半部分有序
                if (nums[mid] > target && nums[start] <= target)
                    // 在全半部分
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                // 后半部分有序
                if (nums[mid] < target && nums[end] >= target)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return false;
    }

    public boolean sortSearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }
}

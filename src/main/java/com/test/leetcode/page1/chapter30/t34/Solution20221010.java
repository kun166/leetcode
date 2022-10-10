package com.test.leetcode.page1.chapter30.t34;

import org.junit.Test;

/**
 * @ClassName: Solution20221010
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/10 10:40
 * @Version: 1.0
 */
public class Solution20221010 {

    @Test
    public void test() {
        System.out.println(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = searchLeft(nums, target, 0, nums.length - 1);
        if (left == -1) {
            return new int[]{-1, -1};
        }
        int right = searchRight(nums, target, left, nums.length - 1);
        return new int[]{left, right};
    }

    public int searchLeft(int[] nums, int target, int start, int end) {
        while (start <= end) {
            if (nums[start] == target) {
                // 找到了最左边的
                return start;
            }
            if (start == end) {
                return -1;
            }
            // 二分
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                // 设置end值为mid，继续往左找。
                // 这个地方需要注意mid除非等于start，否则一定小于mid,不会陷入死循环
                end = mid;
            } else {
                // 如果左边的值小于target，就把mid+1赋值给start
                start = mid + 1;
            }
        }
        return -1;
    }

    public int searchRight(int[] nums, int target, int start, int end) {
        while (start <= end) {
            if (nums[end] == target) {
                // 说明找到了最右侧的target
                return end;
            }
            if (start == end) {
                return -1;
            }
            // 二分
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (start == mid) {
                    end--;
                } else {
                    start = mid;
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return -1;
    }
}

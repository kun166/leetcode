package com.test.leetcode.page1.chapter30.t34;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: Solution20220222
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/2/22 17:26
 * @Version: 1.0
 */
public class Solution20220222 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = searchLeft(nums, target, 0, nums.length - 1);
        if (left == -1) {
            return new int[]{-1, -1};
        }
        int right = searchRight(nums, target, 0, nums.length - 1);
        return new int[]{left, right};
    }

    public int searchLeft(int[] nums, int target, int start, int end) {
        if (start == end) {
            if (nums[start] == target) {
                return start;
            }
            return -1;
        }
        // 二分法
        int mid = start + (end - start) / 2;
        if (nums[mid] >= target) {
            return searchLeft(nums, target, start, mid);
        } else {
            return searchLeft(nums, target, mid + 1, end);
        }
    }

    public int searchRight(int[] nums, int target, int start, int end) {
        if (start == end) {
            if (nums[start] == target) {
                return start;
            }
            return -1;
        }
        // 二分法
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            if (mid < end && nums[mid + 1] == target) {
                return searchRight(nums, target, mid + 1, end);
            }
            return mid;
        }
        if (nums[mid] < target) {
            return searchRight(nums, target, mid + 1, end);
        } else {
            return searchRight(nums, target, start, mid);
        }
    }
}

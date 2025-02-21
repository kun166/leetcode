package com.test.leetcode.page1.chapter30.t31;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: Solution20250220
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/20 15:32
 * @Version: 1.0
 */
public class Solution20250220 {

    @Test
    public void test() {
        int[] nums = {2, 3, 1};
        nextPermutation(nums);
        System.out.println(JSON.toJSONString(nums));
    }

    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        // 先找到顺序的那个数的下标
        // 从后向前找
        int index = nums.length - 1;
        for (; index > 0; index--) {
            if (nums[index - 1] < nums[index]) {
                break;
            }
        }
        if (index != 0) {
            // 交换位置,从后向前找,找到比index-1大的那个数
            int last = nums.length - 1;
            for (; last > 0; last--) {
                if (nums[last] > nums[index - 1]) {
                    break;
                }
            }
            int mid = nums[last];
            nums[last] = nums[index - 1];
            nums[index - 1] = mid;
        }
        revers(nums, index);
    }

    /**
     * 从index开始倒转
     *
     * @param nums
     * @param index
     */
    public void revers(int[] nums, int index) {
        int right = nums.length - 1;
        while (index < right) {
            int mid = nums[index];
            nums[index] = nums[right];
            nums[right] = mid;
            index++;
            right--;
        }
    }
}

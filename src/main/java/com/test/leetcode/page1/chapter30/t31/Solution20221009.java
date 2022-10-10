package com.test.leetcode.page1.chapter30.t31;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: Solution20221009
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/9 16:01
 * @Version: 1.0
 */
public class Solution20221009 {

    @Test
    public void test() {
        int[] nums = new int[]{1, 3, 2};
        nextPermutation(nums);
        System.out.println(JSON.toJSONString(nums));
    }

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return;
        }
        // 找到前面数字小于后面数字的那个位置
        int index = findIndexAndSwap(nums);
        // 后面排序
        Arrays.sort(nums, index + 1, length);
    }

    /**
     * 查找错位的数字，并交换
     *
     * @param nums
     * @return
     */
    public int findIndexAndSwap(int[] nums) {
        // 找到前面数字小于后面数字的那个位置
        int index = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    index = j;
                    // 交换位置
                    int swap = nums[i];
                    nums[i] = nums[j];
                    nums[j] = swap;
                    return index;
                }
            }
        }
        return index;
    }
}

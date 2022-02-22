package com.test.leetcode.page1.chapter30.t31;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: Solution20220222
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/2/22 11:36
 * @Version: 1.0
 */
public class Solution20220222 {

    @Test
    public void test() {
        int[] array = new int[]{3, 2, 1};
        nextPermutation(array);
        System.out.println(JSON.toJSONString(array));
    }

    public void nextPermutation(int[] nums) {
        // 先找到那个逆序的点。
        int index;
        for (index = nums.length - 1; index > 0; index--) {
            if (nums[index] > nums[index - 1]) {
                break;
            }
        }
        // 交换位置
        if (index != 0) {
            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[index - 1] < nums[i]) {
                    // 交换位置
                    int mid = nums[index - 1];
                    nums[index - 1] = nums[i];
                    nums[i] = mid;
                    break;
                }
            }
        }
        // 排序
        int start = index, end = nums.length - 1;
        while (start < end) {
            // 交换位置
            int mid = nums[start];
            nums[start] = nums[end];
            nums[end] = mid;
            start++;
            end--;
        }
    }
}

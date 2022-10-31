package com.test.leetcode.page1.chapter30.t31;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: Solution20221028
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/28 15:10
 * @Version: 1.0
 */
public class Solution20221028 {

    @Test
    public void test() {
        int[] array = new int[]{2, 3, 1};
        nextPermutation(array);
        System.out.println(JSON.toJSONString(array));
    }

    public void nextPermutation(int[] nums) {
        // 先找到顺序的那个节点
        int index = nums.length - 2;
        while (index >= 0) {
            if (nums[index] < nums[index + 1]) {
                break;
            }
            index--;
        }
        // 找到比这个节点大的
        if (index > -1) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[index]) {
                    // 交换位置
                    swap(nums, i, index);
                    break;
                }
            }
        }
        // index之后的节点交换位置
        int start = index + 1, end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int p1, int p2) {
        int mid = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = mid;
    }
}

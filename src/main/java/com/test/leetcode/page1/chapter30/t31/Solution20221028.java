package com.test.leetcode.page1.chapter30.t31;

/**
 * @ClassName: Solution20221028
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/28 15:10
 * @Version: 1.0
 */
public class Solution20221028 {

    public void nextPermutation(int[] nums) {
        // 先找到顺序的那个节点
        int index = nums.length - 2;
        while (index >= 0) {
            if (nums[index] < nums[index + 1]) {
                break;
            }
        }
    }
}

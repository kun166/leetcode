package com.test.leetcode.page1.chapter20.t27;

/**
 * @ClassName: Solution20220216
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/2/16 10:04
 * @Version: 1.0
 */
public class Solution20220216 {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int lenggth = nums.length;
        int index = 0;
        for (int i = 0; i < lenggth; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}

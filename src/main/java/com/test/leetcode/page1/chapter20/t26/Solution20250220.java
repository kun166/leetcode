package com.test.leetcode.page1.chapter20.t26;

/**
 * @ClassName: Solution20250220
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/20 11:18
 * @Version: 1.0
 */
public class Solution20250220 {

    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}

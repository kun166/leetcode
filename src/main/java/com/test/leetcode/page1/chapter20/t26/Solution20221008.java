package com.test.leetcode.page1.chapter20.t26;

/**
 * @ClassName: Solution20221008
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/8 17:16
 * @Version: 1.0
 */
public class Solution20221008 {
    public int removeDuplicates(int[] nums) {
        // 明显双指针吧？
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[index]) {
                // 这个判断条件决定index必须以0开始
                continue;
            }
            nums[++index] = nums[i];
        }
        return index + 1;
    }
}

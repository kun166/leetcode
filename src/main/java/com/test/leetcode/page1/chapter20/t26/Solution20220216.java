package com.test.leetcode.page1.chapter20.t26;

/**
 * @ClassName: Solution20220216
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/2/16 09:52
 * @Version: 1.0
 */
public class Solution20220216 {

    public int removeDuplicates(int[] nums) {
        if (nums == null && nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int index = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] != nums[index - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}

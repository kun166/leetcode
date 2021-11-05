package com.test.leetcode.page1.chapter80.t80;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-13 15:42
 */
public class Solution {

    @Test
    public void test() {
        int[] nums = new int[]{1,1,1,2,2,3};
        int length = removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length < 3)
            return length;
        int pr = 2;
        for (int i = 2; i < length; i++) {
            if (nums[i] != nums[pr - 2]) {
                //将i移动到pr位置
                nums[pr] = nums[i];
                pr++;
            }
        }
        return pr;
    }
}

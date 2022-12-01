package com.test.leetcode.page1.chapter80.t80;

/**
 * @ClassName: Official20221201
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/1 09:16
 * @Version: 1.0
 */
public class Official20221201 {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}

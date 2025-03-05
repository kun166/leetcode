package com.test.leetcode.page1.chapter80.t80;

/**
 * @ClassName: Solution20250305
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/5 09:43
 * @Version: 1.0
 */
public class Solution2025030501 {

    /**
     * 这题感觉明显可以利用数组来嘛
     * <p>
     * 快慢指针
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return length;
        }
        int left = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[left] && nums[i] == nums[left - 1])
                //呃,官方解答更牛逼,直接判断nums[i] == nums[left - 1]
                continue;
            nums[++left] = nums[i];
        }
        return left + 1;
    }
}

package com.test.leetcode.page2.chapter160.t169;

/**
 * @ClassName: Solution20230209
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/9 16:51
 * @Version: 1.0
 */
public class Solution20230209 {

    /**
     * 学着投票法，咱也学一个吧
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 1, number = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                number = nums[i];
            }
            count += number == nums[i] ? 1 : -1;
        }
        return number;
    }
}

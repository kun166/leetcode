package com.test.leetcode.page4.chapter300.t300;

/**
 * @ClassName: SolutionFirst20230404
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/4 16:17
 * @Version: 1.0
 */
public class SolutionFirst20230404 {

    public int lengthOfLIS(int[] nums) {
        int max = 0, index, count;
        for (int i = 0; i < nums.length; i++) {
            index = i;
            count = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[index]) {
                    index = j;
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}

package com.test.leetcode.page2.chapter150.t154;

/**
 * @ClassName: Solution20230208
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/8 09:19
 * @Version: 1.0
 */
public class SolutionFirst20230208 {

    /**
     * 把这个困难题，做成简单题，来个搞笑的
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        return min;
    }
}

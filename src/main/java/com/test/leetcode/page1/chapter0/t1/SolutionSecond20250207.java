package com.test.leetcode.page1.chapter0.t1;

/**
 * @ClassName: Solution20250207
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/7 14:28
 * @Version: 1.0
 */
public class SolutionSecond20250207 {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}

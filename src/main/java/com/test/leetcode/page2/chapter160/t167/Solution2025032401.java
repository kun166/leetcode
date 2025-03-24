package com.test.leetcode.page2.chapter160.t167;

/**
 * @ClassName: Solution2025032401
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/24 10:23
 * @Version: 1.0
 */
public class Solution2025032401 {

    /**
     * 双指针?
     * 1ms	击败99.30%
     * 46.39MB	击败37.29%
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target)
                return new int[]{left + 1, right + 1};
            if (sum > target)
                right--;
            else
                left++;
        }
        return null;
    }
}

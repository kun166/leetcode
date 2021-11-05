package com.test.leetcode.page2.chapter160.t167;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-08-06 16:29
 */
public class SolutionOfficeSecond {

    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }
}

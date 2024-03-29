package com.test.leetcode.page2.chapter160.t167;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-08-06 16:24
 */
public class SolutionOfficeFirst {

    /**
     * 呃，这个算是二分查找么？
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }
}

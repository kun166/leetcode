package com.test.leetcode.page2.chapter160.t167;

/**
 * @ClassName: Solution20230209
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/9 09:16
 * @Version: 1.0
 */
public class SolutionFirst20230209 {

    /**
     * 两层for循环
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] > target) {
                    break;
                }
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }
}

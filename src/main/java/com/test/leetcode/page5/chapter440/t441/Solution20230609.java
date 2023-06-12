package com.test.leetcode.page5.chapter440.t441;

/**
 * @ClassName: Solution20230609
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/9 14:51
 * @Version: 1.0
 */
public class Solution20230609 {


    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.93%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了97.05%的用户
     * 通过测试用例：1335 / 1335
     *
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        if (n == 1) {
            return 1;
        }
        long left = 1, right = n;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // sum是1到mid的累加和
            long sum = mid * (mid + 1) / 2;
            if (sum == n) {
                return (int) mid;
            } else if (sum > n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left - 1;
    }
}

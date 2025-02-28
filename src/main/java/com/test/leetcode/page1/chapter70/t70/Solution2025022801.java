package com.test.leetcode.page1.chapter70.t70;

/**
 * @ClassName: Solution20250228
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/28 14:24
 * @Version: 1.0
 */
public class Solution2025022801 {

    /**
     * 递归的话，应该是比较慢的
     * <p>
     * 好吧，超出时间限制了……
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

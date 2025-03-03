package com.test.leetcode.page1.chapter70.t70;

/**
 * @ClassName: Solution2025022802
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/28 14:27
 * @Version: 1.0
 */
public class Solution2025022802 {


    /**
     * 迭代吧
     * dp
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
        int fn_2 = 1, fn_1 = 2;
        while (--n >= 2) {
            int temp = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = temp;
        }
        return fn_1;
    }
}

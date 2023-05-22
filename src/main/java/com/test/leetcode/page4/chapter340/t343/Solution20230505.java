package com.test.leetcode.page4.chapter340.t343;

import org.junit.Test;

/**
 * @ClassName: Solution20230505
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/5 15:23
 * @Version: 1.0
 */
public class Solution20230505 {

    int ans = 0;

    @Test
    public void test() {
        System.out.println(integerBreak(3));
    }

    /**
     * 执行用时：23 ms, 在所有 Java 提交中击败了2.33%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了39.69%的用户
     * 通过测试用例：50 / 50
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        integerBreak(n, 1, 1);
        return ans;
    }

    public void integerBreak(int n, int mul, int number) {
        if (n <= number) {
            ans = Math.max(ans, mul * n);
            return;
        }
        for (int i = number; i < n; i++) {
            integerBreak(n - i, mul * i, i);
        }
    }
}

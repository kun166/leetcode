package com.test.leetcode.page1.chapter0.t7;

import org.junit.Test;

/**
 * @ClassName: Solution20250210
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/10 16:08
 * @Version: 1.0
 */
public class Solution20250210 {

    @Test
    public void test() {
        System.out.println(-7 % 2);
    }

    public int reverse(int x) {
        boolean plus = x >= 0;
        int ans = 0;
        while (x != 0) {
            ans = ans * 10 + x % 10;
            x = x / 10;
            if (plus && x > 0 && x < 10) {
                // 最后一位
                if (ans > Integer.MAX_VALUE / 10) {
                    return 0;
                } else if (ans == Integer.MAX_VALUE / 10 && x > Integer.MAX_VALUE % 10) {
                    return 0;
                }
            } else if (!plus && x < 0 && x > -10) {
                // 最后一位
                if (ans < Integer.MIN_VALUE / 10) {
                    return 0;
                } else if (ans == Integer.MIN_VALUE / 10 && x < Integer.MIN_VALUE % 10) {
                    return 0;
                }
            }
        }
        return ans;
    }
}

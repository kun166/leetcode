package com.test.leetcode.page3.chapter260.t263;

import org.junit.Test;

/**
 * @ClassName: Solution20230313
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/13 09:04
 * @Version: 1.0
 */
public class Solution20230313 {

    @Test
    public void test() {
        System.out.println(isUgly(14));
    }

    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        // 只包含2，3，5
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        if (n == 1) {
            return true;
        }
        return false;
    }
}

package com.test.leetcode.page1.chapter60.t69;

import org.junit.Test;

/**
 * @ClassName: Solution2025022801
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/28 11:18
 * @Version: 1.0
 */
public class Solution2025022801 {

    @Test
    public void test() {
        //System.out.println(mySqrt(6));

        int left = 1, right = 3;
        System.out.println(left + ((right - left) >> 1));
    }

    /**
     * 这题想试试折半法……
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        // 0和1特殊情况
        if (x < 2) {
            return x;
        }
        int left = 0, right = x;
        while (left < right) {
            /**
             * 呃，唉唉唉，这>>的运算优先级太低了吧
             * int mid = left + (right - left) >> 1;
             */
            int mid = left + ((right - left) >> 1);
            if (left == mid)
                return left;
            /**
             * 注意这个地方不要使用mid*mid……
             */
            int number = x / mid;
            if (mid == number)
                return mid;
            else if (number < mid)
                // 说明 mid*mid>x
                right = mid;
            else
                left = mid;
        }
        return left;
    }
}

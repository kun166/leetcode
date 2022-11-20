package com.test.leetcode.page1.chapter60.t69;

/**
 * @ClassName: Solution20221120
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/20 9:17
 * @Version: 1.0
 */
public class Solution20221120 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        // 最快的速度，肯定就是折半查找法
        long left = 0, right = x;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long number = mid * mid;
            if (number > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        long number = left * left;
        if (number <= x) {
            return (int) left;
        } else {
            return (int) left - 1;
        }
    }
}

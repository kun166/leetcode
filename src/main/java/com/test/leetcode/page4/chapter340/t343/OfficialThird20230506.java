package com.test.leetcode.page4.chapter340.t343;

/**
 * @ClassName: OfficialThird20230506
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/6 08:43
 * @Version: 1.0
 */
public class OfficialThird20230506 {

    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            return (int) Math.pow(3, quotient - 1) * 4;
        } else {
            return (int) Math.pow(3, quotient) * 2;
        }
    }
}

package com.test.leetcode.page4.chapter320.t326;

/**
 * @ClassName: Solution20230424
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/24 09:50
 * @Version: 1.0
 */
public class Solution20230424 {

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        while (n > 3) {
            if (n % 3 == 0) {
                n = n / 3;
            } else {
                return false;
            }
        }
        return n == 3;
    }
}

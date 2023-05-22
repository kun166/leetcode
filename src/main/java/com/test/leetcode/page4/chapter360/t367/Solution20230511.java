package com.test.leetcode.page4.chapter360.t367;

import org.junit.Test;

/**
 * @ClassName: Solution20230511
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/11 17:39
 * @Version: 1.0
 */
public class Solution20230511 {

    @Test
    public void test() {
        System.out.println(isPerfectSquare(14));
    }

    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int left = 1, right = num;
        while (left < right) {
            int mid = left + (right - left) / 2;
            long number = ((long) mid) * ((long) mid);
            if (number == num) {
                return true;
            } else if (number > num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}

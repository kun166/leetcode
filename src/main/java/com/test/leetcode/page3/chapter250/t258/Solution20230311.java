package com.test.leetcode.page3.chapter250.t258;

import org.junit.Test;

/**
 * @ClassName: Solution20230311
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/11 8:27
 * @Version: 1.0
 */
public class Solution20230311 {

    @Test
    public void test() {
        System.out.println(addDigits(38));
    }

    public int addDigits(int num) {
        while (num > 9) {
            int number = 0;
            while (num > 0) {
                number += num % 10;
                num /= 10;
            }
            num = number;
        }
        return num;
    }
}

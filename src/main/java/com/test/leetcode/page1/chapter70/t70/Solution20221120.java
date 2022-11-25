package com.test.leetcode.page1.chapter70.t70;

import org.junit.Test;

/**
 * @ClassName: Solution20221120
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/20 16:10
 * @Version: 1.0
 */
public class Solution20221120 {

    @Test
    public void test(){
        System.out.println(climbStairs(4));
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int stepOne = 1;
        int stepSecond = 2;
        while (n > 2) {
            int sum = stepOne + stepSecond;
            stepOne = stepSecond;
            stepSecond = sum;
            n--;
        }
        return stepSecond;
    }
}

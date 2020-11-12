package com.test.leetcode.chapter70.t70;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-10 10:22
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
    }

    public int climbStairs(int n) {
        int[] array = new int[n];
        for (int i = 1; i <= n; i++) {
            if (i == 1)
                array[i - 1] = 1;
            else if (i == 2)
                array[i - 1] = 2;
            else
                array[i - 1] = array[i - 2] + array[i - 3];
        }
        return array[n - 1];
    }
}

package com.test.leetcode.chapter0.t7;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-11 16:01
 */
public class NumberTurn {

    @Test
    public void test() {
        System.out.println(turn(123));
    }


    public int turn(int num) {
        int result = 0;
        while (num != 0) {
            // 尾数
            int pop = num % 10;
            result = result * 10 + pop;
            num /= 10;
        }
        return result;
    }
}

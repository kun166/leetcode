package com.test.leetcode.page1.chapter30.t38;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-27 20:14
 */
public class Solution {

    @Test
    public void test() {
        System.out.println("1:" + countAndSay(1));
        System.out.println("2:" + countAndSay(2));
        System.out.println("3:" + countAndSay(3));
        System.out.println("4:" + countAndSay(4));
    }

    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int length = s.length();
            for (int j = 0; j < length; j++) {

            }
        }
        return s;
    }
}

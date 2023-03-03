package com.test.leetcode.page3.chapter220.t227;

import org.junit.Test;

/**
 * @ClassName: Solution20230301
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/1 10:50
 * @Version: 1.0
 */
public class Solution20230301 {

    @Test
    public void test() {
        System.out.println(calculate("3+2*2"));
    }

    public int calculate(String s) {
        int start = 0;
        long ans = 0, current = 0;
        int pre = 1;
        Character cur = null;
        boolean hasValue = false;
        while (start < s.length()) {
            char c = s.charAt(start);
            if (c == ' ') {
                start++;
            } else if (c == '+' || c == '-') {
                if (hasValue) {
                    ans += current * pre;
                    hasValue = false;
                }
                pre = c == '+' ? 1 : -1;
                start++;
            } else if (c == '*' || c == '/') {
                cur = c;
                start++;
            } else {
                int number = 0;
                while (start < s.length() && Character.isDigit(s.charAt(start))) {
                    number = number * 10 + s.charAt(start) - '0';
                    start++;
                }
                if (!hasValue) {
                    current = number;
                    hasValue = true;
                } else {
                    if (cur == '*') {
                        current *= number;
                    } else {
                        current /= number;
                    }
                }
            }
        }
        ans += current * pre;
        return (int) ans;
    }
}

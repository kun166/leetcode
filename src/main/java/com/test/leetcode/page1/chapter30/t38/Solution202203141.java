package com.test.leetcode.page1.chapter30.t38;

import org.junit.Test;

/**
 * @ClassName: Solution20220314
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/3/14 19:58
 * @Version: 1.0
 */
public class Solution202203141 {

    @Test
    public void test() {
        System.out.println(countAndSay(5));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        return countAndSay("11", 2, n);
    }

    public String countAndSay(String s, int index, int n) {
        if (index == n) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                builder.append((char) (count + '0')).append(s.charAt(i - 1));
                count = 1;
            }
        }
        builder.append((char) (count + '0')).append(s.charAt(s.length() - 1));
        return countAndSay(builder.toString(), index + 1, n);
    }
}

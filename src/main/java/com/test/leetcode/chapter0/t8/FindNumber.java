package com.test.leetcode.chapter0.t8;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-11 16:55
 */
public class FindNumber {

    @Test
    public void test() {
        System.out.println(find("42"));
        System.out.println(find("   -42"));
        System.out.println(find("4193 with words"));
        System.out.println(find("words and 987"));
    }

    public int find(String s) {
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            if (c == '-' && sb.length() == 0) {
                sb.append(c);
            }
            if (c >= '0' && c <= '9') {
                sb.append(c);
            }
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                break;
            }
        }
        String number = sb.toString();
        if (number.equals("") || number.equals("-")) {
            return 0;
        }

        return Integer.parseInt(number);
    }
}

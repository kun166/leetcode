package com.test.leetcode.page1.chapter10.t12;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-14 14:49
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(convertNumber(3));
        System.out.println(convertNumber(4));
        System.out.println(convertNumber(9));
        System.out.println(convertNumber(58));
        System.out.println(convertNumber(1994));
    }


    public String convertNumber(int number) {
        if (number > 3999) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            if (number >= 1000) {
                sb.append("M");
                number -= 1000;
            } else if (number >= 900) {
                sb.append("CM");
                number -= 900;
            } else if (number >= 500) {
                sb.append("D");
                number -= 500;
            } else if (number >= 400) {
                sb.append("CD");
                number -= 400;
            } else if (number >= 100) {
                sb.append("C");
                number -= 100;
            } else if (number >= 90) {
                sb.append("XC");
                number -= 90;
            } else if (number >= 50) {
                sb.append("L");
                number -= 50;
            } else if (number >= 40) {
                sb.append("XL");
                number -= 40;
            } else if (number >= 10) {
                sb.append("X");
                number -= 10;
            } else if (number >= 9) {
                sb.append("IX");
                number -= 9;
            } else if (number >= 5) {
                sb.append("V");
                number -= 5;
            } else if (number >= 4) {
                sb.append("IV");
                number -= 4;
            } else if (number >= 1) {
                sb.append("I");
                number -= 1;
            }
        }
        return sb.toString();
    }
}

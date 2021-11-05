package com.test.leetcode.page1.chapter10.t12;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-19 17:22
 */
public class Solution20201019 {

    @Test
    public void test() {
        System.out.println(intToRoman(1994));
    }

    public String intToRoman(int num) {
        if (num > 3999 || num < 1) return "";
        int[] numA = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] romanA = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int length = numA.length;
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int index = -1;
            for (int i = length - 1; i >= 0; i--) {
                if (num >= numA[i]) {
                    index = i;
                    break;
                }
            }
            result.append(romanA[index]);
            num -= numA[index];
        }
        return result.toString();
    }
}

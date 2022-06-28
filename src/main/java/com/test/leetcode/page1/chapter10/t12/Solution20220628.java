package com.test.leetcode.page1.chapter10.t12;

import org.junit.Test;

/**
 * @ClassName: Solution20220628
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/6/28 09:47
 * @Version: 1.0
 */
public class Solution20220628 {

    @Test
    public void test() {
        System.out.println(intToRoman(1994));
    }

    public String intToRoman(int num) {
        int[] d = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] ds = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = d.length - 1; i >= 0; i--) {
            while (num >= d[i]) {
                stringBuilder.append(ds[i]);
                num -= d[i];
            }
        }
        return stringBuilder.toString();
    }
}

package com.test.leetcode.chapter10.t13;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-14 15:16
 */
public class Solution {

    Map<Character, Integer> romMap = new HashMap<>();

    {
        romMap.put('M', 1000);
        romMap.put('D', 500);
        romMap.put('C', 100);
        romMap.put('L', 50);
        romMap.put('X', 10);
        romMap.put('V', 5);
        romMap.put('I', 1);
    }

    @Test
    public void test() {
        System.out.println(romToNumber("III"));
        System.out.println(romToNumber("IV"));
        System.out.println(romToNumber("IX"));
        System.out.println(romToNumber("LVIII"));
        System.out.println(romToNumber("MCMXCIV"));
    }


    public int romToNumber(String s) {
        int preN = 1000;
        int number = 0;
        for (char c : s.toCharArray()) {
            int n = romMap.get(c);
            number += n;
            if (n > preN) number -= 2 * preN;
            preN = n;
        }
        return number;
    }
}

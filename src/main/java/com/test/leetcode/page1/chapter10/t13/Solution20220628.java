package com.test.leetcode.page1.chapter10.t13;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution20220628
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/6/28 10:08
 * @Version: 1.0
 */
public class Solution20220628 {

    Map<String, Integer> map = new HashMap() {
        {
            put("I", 1);
            put("IV", 4);
            put("V", 5);
            put("IX", 9);
            put("X", 10);
            put("XL", 40);
            put("L", 50);
            put("XC", 90);
            put("C", 100);
            put("CD", 400);
            put("D", 500);
            put("CM", 900);
            put("M", 1000);
        }
    };

    @Test
    public void test() {
        System.out.println(romanToInt("LVIII"));
    }

    public int romanToInt(String s) {
        int ant = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                ant += map.get(s.substring(i, i + 2));
                i++;
            } else {
                ant += map.get(s.substring(i, i + 1));
            }
        }
        return ant;
    }
}

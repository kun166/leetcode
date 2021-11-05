package com.test.leetcode.page1.chapter0.t3;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-10 11:09
 */
public class LongestStr {

    @Test
    public void test() {
        System.out.println(getLongestStr("abcdabchijklbb"));
    }

    public int getLongestStr(String str) {
        int max = 0;
        String result = null;
        int length = str.length();
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
            } else {
                int size = i - left;
                if (max < size) {
                    max = size;
                    result = str.substring(left, i);
                }
                left = map.get(c) + 1;
                map.clear();
                for (int j = left; j <= i; j++) {
                    map.put(str.charAt(j), j);
                }
            }
        }
        System.out.println(result);
        return max;
    }
}

package com.test.leetcode.page1.chapter30.t30;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-26 20:13
 */
public class Solution20201026 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wL = words.length;
        int wSL = words[0].length();
        int wTL = wL * wSL;

        int sL = s.length();
        if (sL < wTL) {
            return result;
        }
        int end = sL - wTL;
        for (int i = 0; i <= end; i++) {
            if (match(s.substring(i, i + wSL), words, wL) != null) {

            }
        }
        return result;
    }

    public String match(String s, String[] words, int wL) {
        for (int i = 0; i < wL; i++) {
            if (s.equals(words[i]))
                return words[i];
        }
        return null;
    }
}

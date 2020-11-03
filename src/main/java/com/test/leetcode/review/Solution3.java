package com.test.leetcode.review;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-30 16:21
 */
public class Solution3 {

    @Test
    public void test() {
        //System.out.println(lengthOfLongestSubstring("abcabcbb"));
        //System.out.println(lengthOfLongestSubstring("bbbbb"));
        //System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("cdd"));
    }

    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        int start = 0, length = 0;
        for (int i = 1; i < l; i++) {
            for (int j = start; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    length = Math.max(length, i - start);
                    start = j + 1;
                    break;
                }
            }
        }
        length = Math.max(length, l - start);
        return length;
    }
}

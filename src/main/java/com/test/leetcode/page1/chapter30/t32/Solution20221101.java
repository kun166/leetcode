package com.test.leetcode.page1.chapter30.t32;

/**
 * @ClassName: Solution20221101
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/1 19:27
 * @Version: 1.0
 */
public class Solution20221101 {

    public int longestValidParentheses(String s) {
        int[] pi = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    pi[i] = (i - 2 > 0 ? pi[i - 2] : 0) + 2;
                } else if (pi[i - 1] > 0 && i - pi[i - 1] > 0 && s.charAt(i - 1 - pi[i - 1]) == '(') {
                    pi[i] = pi[i - 1] + (i - pi[i - 1] - 2 > 0 ? pi[i - pi[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, pi[i]);
            }
        }
        return max;
    }
}

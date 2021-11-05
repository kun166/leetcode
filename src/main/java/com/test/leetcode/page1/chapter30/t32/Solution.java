package com.test.leetcode.page1.chapter30.t32;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-18 18:07
 */
public class Solution {


    @Test
    public void test() {
        //System.out.println(longestValidParentheses("(()"));
        // System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses(")(((((()())()()))()(()))("));
    }

    public int longestValidParentheses(String s) {
        // dp[i]标识，截止到i位置的最大匹配长度
        int[] dp = new int[s.length()];
        int maxans = 0;
        for (int i = 1; i < s.length(); i++) {
            // 从')'开始往前计算
            if (s.charAt(i) == ')') {
                //第一种情况：字符串形如 "……()"
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                //第二种情况：字符串形如 "……))"
                // i-dp[i-1]>=1能过滤掉"())"
                else if (s.charAt(i - 1) == ')' && i - dp[i - 1] >= 1 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // 2 + dp[i - 1]为(...()...)的长度，后面为(...()...)(...()...)的长度
                    dp[i] = 2 + dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public int longestValidParenthesesTwo(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}

package com.test.leetcode.page1.chapter30.t32;

/**
 * @ClassName: Solution20220222
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/2/22 15:29
 * @Version: 1.0
 */
public class Solution20220222 {

    public int longestValidParentheses(String s) {
        int maxans = 0;
        // dp[i]表示以i为下标前面的最大长度
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    // 形如(),则判断dp[i-2]的长度
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // 形如)),则判断dp[i - 1]
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
            // 以'('结尾的字符串，肯定不匹配
        }
        return maxans;
    }
}

package com.test.leetcode.page1.chapter30.t32;

/**
 * @ClassName: OfficeFirst20221009
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/9 19:18
 * @Version: 1.0
 */
public class OfficeFirst20221009 {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        // dp的下标是字符串s的下标，值为当前下标往前的匹配长度
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                // 只需要处理')'，不需要关注'('
                if (s.charAt(i - 1) == '(') {
                    // 如果是(),还需要关注(之前的部分，比如(())()
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // i - dp[i - 1] > 0 保证 i - dp[i - 1] -1>=0 ，避免())这种情况
                    // 可能存在这种情况(()(()))
                    // 也就是说如果)前面是)，有可能是(()),还有可能是(()())，因为是动态规划，还能解决(()()())这种问题
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}

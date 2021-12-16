package com.test.leetcode.page1.chapter0.t5;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-11 10:25
 */
public class SolutionDynamic {

    /**
     * 这个动态规划方式挺牛逼的
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // 1. 状态定义
        // dp[i][j] 表示s[i...j] 是否是回文串


        // 2. 初始化
        boolean[][] dp = new boolean[len][len];
        // 只有一个字符的是回文子
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();
        // 3. 状态转移
        // 注意：先填左下角
        // 填表规则：先一列一列的填写，再一行一行的填，保证左下方的单元格先进行计算
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                // 头尾字符不相等，不是回文串
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    // 相等的情况下
                    // 考虑头尾去掉以后没有字符剩余，或者剩下一个字符的时候，肯定是回文串
                    // 相差1的是偶数回文符，相差2的是奇数回文符
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        // 状态转移
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要dp[i][j] == true 成立，表示s[i...j] 是否是回文串
                // 此时更新记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        // 4. 返回值
        return s.substring(begin, begin + maxLen);
    }
}

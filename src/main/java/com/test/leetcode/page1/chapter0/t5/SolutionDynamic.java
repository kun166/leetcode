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
        // 填充规则：按列填充，从左到右。为什么会这样？下面有解说
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                // i>j的时候，这个肯定是不合法字符串，头肯定不会大于尾
                // i==j的时候，上面已经填充过了，因此i<j
                // 头尾字符不相等，不是回文串
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    // 相等的情况下
                    // 考虑头尾去掉以后没有字符剩余，或者剩下一个字符的时候，肯定是回文串
                    // 相差1的是偶数回文符，相差2的是奇数回文符
                    if (j - i < 3) {
                        // 这一步非常的重要,j-i=1的时候，这个说明是偶数回文字符串。j-i=2的时候，这个说明是奇数回文字符串
                        dp[i][j] = true;
                    } else {
                        // 状态转移
                        // 重点在这里。执行到这一步的时候,dp[i+1][j-1]是否已经填充了？
                        // 执行到这里的时候,j是最外层的循环,j-1刚刚执行过了，又因为上面j-i<3判断过了，这个地方j-i>=3,那i+1肯定小于等于j-1
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

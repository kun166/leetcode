package com.test.leetcode.page4.chapter390.t392;

/**
 * @ClassName: SolutionSecond20230518
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/18 08:30
 * @Version: 1.0
 */
public class SolutionSecond20230518 {

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了51.12%的用户
     * 内存消耗：42.6 MB, 在所有 Java 提交中击败了5.04%的用户
     * 通过测试用例：18 / 18
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (t == null || t.length() == 0) {
            return false;
        }
        // 先解析出来t，和s无关了
        int n = t.length();
        int[][] dp = new int[n + 1][26];
        // 初始化dp
        for (int i = 0; i < 26; i++) {
            dp[n][i] = n;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                dp[i][j] = dp[i + 1][j];
            }
            dp[i][t.charAt(i) - 'a'] = i;
        }
        // dp初始化好了，然后求s
        int index = 0;
        for (char c : s.toCharArray()) {
            index = dp[index][c - 'a'];
            if (index == n) {
                return false;
            }
            index++;
        }
        return true;
    }
}

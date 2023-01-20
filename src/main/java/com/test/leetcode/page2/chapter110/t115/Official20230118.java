package com.test.leetcode.page2.chapter110.t115;

import org.junit.Test;

/**
 * @ClassName: Official20230118
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/18 8:45
 * @Version: 1.0
 */
public class Official20230118 {

    @Test
    public void test() {
        System.out.println(numDistinct("abbc", "ac"));
    }

    /**
     * 动态规划。
     * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
     * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
     *
     * @param s 字符串
     * @param t 子字符串
     * @return
     */
    public int numDistinct(String s, String t) {
        // 先拿到两个字符串的长度
        int m = s.length(), n = t.length();
        if (m < n) {
            // 如果字符串长度小于子字符串长度，肯定就一个也不匹配了
            return 0;
        }
        // 建立dp二维数组。注意dp[i][j]是指s的从后向前数第i个字符到字符串末尾，
        // 和t的从后向前数第j个字符到字符串末尾的匹配个数
        // 都是从后向前开始匹配
        int[][] dp = new int[m + 1][n + 1];
        // 因为空字符串和任意字符串相匹配
        // dp[i][n]表示的是字符串s的从0-(n-1)匹配t的空字符串，都匹配，所以都是1
        // 上面这个设定，可能和题解有关系，不是很理解
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char tChar = t.charAt(j);
                if (sChar == tChar) {
                    // sChar == tChar的时候，可以选择sChar和tChar的时候匹配，也可以选择不匹配
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    // sChar != tChar的时候,只会有不匹配这种情况
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
}

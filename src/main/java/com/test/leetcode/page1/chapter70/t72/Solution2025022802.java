package com.test.leetcode.page1.chapter70.t72;

import org.junit.Test;

/**
 * @ClassName: Solution2025022802
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/28 16:51
 * @Version: 1.0
 */
public class Solution2025022802 {

    @Test
    public void test() {
        System.out.println(minDistance("horse", "ros"));
    }

    /**
     * 唉唉唉，超时了，看了答案之后，自己再写一遍吧
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        // 先想好一个问题,如果word1是空字符串?这决定dp数组是n还是n+1
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // m == 0,即word1不选择字符的时候
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 插入一个字符,删除一个字符,改变一个字符
                    // 1,word1插入一个字符
                    // 新插入的字符与word2的第j个字符匹配
                    dp[i][j] = dp[i][j - 1] + 1;
                    // 2,word1删除一个字符
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    // 3,word1改变一个字符
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                    // 4,word2插入一个字符,和word1删除一个字符一样
                    // dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    // 5,word2删除一个字符。和word1插入一个字符一样
                    // dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    // 6,word2改变一个字符。和word1改变一个字符一样
                    // dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }

}

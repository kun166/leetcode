package com.test.leetcode.page1.chapter10.t10;

import org.junit.Test;

/**
 * @ClassName: Solution20221021
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/21 10:58
 * @Version: 1.0
 */
public class Solution20221021 {

    @Test
    public void test(){
        System.out.println(isMatch("aa","a*"));
    }



    public boolean isMatch(String s, String p) {
        int sL = s.length(), pL = p.length();
        boolean[][] dp = new boolean[sL + 1][pL + 1];
        dp[0][0] = true;
        // 注意下面的i和j都是长度
        for (int i = 0; i <= sL; i++) {
            for (int j = 1; j <= pL; j++) {
                // 除了dp[0][0],j==0没意义？
                if (p.charAt(j - 1) == '*') {
                    // 一个也不匹配
                    dp[i][j] = dp[i][j - 2];
                    if (isMatch(s, p, i, j - 1)) {
                        // 匹配一个
                        dp[i][j] = dp[i][j] || dp[i - 1][j - 2];
                        // 匹配多个
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else if (isMatch(s, p, i, j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[sL][pL];
    }

    public boolean isMatch(String s, String p, int sp, int pp) {
        if (sp <= 0) {
            return false;
        }
        return p.charAt(pp - 1) == '.' || p.charAt(pp - 1) == s.charAt(sp - 1);
    }
}

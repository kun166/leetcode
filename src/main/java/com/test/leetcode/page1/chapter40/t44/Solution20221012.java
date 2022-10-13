package com.test.leetcode.page1.chapter40.t44;

import org.junit.Test;

import java.sql.SQLOutput;

/**
 * @ClassName: Solution20221012
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/12 09:58
 * @Version: 1.0
 */
public class Solution20221012 {

    @Test
    public void test() {
        System.out.println(isMatch("", "******"));
    }

    /**
     * 动态规划dynamic programing
     * <p>
     * 1，非'.'非'*'，则需要满足s[i]==p[j]，然后再比较i和j之前的是否匹配
     * 2，p[j]是'.'，则满足s[i]==p[j]
     * 3,p[j]是'*'，匹配0个字符，匹配一个字符，匹配多个字符
     * 匹配0个字符，则s下标i之前的字符串匹配p下标j-1之前的串，就匹配
     * 匹配1个字符，则比较i-1和j-1之前的是否匹配
     * 匹配N个字符,则比较i-1和j-1之前的是否匹配
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (s.length() != 0 && p.length() == 0) {
            return false;
        }
        if (s.length() == 0) {
            boolean ant = true;
            for (int l = 0; l < p.length(); l++) {
                if (p.charAt(l) != '*') {
                    ant = false;
                    break;
                }
            }
            return ant;
        }
        // 先做一个dp的记录表
        boolean[][] dp = new boolean[s.length()][p.length()];
        // 先补充起点数据
        dp[0][0] = isMatch(s, p, 0, 0);
        if (p.charAt(0) == '*') {
            for (int i = 0; i < s.length(); i++) {
                dp[i][0] = true;
            }
        }
        // 隐含的条件p.charAt(0) != '*',则dp[i][0]，i>0的时候都是false
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < p.length(); j++) {
                if (p.charAt(j) == '*') {
                    // 匹配0个字符
                    dp[i][j] = dp[i][j - 1];
                    // 匹配1个或者多个字符
                    if (i > 0) {
                        // 匹配一个字符
                        dp[i][j] = dp[i][j] || dp[i - 1][j - 1];
                        // 匹配多个字符
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else if (isMatch(s, p, i, j)) {
                    // i==0
                    if (i == 0) {
                        dp[i][j] = true;
                        for (int l = 0; l < j; l++) {
                            if (p.charAt(l) != '*') {
                                dp[i][j] = false;
                                break;
                            }
                        }
                    } else {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[s.length() - 1][p.length() - 1];
    }

    public boolean isMatch(String s, String p, int sp, int pp) {
        // 这个地方还需要判断，如果sp,pp都小于0的话怎么办？
        if (p.charAt(pp) == '?' || s.charAt(sp) == p.charAt(pp)) {
            return true;
        }
        return false;
    }
}

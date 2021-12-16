package com.test.leetcode.page1.chapter0.t5;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-10 19:24
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(longestPalindrome("abcabcbadd"));
        //System.out.println("babad".substring(0, 2));
    }


    /**
     * 动态规划的方式。这种方式效率不高
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        // 二位数组。第一个坐标是子串开始位置，第二个坐标是子串结束位置
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        // 下面差不多等于递归
        // 遍历每一个字符串，当做子串起始字符串
        // 下面的递归方式是走的如下形式填空。从左侧开始，以列循环填写。
        /*
         *   #
         *   # #
         *   # # #
         *   # # # #
         *   # # # # #
         */
        // 上面的理解应该不是很确切，这个算法应该是按字符长度递归。以每一个字符为中心，按长度从小到递归
        // 最外层这个循环的是字符串长度-1
        for (int l = 0; l < n; ++l) {
            // 先计算从字符串开始到当前字符串内的字符串是否是回文子。
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;// j是结束位置。l是当前子串结束位置
                if (l == 0) {
                    // 单个字符回文子
                    // l=0,则i=j,即开始位置和结束位置相同，单个字符，肯定为回文子
                    dp[i][j] = true;
                } else if (l == 1) {
                    // 两个字符，且相等的也为回文子
                    // 第二个字母和第一个字母相等的，肯定是回文子
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    // 开始和结束的两个字母相同，且中间位置是回文子的，则是回文子。i+1可能越界访问了
                    if (i != j) dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    // 如果ij是回文子，且
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }
}

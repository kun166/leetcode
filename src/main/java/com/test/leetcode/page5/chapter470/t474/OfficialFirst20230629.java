package com.test.leetcode.page5.chapter470.t474;

/**
 * @ClassName: Official20230629
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/29 16:31
 * @Version: 1.0
 */
public class OfficialFirst20230629 {

    /**
     * @param strs 二进制字符串数组
     * @param m    0的个数
     * @param n    1的个数
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        // dp[i][j][k]表示在前 i 个字符串中，使用 j 个 0 和 k 个 1 的情况下最多可以得到的字符串数量。
        // 假设数组 str 的长度为 l，则最终答案为 dp[l][m][n]。
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        for (int i = 1; i <= length; i++) {
            int[] zerosOnes = getZerosOnes(strs[i - 1]);
            int zeros = zerosOnes[0], ones = zerosOnes[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    // 当前字符串没选的话，和上一个一样
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[length][m][n];
    }

    /**
     * 获取字符串str中，0和1的个数
     *
     * @param str
     * @return
     */
    public int[] getZerosOnes(String str) {
        int[] zerosOnes = new int[2];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }
}

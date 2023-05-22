package com.test.leetcode.page4.chapter390.t392;

/**
 * @ClassName: OfficialSecond20230518
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/18 08:48
 * @Version: 1.0
 */
public class OfficialSecond20230518 {

    /**
     * 动态规划啊
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                // 这个代码写的也好
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}

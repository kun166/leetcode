package com.test.leetcode.page1.chapter90.t91;

/**
 * @ClassName: OfficialFirst20221228
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/28 09:50
 * @Version: 1.0
 */
public class OfficialFirst20221228 {

    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}

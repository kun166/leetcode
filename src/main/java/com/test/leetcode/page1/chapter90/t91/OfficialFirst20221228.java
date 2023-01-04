package com.test.leetcode.page1.chapter90.t91;

import org.junit.Test;

/**
 * @ClassName: OfficialFirst20221228
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/28 09:50
 * @Version: 1.0
 */
public class OfficialFirst20221228 {

    @Test
    public void test() {
        //System.out.println(numDecodings("06666"));
        System.out.println(numDecodings("2101"));
    }

    /**
     * 动态规划，dp
     * 这解法是从前往后
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                // 这个地方应该理解为，如果s.charAt(i - 1) == '0'，f[i]=0，否则f[i] = f[i - 1];
                f[i] += f[i - 1];
            }
            // s.charAt(i - 2) != '0'，保证两位数，不以'0'开头，比如"2101"的时候，"01"不能算
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                // 两位能凑齐一个数，且该数不大于26
                // s.charAt(i - 2) == '0'的时候，f[i - 2]==0，也成立吧？
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}

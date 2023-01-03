package com.test.leetcode.page1.chapter90.t91;

import org.junit.Test;

/**
 * @ClassName: Solution20230103
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/3 09:21
 * @Version: 1.0
 */
public class Solution20230103 {

    @Test
    public void test() {
        System.out.println(numDecodings("2101"));
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                // 这个地方应该理解为，如果s.charAt(i - 1) == '0'，f[i]=0，否则f[i] = f[i - 1];
                f[i] = f[i - 1];
            }
            if (i > 1 && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                // 两位能凑齐一个数，且该数不大于26
                // s.charAt(i - 2) == '0'的时候，f[i - 2]==0，也成立吧？
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}

package com.test.leetcode.page3.chapter210.t214;

import java.util.Arrays;

/**
 * @ClassName: Official20230224
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/24 16:43
 * @Version: 1.0
 */
public class Official20230224 {

    /**
     * KMP 算法
     *
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        // 字符串长度
        int n = s.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);
        // 求s的PMT
        for (int i = 1; i < n; ++i) {
            int j = fail[i - 1];
            while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                j = fail[j];
            }
            if (s.charAt(j + 1) == s.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        int best = -1;
        // 以s为匹配串，s的反序为查找串，进行KMP匹配
        for (int i = n - 1; i >= 0; --i) {
            while (best != -1 && s.charAt(best + 1) != s.charAt(i)) {
                best = fail[best];
            }
            if (s.charAt(best + 1) == s.charAt(i)) {
                ++best;
            }
        }
        String add = (best == n - 1 ? "" : s.substring(best + 1));
        StringBuffer ans = new StringBuffer(add).reverse();
        ans.append(s);
        return ans.toString();
    }
}

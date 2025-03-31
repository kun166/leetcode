package com.test.leetcode.page3.chapter210.t214;

import org.junit.Test;

/**
 * @ClassName: Solution2025032801
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/28 17:24
 * @Version: 1.0
 */
public class Solution2025032803 {

    @Test
    public void test() {
        System.out.println(shortestPalindrome("aacecaaa"));
        System.out.println(shortestPalindrome("aaacecaa"));
        System.out.println(shortestPalindrome(""));
        System.out.println(shortestPalindrome("aaa"));
        System.out.println(shortestPalindrome("a"));
    }

    /**
     * kmp
     * <p>
     * 通过前面的分析,我们可以拿"aacecaaa"来分析
     * 1,"aacecaaa"的翻转:"aaacecaa"
     * 2,实际上求得是:
     * aaacecaa
     * _aacecaaa
     * 3,前后顺序一定不要错了
     * 4,在看"aaacecaa",它的最短回文串可就是"aacecaaacecaa"了
     * <p>
     * 6ms	击败71.82%
     * 44.05MB	击败68.23%
     *
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        int n = s.length();
        // 1,求s的pmt
        int[] pmt = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pmt[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            pmt[i] = j;
        }
        String rs = new StringBuilder(s).reverse().toString();
        int best = 0;
        /**
         * 这个地方要从0开始了,只有求pmt的时候才从1开始……
         */
        for (int i = 0; i < n; i++) {
            while (best > 0 && rs.charAt(i) != s.charAt(best)) {
                best = pmt[best - 1];
            }
            if (rs.charAt(i) == s.charAt(best)) {
                best++;
            }
        }
        return best == n ? s : rs.substring(0, n - best) + s;
    }
}

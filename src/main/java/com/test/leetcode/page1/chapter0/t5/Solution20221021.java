package com.test.leetcode.page1.chapter0.t5;

import org.junit.Test;

/**
 * @ClassName: Solution20221021
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/21 09:52
 * @Version: 1.0
 */
public class Solution20221021 {

    @Test
    public void test() {
        System.out.println(longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        int l = 0, r = 0, nl, nr;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                nl = i - 1;
                nr = i;
                while (nl >= 0 && nr < s.length() && s.charAt(nl) == s.charAt(nr)) {
                    nl--;
                    nr++;
                }
                if (nr - nl - 2 > r - l) {
                    r = nr - 1;
                    l = nl + 1;
                }
            }
            nl = i;
            nr = i;
            while (nl >= 0 && nr < s.length() && s.charAt(nl) == s.charAt(nr)) {
                nl--;
                nr++;
            }
            if (nr - nl - 2 > r - l) {
                r = nr - 1;
                l = nl + 1;
            }
        }
        return s.substring(l, r + 1);
    }
}

package com.test.leetcode.page5.chapter400.t409;

/**
 * @ClassName: OfficialFirst20230526
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/26 08:46
 * @Version: 1.0
 */
public class OfficialFirst20230526 {

    /**
     * 方法一：贪心
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}

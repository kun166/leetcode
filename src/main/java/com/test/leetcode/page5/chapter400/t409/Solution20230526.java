package com.test.leetcode.page5.chapter400.t409;

/**
 * @ClassName: Solution20230526
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/26 08:34
 * @Version: 1.0
 */
public class Solution20230526 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.8 MB, 在所有 Java 提交中击败了52.99%的用户
     * 通过测试用例：95 / 95
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        int ans = 0;
        int[] low = new int[26];
        int[] upper = new int[26];
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                low[c - 'a']++;
            } else {
                upper[c - 'A']++;
            }
        }
        for (int i : low) {
            ans += i / 2 * 2;
        }
        for (int i : upper) {
            ans += i / 2 * 2;
        }
        return ans == s.length() ? ans : ans + 1;
    }
}

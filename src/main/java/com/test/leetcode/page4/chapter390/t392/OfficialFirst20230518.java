package com.test.leetcode.page4.chapter390.t392;

/**
 * @ClassName: OfficialFirst20230518
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/18 08:29
 * @Version: 1.0
 */
public class OfficialFirst20230518 {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}

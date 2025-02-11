package com.test.leetcode.page1.chapter10.t13;

/**
 * @ClassName: Solution20250211
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/11 11:49
 * @Version: 1.0
 */
public class Solution20250211 {

    public int romanToInt(String s) {
        char[] c = s.toCharArray();
        int ans = 0;
        if (c[0] == 'M')
            ans += 1000;
        else if (c[0] == 'D')
            ans += 500;
        else if (c[0] == 'C')
            ans += 100;
        else if (c[0] == 'L')
            ans += 50;
        else if (c[0] == 'X')
            ans += 10;
        else if (c[0] == 'V')
            ans += 5;
        else if (c[0] == 'I')
            ans += 1;
        for (int i = 1; i < c.length; i++) {
            // 从后往前
            if (c[i] == 'M') {
                ans += c[i - 1] == 'C' ? 800 : 1000;
            } else if (c[i] == 'D') {
                ans += c[i - 1] == 'C' ? 300 : 500;
            } else if (c[i] == 'C') {
                ans += c[i - 1] == 'X' ? 80 : 100;
            } else if (c[i] == 'L') {
                ans += c[i - 1] == 'X' ? 30 : 50;
            } else if (c[i] == 'X') {
                ans += c[i - 1] == 'I' ? 8 : 10;
            } else if (c[i] == 'V') {
                ans += c[i - 1] == 'I' ? 3 : 5;
            } else if (c[i] == 'I') {
                ans += 1;
            }
        }

        return ans;
    }
}

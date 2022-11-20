package com.test.leetcode.page1.chapter60.t67;

/**
 * @ClassName: Solution20221119
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/19 19:06
 * @Version: 1.0
 */
public class Solution20221119 {
    public String addBinary(String a, String b) {
        int m = a.length(), n = b.length();
        StringBuilder builder = new StringBuilder();
        int pass = 0;
        int aL = 0, bL = 0;
        while (aL < m || bL < n) {
            int sum = pass
                    + (aL < m ? (a.charAt(m - 1 - aL) - '0') : 0)
                    + (bL < n ? (b.charAt(n - 1 - bL) - '0') : 0);
            builder.append(sum % 2);
            pass = sum / 2;
            aL++;
            bL++;
        }
        if (pass > 0) {
            builder.append(pass);
        }
        return builder.reverse().toString();
    }
}

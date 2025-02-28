package com.test.leetcode.page1.chapter60.t67;

/**
 * @ClassName: Solution2025022701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/27 17:40
 * @Version: 1.0
 */
public class Solution2025022701 {

    /**
     * 偷懒法吧
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int pass = 0;
        int length = Math.max(a.length(), b.length());
        int index = 0;
        while (++index <= length) {
            int sum = getCharValue(a, index) + getCharValue(b, index) + pass;
            builder.append(sum > 1 ? sum - 2 : sum);
            pass = sum > 1 ? 1 : 0;
        }
        builder.append(pass > 0 ? pass : "");
        return builder.reverse().toString();
    }

    /**
     * @param str
     * @param index
     * @return
     */
    int getCharValue(String str, int index) {
        return index > str.length() ? 0 : str.charAt(str.length() - index) - '0';
    }
}

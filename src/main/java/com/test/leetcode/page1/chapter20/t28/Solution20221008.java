package com.test.leetcode.page1.chapter20.t28;

/**
 * @ClassName: Solution20221008
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/8 17:56
 * @Version: 1.0
 */
public class Solution20221008 {

    public int strStr(String haystack, String needle) {
        int def = haystack.length() - needle.length();
        for (int i = 0; i <= def; i++) {
            boolean reg = true;
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    reg = false;
                    break;
                }
            }
            if (reg) {
                return i;
            }
        }
        return -1;
    }
}

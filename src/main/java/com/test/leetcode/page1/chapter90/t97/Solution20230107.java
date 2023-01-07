package com.test.leetcode.page1.chapter90.t97;

import org.junit.Test;

/**
 * @ClassName: Solution20230107
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/7 16:21
 * @Version: 1.0
 */
public class Solution20230107 {

    @Test
    public void test() {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    /**
     * 这也是一个错误的示范，哈哈
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() == 0) {
            return s2.equals(s3);
        }
        if (s2.length() == 0) {
            return s1.equals(s3);
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int index1 = 0, index2 = 0;
        for (char c : s3.toCharArray()) {
            if (index1 < s1.length() && c == s1.charAt(index1)) {
                index1++;
                continue;
            }
            if (index2 < s2.length() && c == s2.charAt(index2)) {
                index2++;
                continue;
            }
            return false;
        }
        return true;
    }
}

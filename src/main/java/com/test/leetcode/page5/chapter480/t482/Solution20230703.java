package com.test.leetcode.page5.chapter480.t482;

import org.junit.Test;

/**
 * @ClassName: Solution20230703
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/3 10:59
 * @Version: 1.0
 */
public class Solution20230703 {

    @Test
    public void test() {
        // System.out.println(licenseKeyFormatting());
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了98.87%的用户
     * 内存消耗：42.6 MB, 在所有 Java 提交中击败了26.91%的用户
     * 通过测试用例：38 / 38
     *
     * @param s
     * @param k
     * @return
     */
    public String licenseKeyFormatting(String s, int k) {
        //第一遍计算除了'-'之外的字符长度
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c != '-') {
                count++;
            }
        }
        // 第一个字符串的长度为 count%k
        int first = count % k;
        first = first == 0 ? k : first;
        StringBuilder builder = new StringBuilder();
        int start = 0;
        while (start < s.length()) {
            char c = s.charAt(start);
            start++;
            if (c == '-') {
                continue;
            }
            if (c >= 'a' && c <= 'z') {
                builder.append((char) ('A' + c - 'a'));
            } else {
                builder.append(c);
            }
            first--;
            if (first == 0) {
                first = k;
                builder.append('-');
            }
        }
        if (builder.length() > 0 && builder.charAt(builder.length() - 1) == '-') {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }
}

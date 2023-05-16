package com.test.leetcode.page4.chapter380.t389;

/**
 * @ClassName: Solution20230516
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/16 10:15
 * @Version: 1.0
 */
public class Solution20230516 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了98.80%的用户
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了11.83%的用户
     * 通过测试用例：54 / 54
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int[] array = new int[26];
        for (char c : s.toCharArray()) {
            array[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (--array[c - 'a'] < 0) {
                return c;
            }
        }
        return 'a';
    }
}

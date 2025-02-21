package com.test.leetcode.page4.chapter390.t392;

/**
 * @ClassName: Solution20230518
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/18 08:08
 * @Version: 1.0
 */
public class SolutionFirst20230518 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了88.76%的用户
     * 内存消耗：39.5 MB, 在所有 Java 提交中击败了71.25%的用户
     * 通过测试用例：18 / 18
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (t == null || t.length() == 0) {
            return false;
        }
        int start = 0;
        for (char c : s.toCharArray()) {
            if (start == t.length()) {
                return false;
            }
            for (; start < t.length(); start++) {
                if (c == t.charAt(start)) {
                    // 这里一定要注意，break,return和continue的区别
                    start++;
                    break;
                }
            }
        }
        return s.charAt(s.length() - 1) == t.charAt(start - 1);
    }
}

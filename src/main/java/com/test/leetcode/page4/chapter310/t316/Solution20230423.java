package com.test.leetcode.page4.chapter310.t316;

/**
 * @ClassName: Solution20230423
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/23 08:44
 * @Version: 1.0
 */
public class Solution20230423 {

    /**
     * 贪心 + 单调栈
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：40 MB, 在所有 Java 提交中击败了92.64%的用户
     * 通过测试用例：290 / 290
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        int[] array = new int[26];
        boolean[] b = new boolean[26];
        for (char c : s.toCharArray()) {
            array[c - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (b[s.charAt(i) - 'a']) {
                array[s.charAt(i) - 'a']--;
                continue;
            }
            while (builder.length() > 0 && builder.charAt(builder.length() - 1) > s.charAt(i)) {
                if (array[builder.charAt(builder.length() - 1) - 'a'] > 0) {
                    b[builder.charAt(builder.length() - 1) - 'a'] = false;
                    //array[builder.charAt(builder.length() - 1) - 'a']--;
                    builder.deleteCharAt(builder.length() - 1);
                } else {
                    break;
                }
            }
            array[s.charAt(i) - 'a']--;
            b[s.charAt(i) - 'a'] = true;
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}

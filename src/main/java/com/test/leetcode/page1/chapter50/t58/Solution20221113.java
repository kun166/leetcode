package com.test.leetcode.page1.chapter50.t58;

/**
 * @ClassName: Solution20221113
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/13 19:56
 * @Version: 1.0
 */
public class Solution20221113 {

    public void test() {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }

    public int lengthOfLastWord(String s) {
        int length = 0;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (cur != 0) {
                    length = cur;
                }
                cur = 0;
            } else {
                cur++;
            }
        }
        return cur != 0 ? cur : length;
    }
}

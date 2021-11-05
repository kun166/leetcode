package com.test.leetcode.page1.chapter50.t58;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-06 12:52
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(lengthOfLastWord("a "));
    }

    public int lengthOfLastWord(String s) {
        int length = s.length();
        int blankLength = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (blankLength == length - 1 - i)
                    blankLength++;
                else
                    return length - 1 - i - blankLength;
            }

        }
        return length - blankLength;
    }
}

package com.test.leetcode.page1.chapter50.t58;

/**
 * @ClassName: Solution20250227
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/27 09:57
 * @Version: 1.0
 */
public class Solution2025022701 {


    /**
     * 我草，这个最后一个字符串的长度……为啥不从后向前找?
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int right = s.length() - 1;
        while (s.charAt(right) == ' ')
            right--;
        int left = right - 1;
        while (left >= 0 && s.charAt(left) != ' ')
            left--;
        return right - left;
    }
}

package com.test.leetcode.page1.chapter0.t5;

/**
 * @ClassName: Solution20250208
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/8 10:57
 * @Version: 1.0
 */
public class SolutionSecond20250208 {

    /**
     * 最长回文子串
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        // 用于记录当前最大的回文字符串的左边界和右边界
        int left = 0, right = 0;
        for (int i = 1; i < s.length(); i++) {
            int[] indexArray = longestPalindromeABA(s, i);
            if (indexArray[1] - indexArray[0] > right - left) {
                left = indexArray[0];
                right = indexArray[1];
            }
            indexArray = longestPalindromeAA(s, i);
            if (indexArray[1] - indexArray[0] > right - left) {
                left = indexArray[0];
                right = indexArray[1];
            }
        }
        return s.substring(left, right + 1);
    }

    /**
     * 以index为中心的最长aba的回文字符串的长度
     *
     * @param s
     * @param index
     * @return
     */
    public int[] longestPalindromeABA(String s, int index) {
        int left = index, right = index;
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right - 1};
    }

    /**
     * 以index为中心的最长aa的回文字符串的长度
     *
     * @param s
     * @param index
     * @return
     */
    public int[] longestPalindromeAA(String s, int index) {
        int left = index, right = index;
        // 这个地方不需要处理右边了，右边由index+1处理了
        if (index > 0 && s.charAt(index - 1) == s.charAt(index)) {
            // 左边aa
            left = index - 1;
            right = index;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
        }
        return new int[]{left + 1, right - 1};
    }
}

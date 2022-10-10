package com.test.leetcode.page1.chapter30.t32;

/**
 * @ClassName: OfficeThird20221009
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/9 19:51
 * @Version: 1.0
 */
public class OfficeThird20221009 {

    /**
     * 这个是先从前面找最长的串，然后再从后面找最长的串，然后比较两者谁大取谁
     * 这个解法也很以后意思
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}

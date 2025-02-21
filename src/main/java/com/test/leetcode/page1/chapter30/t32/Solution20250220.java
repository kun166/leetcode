package com.test.leetcode.page1.chapter30.t32;

import org.junit.Test;

/**
 * @ClassName: Solution20250220
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/20 16:15
 * @Version: 1.0
 */
public class Solution20250220 {

    @Test
    public void test() {
        System.out.println(longestValidParentheses("()(()"));
    }

    /**
     * 唉，这种解法是错误的……
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        return Math.min(getLeft(s), getRight(s));
    }

    public int getLeft(String s) {
        int start = 0, ans = 0, leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (leftCount == 0) {
                    // 计算长度
                    ans = Math.max(ans, i - start);
                    start = i + 1;
                } else {
                    leftCount--;
                }
            } else {
                leftCount++;
            }
        }
        ans = Math.max(ans, s.length() - start - leftCount);
        return ans;
    }

    public int getRight(String s) {
        int start = s.length() - 1, ans = 0, rightCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                if (rightCount == 0) {
                    // 计算长度
                    ans = Math.max(ans, start - i);
                    start = i - 1;
                } else {
                    rightCount--;
                }
            } else {
                rightCount++;
            }
        }
        ans = Math.max(ans, start - rightCount + 1);
        return ans;
    }
}

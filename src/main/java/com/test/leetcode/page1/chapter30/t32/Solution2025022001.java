package com.test.leetcode.page1.chapter30.t32;

import java.util.LinkedList;

/**
 * @ClassName: Solution2025022001
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/20 16:50
 * @Version: 1.0
 */
public class Solution2025022001 {

    /**
     * 呃，解法是错误的,没法解决"()()"
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int ans = 0;
        LinkedList<Integer> ll = new LinkedList();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                ll.push(i);
            } else if (!ll.isEmpty()) {
                ans = Math.max(ans, i - ll.pop() + 1);
            }
        }
        return ans;
    }
}

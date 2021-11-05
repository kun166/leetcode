package com.test.leetcode.page2.chapter130.t132;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-19 16:37
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(minCut("ababbbabbaba"));
    }

    public int minCut(String s) {
        int result = 0, start = 0, end = s.length() - 1;
        boolean forward;
        int left = partition(s, start, end, true);
        if (left == s.length()) {
            return 0;
        }
        int right = partition(s, start, end, false);
        forward = left >= right;
        while (start < end) {
            if (forward) {
                start += left;
                left = partition(s, start, end, true);
            } else {
                end -= right;
                right = partition(s, start, end, false);
            }
            result++;
            forward = left >= right;
        }
        return result;
    }

    /**
     * 返回最长距离的回文子
     *
     * @param s
     * @param start
     * @return
     */
    public int partition(String s, int start, int end, boolean forward) {
        int max = 0;
        if (forward) {
            for (int i = end; i > start; i--) {
                int from = start, to = i;
                while (from < to) {
                    if (s.charAt(from) != s.charAt(to)) {
                        break;
                    }
                    from++;
                    to--;
                }
                if (from >= to) {
                    max = Math.max(max, i - start + 1);
                }
            }
            return Math.max(max, 1);
        }
        for (int i = start; i < end; i++) {
            int from = i, to = end;
            while (from < to) {
                if (s.charAt(from) != s.charAt(to)) {
                    break;
                }
                from++;
                to--;
            }
            if (from >= to) {
                max = Math.max(max, end - i + 1);
            }
        }
        return Math.max(max, 1);
    }
}

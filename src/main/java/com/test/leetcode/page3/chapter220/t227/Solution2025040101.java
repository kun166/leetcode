package com.test.leetcode.page3.chapter220.t227;

/**
 * @ClassName: Solution2025040101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/4/1 16:34
 * @Version: 1.0
 */
public class Solution2025040101 {

    /**
     * 5ms	击败99.48%
     * 43.99MB	击败97.68%
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        int ans = 0, first = 0, second = 0, n = s.length(), preSign = 1;
        char curSign = ' ';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '+') {
                if (curSign == '*') {
                    first *= second;
                } else if (curSign == '/') {
                    first /= second;
                }
                ans += preSign * first;
                first = second = 0;
                curSign = ' ';
                preSign = 1;
            } else if (c == '-') {
                if (curSign == '*') {
                    first *= second;
                } else if (curSign == '/') {
                    first /= second;
                }
                ans += preSign * first;
                first = second = 0;
                curSign = ' ';
                preSign = -1;
            } else if (c == '*') {
                if (curSign == '*') {
                    first *= second;
                } else if (curSign == '/') {
                    first /= second;
                }
                second = 0;
                curSign = '*';
            } else if (c == '/') {
                if (curSign == '*') {
                    first *= second;
                } else if (curSign == '/') {
                    first /= second;
                }
                second = 0;
                curSign = '/';
            } else {
                if (curSign == ' ') {
                    first = first * 10 + (c - '0');
                } else {
                    second = second * 10 + (c - '0');
                }
            }
        }
        if (curSign == '*') {
            first *= second;
        } else if (curSign == '/') {
            first /= second;
        }
        ans += preSign * first;
        return ans;
    }
}

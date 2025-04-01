package com.test.leetcode.page3.chapter220.t227;

/**
 * @ClassName: Solution2025040101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/4/1 16:34
 * @Version: 1.0
 */
public class Solution2025040102 {

    /**
     * 太丑了,优化下代码
     * <p>
     * 呃,代码没运行过,也不知道可以不
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        int ans = 0, first = 0, second = 0, n = s.length(), preSign = 1, curSign = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c >= '0' && c <= '9') {
                if (curSign == 0) {
                    first = first * 10 + (c - '0');
                } else {
                    second = second * 10 + (c - '0');
                }
                continue;
            }
            if (curSign == 1) {
                first *= second;
            } else if (curSign == 2) {
                first /= second;
            }
            if (c == '*' || c == '/') {
                second = 0;
                curSign = c == '*' ? 1 : 2;
            } else {
                ans += preSign * first;
                first = second = 0;
                curSign = 0;
                preSign = c == '+' ? 1 : -1;
            }
        }
        if (curSign == 1) {
            first *= second;
        } else if (curSign == 2) {
            first /= second;
        }
        ans += preSign * first;
        return ans;
    }
}

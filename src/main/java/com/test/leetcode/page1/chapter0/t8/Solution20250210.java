package com.test.leetcode.page1.chapter0.t8;

/**
 * @ClassName: Solution20250210
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/10 16:39
 * @Version: 1.0
 */
public class Solution20250210 {

    public int myAtoi(String s) {
        long ans = 0;
        // 记录前缀符号，是+还是-
        Integer pre = null;
        for (char c : s.toCharArray()) {
            if (pre == null) {
                // 数字未初始化,这个自后只允许 +,-,数字或者是空格
                if (c == '+') {
                    pre = 1;
                } else if (c == '-') {
                    pre = -1;
                } else if (c >= '0' && c <= '9') {
                    pre = 1;
                    ans += c - '0';
                } else if (c != ' ') {
                    return (int) ans;
                }
            } else {
                // 已经初始化了,只处理数字
                if (c < '0' || c > '9') {
                    // 非数字
                    return (int) ans * pre;
                }
                // 判断是否超过int值
                ans = ans * 10 + c - '0';
                if (pre == 1 && ans > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (pre == -1 && -ans < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
        }

        return pre != null ? (int) ans * pre : (int) ans;
    }
}

package com.test.leetcode.page1.chapter30.t38;

/**
 * @ClassName: Solution20250221
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/21 16:22
 * @Version: 1.0
 */
public class Solution2025022101 {

    /**
     * 题目要求迭代，咱先来个递归吧
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String next = countAndSay(n - 1);
        StringBuilder builder = new StringBuilder();
        char c = next.charAt(0);
        int count = 1;
        for (int i = 1; i < next.length(); i++) {
            if (next.charAt(i) == next.charAt(i - 1)) {
                // 和上一个字符相同
                count++;
            } else {
                // 和上一个字符不同
                builder.append(count).append(c);
                c = next.charAt(i);
                count = 1;
            }
        }
        // 好吧，哥哥，这个都给忘了?
        builder.append(count).append(c);
        return builder.toString();
    }
}

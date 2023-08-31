package com.test.leetcode.page6.chapter540.t544;

/**
 * @ClassName: Solution20230831
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/31 15:14
 * @Version: 1.0
 */
public class Solution20230831 {

    /**
     * 先来模拟吧
     * <p>
     * 12ms
     * 击败 -%使用 Java 的用户
     * 39.77MB
     * 击败 100.00%使用 Java 的用户
     * <p>
     * 击败了0%的用户，汗
     *
     * @param n
     * @return
     */
    public String findContestMatch(int n) {
        String[] array = new String[n >> 1];
        // 先第一次填充
        for (int i = 1; i <= array.length; i++) {
            array[i - 1] = "(" + i + "," + (n - i + 1) + ")";
        }
        n = n >> 1;
        while (n > 1) {
            int m = n >> 1;
            for (int i = 1; i <= m; i++) {
                array[i - 1] = "(" + array[i - 1] + "," + array[n - i] + ")";
            }
            n = m;
        }
        return array[0];
    }
}

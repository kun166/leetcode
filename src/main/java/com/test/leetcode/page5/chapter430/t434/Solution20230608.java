package com.test.leetcode.page5.chapter430.t434;

/**
 * @ClassName: Solution20230608
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/8 09:20
 * @Version: 1.0
 */
public class Solution20230608 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了41.27%的用户
     * 通过测试用例：28 / 28
     *
     * @param s
     * @return
     */
    public int countSegments(String s) {
        int ans = 0, n = s.length();
        char[] array = s.toCharArray();
        for (int i = 1; i < n; i++) {
            if (array[i] == ' ' && array[i - 1] != ' ') {
                ans++;
            }
        }
        if (n > 0 && array[n - 1] != ' ') {
            ans++;
        }
        return ans;
    }
}

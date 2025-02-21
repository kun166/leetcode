package com.test.leetcode.page6.chapter520.t524;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Official20230809
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/9 16:20
 * @Version: 1.0
 */
public class Official20230809 {

    /**
     * 动态规划，这个确实牛逼
     * <p>
     * 执行用时：5 ms, 在所有 Java 提交中击败了98.80%的用户
     * 内存消耗：43.3 MB, 在所有 Java 提交中击败了13.49%的用户
     * 通过测试用例：31 / 31
     *
     * @param s
     * @param dictionary
     * @return
     */
    public String findLongestWord(String s, List<String> dictionary) {
        int m = s.length();
        // 定义状态
        int[][] f = new int[m + 1][26];
        // 状态赋初值
        Arrays.fill(f[m], m);

        for (int i = m - 1; i >= 0; --i) {
            for (int j = 0; j < 26; ++j) {
                if (s.charAt(i) == (char) ('a' + j)) {
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }
        String res = "";
        for (String t : dictionary) {
            boolean match = true;
            int j = 0;
            for (int i = 0; i < t.length(); ++i) {
                if (f[j][t.charAt(i) - 'a'] == m) {
                    match = false;
                    break;
                }
                j = f[j][t.charAt(i) - 'a'] + 1;
            }
            if (match) {
                if (t.length() > res.length() || (t.length() == res.length() && t.compareTo(res) < 0)) {
                    res = t;
                }
            }
        }
        return res;
    }

}

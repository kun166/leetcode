package com.test.leetcode.page2.chapter130.t139;

import java.util.*;

/**
 * @ClassName: Other2025031901
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/19 17:14
 * @Version: 1.0
 */
public class Other2025031901 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }
        Set<String> words = new HashSet<>(wordDict);

        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= Math.max(i - maxLen, 0); j--) {
                if (f[j] && words.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }

}

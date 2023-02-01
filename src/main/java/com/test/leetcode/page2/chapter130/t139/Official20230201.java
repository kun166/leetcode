package com.test.leetcode.page2.chapter130.t139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: Official20230201
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/1 16:36
 * @Version: 1.0
 */
public class Official20230201 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

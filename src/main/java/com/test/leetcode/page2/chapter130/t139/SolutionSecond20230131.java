package com.test.leetcode.page2.chapter130.t139;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName: SolutionSecond20230131
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/31 16:46
 * @Version: 1.0
 */
public class SolutionSecond20230131 {

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aaa");
        System.out.println(wordBreak("aaaaaaa", list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Set<String>> map = new HashMap<>();
        for (String str : wordDict) {
            map.putIfAbsent(str.length(), new HashSet<>());
            map.get(str.length()).add(str);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (!dp[i]) {
                    continue;
                }
                int length = list.get(j);
                if (i + length <= s.length() && map.get(length).contains(s.substring(i, i + length))) {
                    dp[i + length] = dp[i + length] || dp[i];
                }
            }
        }
        return dp[s.length()];
    }
}
